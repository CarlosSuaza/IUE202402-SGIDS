import socket
import threading

def handle_client(client_socket):
    while True:
        try:
            # Receive data from the client
            request = client_socket.recv(1024)
            if not request:
                break
            # Process the request (e.g., command to be executed)
            print(f"Received command: {request.decode()}")
            # Optionally, execute the command or send a response
            client_socket.send(b"Command received")
        except Exception as e:
            print(f"Error: {e}")
            break
    client_socket.close()

def start_botnet_server():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(('0.0.0.0', 9999))
    server.listen(5)
    print("Botnet server listening on port 9999")

    while True:
        client_socket, addr = server.accept()
        print(f"Accepted connection from {addr}")
        client_handler = threading.Thread(target=handle_client, args=(client_socket,))
        client_handler.start()

if __name__ == "__main__":
    start_botnet_server()