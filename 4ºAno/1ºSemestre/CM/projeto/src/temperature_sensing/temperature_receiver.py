from network import LoRa
import socket
import time
import pycom

def map_temperature_to_color(temperature):
    # Define the color gradient
    blue = (0, 0, 255)  # Blue color
    red = (255, 0, 0)   # Red color
    
    # Set the temperature range
    min_temperature = 8
    max_temperature = 20
    
    # Map the temperature to a value between 0 and 1 within the specified range
    normalized_temperature = min(1.0, max(0.0, (temperature - min_temperature) / (max_temperature - min_temperature)))
    
    # Interpolate between blue and red based on the temperature
    color = (
        int((1 - normalized_temperature) * blue[0] + normalized_temperature * red[0]),
        int((1 - normalized_temperature) * blue[1] + normalized_temperature * red[1]),
        int((1 - normalized_temperature) * blue[2] + normalized_temperature * red[2])
    )
    # Convert the RGB color tuple to a single integer
    rgb_color = color[0] << 16 | color[1] << 8 | color[2]

    return rgb_color


lora = LoRa(mode=LoRa.LORA, region=LoRa.EU868)
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
s.setblocking(False)

i = 0
while True:
    try:
        received_data = s.recv(64).decode('utf-8')
        received_number = float(received_data)
        print("Temperature(C) :", received_number)
        rgb_color = map_temperature_to_color(received_number)
        pycom.heartbeat(False)
        pycom.rgbled(rgb_color)
    except ValueError:
        print("Received data is not a number")

    time.sleep(1)
    pycom.heartbeat(True)


