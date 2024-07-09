from network import LoRa
import socket
import time

lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

error_counts = {} 
client_counter = 0 
client_ids = {} 
received_arrays = {}  
expected_lengths = {}  
last_request_times = {}  

timeout_duration = 5

print("Looking for Requests!")


while True: 
    try:
        # Receive data
        received_data = s.recv(64)

        if received_data:
            client_id = client_counter

            if client_id not in client_ids:
                client_ids[client_id] = "0x{:03X}".format(client_id)
                received_arrays[client_id] = []  
                expected_lengths[client_id] = 1  
                error_counts[client_id] = 0
                last_request_times[client_id] = time.time()

            received_array = [int(byte) for byte in received_data]
 
            print("Received from Client {}: {}".format(client_ids[client_id], received_array))
      
            # Check for lost messages
            if len(received_array) > expected_lengths[client_id] :
                lost_messages = list(range(expected_lengths[client_id], len(received_array)))
                error_counts[client_id] += len(received_array) - expected_lengths[client_id]
                print("Error = ", error_counts[client_id])
        

            expected_lengths[client_id] = len(received_array) + 1

            received_arrays[client_id] = received_array

            last_request_times[client_id] = time.time()
        else:
            
            time.sleep(1)

       
        for client_id in client_ids.copy():  
            if time.time() - last_request_times[client_id] >= timeout_duration:
                if len(received_arrays[client_id]) < 16:
                    error_counts[client_id] += (16 - len(received_arrays[client_id]))

                print("Client {} - Number of Errors: {}\n".format(client_ids[client_id], error_counts[client_id]))
                del error_counts[client_id]
                del client_ids[client_id]
                del received_arrays[client_id]
                del expected_lengths[client_id]
                del last_request_times[client_id]
                
                client_counter += 1

    except Exception as e:
        time.sleep(1)