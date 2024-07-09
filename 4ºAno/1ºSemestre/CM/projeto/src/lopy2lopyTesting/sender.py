from network import LoRa
import socket
import time
import pycom

# Please pick the region that matches where you are using the device

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)


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