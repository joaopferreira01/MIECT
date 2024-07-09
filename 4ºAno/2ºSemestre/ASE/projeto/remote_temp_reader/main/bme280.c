#include <stdio.h>
#include "driver/i2c.h"
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "esp_log.h"

#define I2C_MASTER_SCL_IO          22    /*!< GPIO number for I2C master clock */
#define I2C_MASTER_SDA_IO          21    /*!< GPIO number for I2C master data  */
#define I2C_MASTER_NUM             I2C_NUM_0 /*!< I2C port number for master dev */
#define I2C_MASTER_FREQ_HZ         100000 /*!< I2C master clock frequency */
#define I2C_MASTER_TX_BUF_DISABLE  0     /*!< I2C master doesn't need buffer */
#define I2C_MASTER_RX_BUF_DISABLE  0     /*!< I2C master doesn't need buffer */
#define I2C_MASTER_TIMEOUT_MS      1000

#define BME280_SENSOR_ADDR         0x76  /*!< I2C address for BME280 */
#define BME280_CMD_MEASURE         0xF7  /*!< Start measurement command */

typedef struct {
    int32_t temperature;
    uint32_t pressure;
    uint32_t humidity;
} bme280_raw_data_t;

typedef struct {
    float temperature;
    float pressure;
    float humidity;
} bme280_data_t;

static esp_err_t i2c_master_init(void) {
    i2c_config_t conf = {
        .mode = I2C_MODE_MASTER,
        .sda_io_num = I2C_MASTER_SDA_IO,
        .scl_io_num = I2C_MASTER_SCL_IO,
        .sda_pullup_en = GPIO_PULLUP_ENABLE,
        .scl_pullup_en = GPIO_PULLUP_ENABLE,
        .master.clk_speed = I2C_MASTER_FREQ_HZ,
    };
    esp_err_t err = i2c_param_config(I2C_MASTER_NUM, &conf);
    if (err != ESP_OK) {
        return err;
    }
    return i2c_driver_install(I2C_MASTER_NUM, conf.mode, I2C_MASTER_RX_BUF_DISABLE, I2C_MASTER_TX_BUF_DISABLE, 0);
}

static esp_err_t bme280_i2c_read(uint8_t reg_addr, uint8_t *data, size_t len) {
    esp_err_t ret = i2c_master_write_read_device(I2C_MASTER_NUM, BME280_SENSOR_ADDR, &reg_addr, 1, data, len, I2C_MASTER_TIMEOUT_MS / portTICK_RATE_MS);
    return ret;
}

static esp_err_t bme280_i2c_write(uint8_t reg_addr, uint8_t data) {
    uint8_t write_buf[2] = { reg_addr, data };
    return i2c_master_write_to_device(I2C_MASTER_NUM, BME280_SENSOR_ADDR, write_buf, sizeof(write_buf), I2C_MASTER_TIMEOUT_MS / portTICK_RATE_MS);
}

static esp_err_t bme280_init() {
    uint8_t id;
    bme280_i2c_read(0xD0, &id, 1); // Read chip ID register
    if (id != 0x60) {
        return ESP_FAIL; // Check if the ID matches BME280
    }

    bme280_i2c_write(0xF2, 0x01); // Humidity oversampling x1
    bme280_i2c_write(0xF4, 0x27); // Pressure and Temperature oversampling x1, Normal mode
    bme280_i2c_write(0xF5, 0xA0); // Config register (standby time 1000ms, filter off)

    return ESP_OK;
}

static esp_err_t bme280_read_raw(bme280_raw_data_t *raw_data) {
    uint8_t data[8];
    bme280_i2c_read(0xF7, data, 8);

    raw_data->pressure = (data[0] << 12) | (data[1] << 4) | (data[2] >> 4);
    raw_data->temperature = (data[3] << 12) | (data[4] << 4) | (data[5] >> 4);
    raw_data->humidity = (data[6] << 8) | data[7];

    return ESP_OK;
}

static void bme280_convert_raw(bme280_raw_data_t *raw, bme280_data_t *data) {
    // Compensation formulas from the BME280 datasheet
    // These functions are just placeholders and need to be completed
    // based on the calibration data from the BME280 datasheet.

    int32_t t_fine;
    int32_t var1, var2;

    var1 = ((((raw->temperature >> 3) - (calib.dig_T1 << 1))) * (calib.dig_T2)) >> 11;
    var2 = (((((raw->temperature >> 4) - (calib.dig_T1)) * ((raw->temperature >> 4) - (calib.dig_T1))) >> 12) * (calib.dig_T3)) >> 14;
    t_fine = var1 + var2;
    data->temperature = (t_fine * 5 + 128) >> 8;

    int64_t var1p, var2p, p;
    var1p = ((int64_t)t_fine) - 128000;
    var2p = var1p * var1p * (int64_t)calib.dig_P6;
    var2p = var2p + ((var1p * (int64_t)calib.dig_P5) << 17);
    var2p = var2p + (((int64_t)calib.dig_P4) << 35);
    var1p = ((var1p * var1p * (int64_t)calib.dig_P3) >> 8) + ((var1p * (int64_t)calib.dig_P2) << 12);
    var1p = (((((int64_t)1) << 47) + var1p)) * ((int64_t)calib.dig_P1) >> 33;

    if (var1p == 0) {
        data->pressure = 0; // Avoid exception caused by division by zero
    } else {
        p = 1048576 - raw->pressure;
        p = (((p << 31) - var2p) * 3125) / var1p;
        var1p = (((int64_t)calib.dig_P9) * (p >> 13) * (p >> 13)) >> 25;
        var2p = (((int64_t)calib.dig_P8) * p) >> 19;
        p = ((p + var1p + var2p) >> 8) + (((int64_t)calib.dig_P7) << 4);
        data->pressure = (uint32_t)p / 256;
    }

    int32_t v_x1_u32r;
    v_x1_u32r = (t_fine - ((int32_t)76800));
    v_x1_u32r = (((((raw->humidity << 14) - (((int32_t)calib.dig_H4) << 20) - (((int32_t)calib.dig_H5) * v_x1_u32r)) + ((int32_t)16384)) >> 15) * (((((((v_x1_u32r * ((int32_t)calib.dig_H6)) >> 10) * (((v_x1_u32r * ((int32_t)calib.dig_H3)) >> 11) + ((int32_t)32768))) >> 10) + ((int32_t)2097152)) * ((int32_t)calib.dig_H2) + 8192) >> 14));
    v_x1_u32r = (v_x1_u32r - (((((v_x1_u32r >> 15) * (v_x1_u32r >> 15)) >> 7) * ((int32_t)calib.dig_H1)) >> 4));
    v_x1_u32r = (v_x1_u32r < 0 ? 0 : v_x1_u32r);
    v_x1_u32r = (v_x1_u32r > 419430400 ? 419430400 : v_x1_u32r);
    data->humidity = (uint32_t)(v_x1_u32r >> 12);
}

void app_main(void) {
    ESP_ERROR_CHECK(i2c_master_init());
    ESP_ERROR_CHECK(bme280_init());

    bme280_raw_data_t raw_data;
    bme280_data_t data;

    while (1) {
        bme280_read_raw(&raw_data);
        bme280_convert_raw(&raw_data, &data);

        printf("Temperature: %.2f °C\n", data.temperature / 100.0);
        printf("Pressure: %.2f hPa\n", data.pressure / 100.0);
        printf("Humidity: %.2f %%\n", data.humidity / 1024.0);

        vTaskDelay(pdMS_TO_TICKS(2000)); // Read every 2 seconds
    }
}
