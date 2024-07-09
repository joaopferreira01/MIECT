from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa

def generate_rsa_key_pair(key_length):
    private_key = rsa.generate_private_key(
        public_exponent=65537,
        key_size=key_length,
        backend=default_backend()
    )
    return private_key

def save_key_to_file(key, filename, key_type):
    with open(filename, 'wb') as key_file:
        if key_type == 'private':
            key_bytes = key.private_bytes(
                encoding=serialization.Encoding.PEM,
                format=serialization.PrivateFormat.TraditionalOpenSSL,
                encryption_algorithm=serialization.NoEncryption()
            )
        elif key_type == 'public':
            key_bytes = key.public_bytes(
                encoding=serialization.Encoding.PEM,
                format=serialization.PublicFormat.SubjectPublicKeyInfo
            )
        key_file.write(key_bytes)

def main():
    key_length = int(input("Enter the key length (1024, 2048, 3072, or 4096): "))
    private_key_filename = input("Enter the private key filename (e.g., private_key.pem): ")
    public_key_filename = input("Enter the public key filename (e.g., public_key.pem): ")

    private_key = generate_rsa_key_pair(key_length)

    save_key_to_file(private_key, private_key_filename, 'private')
    save_key_to_file(private_key.public_key(), public_key_filename, 'public')

    print(f"RSA key pair generated and saved in {private_key_filename} and {public_key_filename}.")

if __name__ == "__main__":
    main()

