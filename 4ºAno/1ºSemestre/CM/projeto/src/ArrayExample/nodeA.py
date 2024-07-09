from network import LoRa
import socket
import time

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868 )
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)

sequence_number = 0
data_array = []
print("\n")

while True:
    while sequence_number <= 15:
        # append sequence number to array
        data_array.append(sequence_number)
        # send the packet s.send()
        s.send(bytes([i for i in data_array]))
        
        # Print what was sent
        print("Sent:", [i for i in range(sequence_number + 1)])
        time.sleep(0.2)

        sequence_number += 1
    sequence_number = 0
    data_array = []
    time.sleep(7)

