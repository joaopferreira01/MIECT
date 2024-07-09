from network import LoRa
import socket
import time

MAX_PACKETS = 3
packet_count = 0
ping_count = 0

# List of frequencies to test
frequencies = [868000000, 868100000, 868300000, 868500000]  
        
 
for frequency in frequencies:
    lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868, frequency=frequency)
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

    print("Frequency: {}Mhz, Packet Loss: {}%\n".format(frequency/1000000, packet_loss))

    # Reset counters for the next iteration
    packet_count = 0
    ping_count = 0
