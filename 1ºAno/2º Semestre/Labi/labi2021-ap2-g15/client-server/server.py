#!/usr/bin/python3

import sys
import socket
import select
import json
import base64
import csv
import random
from common_comm import send_dict, recv_dict, sendrecv_dict
#from Crypto.Cipher import AES

# Dicionário com a informação relativa aos clientes
gamers = {}


# return the client_id of a socket or None
def find_client_id(client_sock):
    for id in gamers:
        if client_sock == gamers[id]['socket']:
            return id
    return None


# Função para encriptar valores a enviar em formato json com codificação base64
# return int data encrypted in a 16 bytes binary string and coded base64
def encrypt_intvalue(client_id, data):
    return None


# Função para desencriptar valores recebidos em formato json com codificação base64
# return int data decrypted from a 16 bytes binary string and coded base64
def decrypt_intvalue(client_id, data):
    return None


#
# Incomming message structure:
# { op = "START", client_id, [cipher] }
# { op = "QUIT" }
# { op = "GUESS", number }
# { op = "STOP", number, attempts }
#
# Outcomming message structure:
# { op = "START", status, max_attempts }
# { op = "QUIT" , status }
# { op = "GUESS", status, result }
# { op = "STOP", status, guess }


#
# Suporte de descodificação da operação pretendida pelo cliente
#
def new_msg(client_sock):
    # read the client request
    req = recv_dict(client_sock)
    # detect the operation requested by the client
    # execute the operation and obtain the response (consider also operations not available)
    if req["op"] == "START":
        mens = new_client(client_sock, req)
    elif req["op"] == "QUIT":
        mens = quit_client(client_sock, req)
    elif req["op"] == "GUESS":
        mens = guess_client(client_sock, req)
    elif req["op"] == "STOP":
        mens = stop_client(client_sock, req)
    else:
        mens = {"op": req["op"], "status": False, "error": "Operação inválida!"}
    # send the response to the client
    send_dict(client_sock, mens)
    return None


#
# Suporte da criação de um novo jogador - operação START
#
def new_client(client_sock, request):
    # detect the client in the request
    print("\nTemos um pedido de entrada de " + request["client_id"] + ".")
    
    if request["client_id"] in gamers:
        resposta = {"op": "START", "status": False, "error": "Cliente já existente"}
        return resposta
    # verify the appropriate conditions for executing this operation
    for i in range(0, len(gamers.keys())):
        if request["client_id"] == list(gamers.keys())[i]:
            print("Cliente já existente.")
            return {"op": "START", "status": False, "error": "Cliente existente!"}
    # obtain the secret number and number of attempts
    print("O cliente " + request["client_id"] + " entrou no servidor com sucesso!")
    num = random.randint(0, 100)
    attempts = random.randint(10, 30)
    # process the client in the dictionary
    gamers.update({request["client_id"]: {"socket": client_sock, "cipher": None, "guess": num, "max_attempts": attempts, "attempts": 0}})
    # return response message with results or error message
    return {"op": "START", "status": True, "max_attempts": attempts}


#
# Suporte da eliminação de um cliente
#
def clean_client(client_sock):
    # obtain the client_id from his socket and delete from the dictionary
    client_id = find_client_id(client_sock)
    if client_id:
        del gamers[client_id]
        return True
    return False

#
# Suporte do pedido de desistência de um cliente - operação QUIT
#


def quit_client(client_sock, request):
    # obtain the client_id from his socket
    id = find_client_id(client_sock)
    # verify the appropriate conditions for executing this operation
    if id not in gamers:
        return {"op": "QUIT", "status": False, "error": "Cliente inexistente!"}
    # process the report file with the QUIT result
    print(f"O cliente {id} desistiu.")
    update_file(id, "QUIT")
    # eliminate client from dictionary
    clean_client(client_sock)
    # return response message with result or error message
    return {"op": "QUIT", "status": True}


#
# Suporte da criação de um ficheiro csv com o respectivo cabeçalho
#
def create_file():
    report = open('report.csv', 'w')
    writer = csv.DictWriter(report, delimiter=",", fieldnames=["client_id", "secretNumber", "maxAttempts", "attemptsMaken", "result"])
    # create report csv file with header
    writer.writeheader()


