#!/usr/bin/python3

import os
import sys
import socket
import json
import base64
from common_comm import send_dict, recv_dict, sendrecv_dict

#from Crypto.Cipher import AES

# Função para encriptar valores a enviar em formato jsos com codificação base64
# return int data encrypted in a 16 bytes binary string coded in base64
def encrypt_intvalue (cipherkey, data):
	return None


# Função para desencriptar valores recebidos em formato json com codificação base64
# return int data decrypted from a 16 bytes binary strings coded in base64
def decrypt_intvalue (cipherkey, data):
	return None


# verify if response from server is valid or is an error message and act accordingly
def validate_response (client_sock, resposta):
	if resposta["status"] == False:
		print("Erro! Operação incorreta. " + resposta["error"])
		client_sock.close()
		sys.exit(3)
	else:
		return None


# process QUIT operation

def quit_action(client_sock, tent):
    print(f"Desististe... \nFizeste {tent} tentativas")
    client_sock.close()
    sys.exit(4)
	

# Outcomming message structure:
# { op = "START", client_id, [cipher] }
# { op = "QUIT" }
# { op = "GUESS", number }
# { op = "STOP", number, attempts }
#
# Incomming message structure:
# { op = "START", status, max_attempts }
# { op = "QUIT" , status }
# { op = "GUESS", status, result }
# { op = "STOP", status, guess }


#
# Suporte da execução do cliente
#
def run_client(client_sock, client_id):
    # Operação start
    start = sendrecv_dict(client_sock, {"op": "START", "client_id": client_id})
    validate_response(client_sock, start)

    print("\nBem vindo " + client_id + ", ao Guess Game!\n\nTens " + str(start["max_attempts"]) + " tentativas para acertar no número aleatório de 0 a 100")
    tents = 0

    while 1:
        inputClient = input("Adivinha o número ou escreve 'quit' para desistir: ")
        if inputClient == "quit" or inputClient == "QUIT":
            break
        if inputClient.isnumeric():
            if (int(inputClient) < 0 or int(inputClient) > 100):
                print("\nNúmero inválido!\n")
                continue
            # Operação guess
            guess = sendrecv_dict(client_sock, {"op": "GUESS", "number": int(inputClient)})
            validate_response(client_sock, guess)
            tents += 1
            tentRestantes = start["max_attempts"] - tents
            if (guess["result"]) == "smaller":
                print("\nTenta um número menor. \nTentativas efetuadas: " + str(tents) + "\nTentativas restantes: " + str(tentRestantes)+"\n")
            elif (guess["result"]) == "larger":
                print("\nTenta um número maior. \nTentativas efetuadas: " + str(tents) + "\nTentativas restantes: " + str(tentRestantes) + "\n")
            elif (guess["result"]) == "equals":
                print("\nParabéns, acertaste!\nTentativas efetuadas: " + str(tents) + "\nTentativas restantes: " + str(tentRestantes)+"\n")
                stop = sendrecv_dict(client_sock, {"op": "STOP", "number": int(inputClient), "attempts": int(tents)})
                validate_response(client_sock, stop)
                client_sock.close()
                sys.exit(4)
        else:
            print(f"Operação {inputClient} inexistente!")

    # Operação quit
    quit = sendrecv_dict(client_sock, {"op": "QUIT"})
    validate_response(client_sock, quit)
    quit_action(client_sock, tents)


def main():
	# validate the number of arguments and eventually print error message and exit with error
	# verify type of of arguments and eventually print error message and exit with error

	hostname = '127.0.0.1'
	
	if len(sys.argv) < 3 or len(sys.argv) > 4:
		print("Número inválido de argumentos!")
		sys.exit(1)
	elif len(sys.argv) == 4:
		hostname = sys.argv[3]
	if not sys.argv[2].isnumeric():
		print("Porto inválido!")
		sys.exit(2)
	if int(sys.argv[2])<0 or int(sys.argv[2])>2147483647:
		print("Porto inválido")
		sys.exit(2)

	port = int(sys.argv[2])

	client_sock = socket.socket (socket.AF_INET, socket.SOCK_STREAM)
	client_sock.connect ((hostname, port))

	run_client (client_sock, sys.argv[1])

	client_sock.close ()
	sys.exit(0)

if __name__ == "__main__":
    main()