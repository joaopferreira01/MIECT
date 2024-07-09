from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import rsa, padding

def encrypt_file(original_file, public_key_file, encrypted_file):
    with open(public_key_file, 'rb') as key_file:
        public_key = serialization.load_pem_public_key(
            key_file.read(),
            backend=default_backend()
        )

    with open(original_file, 'rb') as file_to_encrypt:
        data = file_to_encrypt.read()

    # Calculate the block size based on the key size
    key_size = public_key.key_size // 8
    block_size = key_size - 11

    # Encrypt the data in blocks
    encrypted_data = b""
    for i in range(0, len(data), block_size):
        block = data[i:i+block_size]
        encrypted_block = public_key.encrypt(
            block,
            padding.OAEP(
                mgf=padding.MGF1(algorithm=hashes.SHA256()),
                algorithm=hashes.SHA256(),
                label=None
            )
        )
        encrypted_data += encrypted_block

    with open(encrypted_file, 'wb') as encrypted_file:
        encrypted_file.write(encrypted_data)

def main():
    original_file = input("Enter the name of the original file to encrypt: ")
    public_key_file = input("Enter the name of the public key file: ")
    encrypted_file = input("Enter the name for the encrypted file: ")

    encrypt_file(original_file, public_key_file, encrypted_file)

    print(f"File encrypted and saved in {encrypted_file}.")

if __name__ == "__main__":
    main()
