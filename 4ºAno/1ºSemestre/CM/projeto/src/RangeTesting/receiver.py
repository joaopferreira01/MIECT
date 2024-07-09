from network import LoRa
import socket
import time

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)


while True:
    if s.recv(64) == b'Ping':
        s.send('Pong')
        print('ACK!')
    else:
        print("Nothing received!")

    time.sleep(1)
