from network import LoRa
import socket
import time
import pycom

# List of frequencies to test
frequencies = [868100000, 868300000, 868500000]  
            #  868.1 Mhz, 868.3 Mhz, 868.5 Mhz

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868, frequency=frequencies[0])
print("Frequency: {} MHz\n".format(frequencies[0]/1000000))

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