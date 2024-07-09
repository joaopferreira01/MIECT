from network import LoRa
import socket
import time

MAX_PACKETS = 10
packet_count = 0
ping_count = 0

# List of bandwidth values to test
bandwidths_lora = [LoRa.BW_125KHZ, LoRa.BW_250KHZ, LoRa.BW_500KHZ]
bandwidths = ["125KHZ","250KHZ","500KHZ"]
# Sender device bandwith should be the same


for bandwidth in bandwidths_lora:
    lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868, bandwidth=bandwidth)
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
    packet_loss = (1 - (float(ping_count) / MAX_PACKETS)) * 100

    print("Bandwidth: {}, Packet Loss: {}%\n".format(bandwidths[bandwidth], packet_loss))

    # Reset counters for the next iteration
    packet_count = 0
    ping_count = 0
