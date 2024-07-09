from network import LoRa
from machine import ADC
import socket
import time
import pycom

adc = ADC()
apin = adc.channel(pin='P16',attn=ADC.ATTN_11DB)

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

i = 0
while True:       
    voltage = apin.voltage()  # milivolts
    temp_kelvin = voltage/10
    temp_celsius = (temp_kelvin - 273.15)
    print("\nvoltage:",voltage)
    print("temperature(C):",temp_celsius)

    pycom.heartbeat(False)
    pycom.rgbled(0xff00)    # turn on the RGB LED in blue colour
    
    # Convert temperature to bytes
    temp_bytes = bytes(str(temp_celsius), 'utf-8')

    s.send(temp_bytes)
    i= i+1
    time.sleep(1)

    if s.recv(64) == b'Pong':
        print('Temperature succtemp_celsiusessfully sent!')


pycom.heartbeat(True)


