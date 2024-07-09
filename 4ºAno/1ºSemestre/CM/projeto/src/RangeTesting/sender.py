from network import LoRa
import socket
import time

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

i = 0
errors = 0
ping_count = 15

while True:
    for _ in range(ping_count):
        s.send('Ping')
        print('Ping {}'.format(i))
        i += 1
        time.sleep(1)

        data = s.recv(64)
        if data == b'Pong':
            print("ACK")
        else:
            errors += 1
            print("No response from server. Errors = {}".format(errors))

    i = 0
    errors = 0
    time.sleep(5)
