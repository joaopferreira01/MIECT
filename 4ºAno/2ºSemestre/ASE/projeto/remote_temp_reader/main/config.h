#ifndef CONFIG_H
#define CONFIG_H

#define WIFI_SSID "goncalo-x1"
#define WIFI_PASS "yBJV3Jg1"

#define MQTT_SERVER "mqtt://172.17.0.1"
#define MQTT_PORT 1883

// Definições de pinos I2C
#define I2C_MASTER_SCL_IO 1
#define I2C_MASTER_SDA_IO 0
#define I2C_MASTER_NUM I2C_NUM_0
#define I2C_MASTER_FREQ_HZ 100000
#define TC74_ADDR 0x49

// Definições de pinos SPI do SD
#define PIN_NUM_MISO 4
#define PIN_NUM_MOSI 3
#define PIN_NUM_CLK 10
#define PIN_NUM_CS 2

#endif // CONFIG_H