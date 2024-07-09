from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding

def decrypt_file(input_file, private_key_file, output_file):
    with open(private_key_file, 'rb') as key_file:
        private_key = serialization.load_pem_private_key(
            key_file.read(),
            password=None,
            backend=default_backend()
        )

    with open(input_file, 'rb') as encrypted_file:
        encrypted_data = encrypted_file.read()

    decrypted_data = private_key.decrypt(
        encrypted_data,
        padding.OAEP(
            mgf=padding.MGF1(algorithm=hashes.SHA256()),
            algorithm=hashes.SHA256(),
            label=None
        )
    )

    with open(output_file, 'wb') as decrypted_file:
        decrypted_file.write(decrypted_data)

def main():
    input_file = input("Enter the name of the file to decrypt: ")
    private_key_file = input("Enter the name of the private key file: ")
    output_file = input("Enter the name for the decrypted content file: ")

    decrypt_file(input_file, private_key_file, output_file)

    print(f"Decrypted content saved in {output_file}.")

if __name__ == "__main__":
    main()
