import time
from machine import ADC

adc = ADC()
apin = adc.channel(pin='P16',attn=ADC.ATTN_11DB)


while True:
  voltage = apin.voltage()  # milivolts
  temp_kelvin = voltage/10
  temp_celsius = (temp_kelvin - 273.15)
  print("\nvoltage:",voltage)
  #print("temperature(K):",temp_kelvin)
  print("temperature(C):",temp_celsius)
  time.sleep(5)