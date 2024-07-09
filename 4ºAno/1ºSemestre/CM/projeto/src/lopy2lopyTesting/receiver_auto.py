from network import LoRa
import socket
import time

MAX_PACKETS = 50
packet_count = 0
ping_count = 0

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)

s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

while packet_count < MAX_PACKETS:
    recv_data = s.recv(64)
    
    if recv_data == b'Ping':
        ping_count += 1
        s.send('Pong')
        print('ACK!')
    else:
        print("Nothing received!")

    packet_count += 1
    time.sleep(1)

# Calculate packet loss
packet_loss = (1 - (float(ping_count) / MAX_PACKETS) )*100

print("Packet Loss: ", packet_loss, "%")

# Write data to a file
# file_path = 'packet_loss_data.txt'
# with open(file_path, 'w') as file:
#     file.write('Frequency: {}\n'.format(lora.frequency()))
#     file.write('Packet Loss: {}\n'.format(packet_loss))

# file.close()
#print('Data written to', file_path)