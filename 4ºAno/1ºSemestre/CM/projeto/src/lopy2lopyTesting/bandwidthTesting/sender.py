from network import LoRa
import socket
import time
import pycom

# List of bandwidth values to test
bandwidths_lora = [LoRa.BW_125KHZ, LoRa.BW_250KHZ, LoRa.BW_500KHZ]
bandwidths = ["125KHZ","250KHZ","500KHZ"]

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868, bandwidth=bandwidths_lora[0])
print("Bandwidth: {}\n".format(bandwidths[0]))

s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

i = 0
while True:       
    s.send('Ping')
    print('Ping {}'.format(i))
    i= i+1
    time.sleep(1)

    if s.recv(64) == b'Pong':
        print('ACK!')


pycom.heartbeat(True)