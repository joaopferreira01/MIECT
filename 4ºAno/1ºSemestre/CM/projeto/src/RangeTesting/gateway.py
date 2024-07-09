from network import LoRa
import socket
import time

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

receiver_socket = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
receiver_socket.setblocking(False)

i = 0
while True:
    # Forward messages from sender to receiver
    sender_data = s.recv(64)
    if sender_data:
        receiver_socket.send(sender_data)
        print('Forwarded: {}'.format(sender_data))

    # Check for incoming messages from the receiver
    receiver_data = receiver_socket.recv(64)
    if receiver_data:
        print('Received from Receiver: {}'.format(receiver_data))

    time.sleep(1)