#
# Suporte da actualização de um ficheiro csv com a informação do cliente e resultado
#
def update_file(client_id, result):
    client = gamers[client_id]
    # update report csv file with the result from the client
    with open('report.csv', 'a') as fd:
        writer = csv.writer(fd)
        writer.writerow([client_id, client["guess"], client["max_attempts"], client["attempts"], result])


#
# Suporte da jogada de um cliente - operação GUESS
#
def guess_client(client_sock, request):
    # obtain the client_id from his socket
    id = find_client_id(client_sock)
    # verify the appropriate conditions for executing this operation
    if id not in gamers:
        return {"op": "GUESS", "status": False, "error": "Cliente inexistente!"}
    elif request["number"] > gamers[id]["guess"]:
        return {"op": "GUESS", "status": True, "result": "smaller"}
    elif request["number"] < gamers[id]["guess"]:
        return {"op": "GUESS", "status": True, "result": "larger"}
    elif request["number"] == gamers[id]["guess"]:
        return {"op": "GUESS", "status": True, "result": "equals"}
    gamers[id]["attempts"] += 1


#
# Suporte do pedido de terminação de um cliente - operação STOP
#
def stop_client(client_sock, request):
    # obtain the client_id from his socket
    id = find_client_id(client_sock)
    resposta = ""
    # verify the appropriate conditions for executing this operation
    if id not in gamers:
        return {"op": "QUIT", "status": False, "error": "Cliente inexistente!"}

    if request["attempts"] != gamers[id]["attempts"]:
        resposta = {"op": "QUIT", "status": False, "error": "Número de jogadas inconsistente"}
        clean_client(client_sock)
        return resposta
    else:
        if request["number"] == gamers[id]["guess"]:
            if request["attempts"] > gamers[id]["max_attempts"]:
                print("O jogador " + id + " acertou!\nNúmero de jogadas do client inconsistente!")
                resposta = {"op": "STOP", "status": True, "guess": gamers[id]["guess"]}
                update_file(id, "FAILURE")
                clean_client(client_sock)
                return resposta
            else:
                print("O jogador " + id + " acertou!")
                resposta = {"op": "STOP", "status": True, "guess": gamers[id]["guess"]}
                update_file(id, "SUCCESS")
                clean_client(client_sock)
                return resposta
    # process the report file with the SUCCESS/FAILURE result
    # eliminate client from dictionary
    # return response message with result or error message


def main():
    # validate the number of arguments and eventually print error message and exit with error
    # verify type of of arguments and eventually print error message and exit with error

    if len(sys.argv) != 2:
        print("Erro: Número inválido de argumentos!")
        sys.exit(1)
    elif not sys.argv[1].isnumeric():
        print("Erro: Porto inválido!")
        sys.exit(2)
    elif int(sys.argv[1]) < 0 or int(sys.argv[1]) > 65535:
        print("Erro: Porto inválido!")
        sys.exit(2)

    port = int(sys.argv[1])

    print("Servidor ligado!\n")
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(("127.0.0.1", port))
    server_socket.listen(10)
    create_file()
    clients = []

    while True:
        try:
            available = select.select([server_socket] + clients, [], [])[0]
        except ValueError:
            # Sockets may have been closed, check for that
            for client_sock in clients:
                if client_sock.fileno() == -1:
                    client_sock.remove(client)  # closed
            continue  # Reiterate select

        for client_sock in available:
            # New client?
            if client_sock is server_socket:
                newclient, addr = server_socket.accept()
                clients.append(newclient)
            # Or an existing client
            else:
                # See if client sent a message
                if len(client_sock.recv(1, socket.MSG_PEEK)) != 0:
                    # client socket has a message
                    # print ("server" + str (client_sock))
                    new_msg(client_sock)
                else:  # Or just disconnected
                    print("O cliente saiu.")
                    clients.remove(client_sock)
                    clean_client(client_sock)
                    client_sock.close()
                    break  # Reiterate select


if __name__ == "__main__":
    main()
