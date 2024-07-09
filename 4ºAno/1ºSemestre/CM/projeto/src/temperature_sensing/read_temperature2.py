import time
from machine import ADC

adc = ADC()
apin = adc.channel(pin='P16',attn=ADC.ATTN_11DB)


while True:
  voltage = apin.voltage()/1000
  temp_celsius = (voltage-0.5)*10
  print("\nvoltage:",voltage)
  print("temperature(C):",temp_celsius)
  time.sleep(1)