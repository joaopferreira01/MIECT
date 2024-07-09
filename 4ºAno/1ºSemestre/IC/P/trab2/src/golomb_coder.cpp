#include <iostream>
#include <string>
#include <cmath>
#include "golomb_coder.h"

using namespace std;

GolombCoder::GolombCoder(int m) : m(m) {}

string GolombCoder::intToBinary(int n, int bits) {
    string binary = string(bits, '0');
    for (int i = bits - 1; i >= 0; --i) {
        binary[i] = (n % 2) ? '1' : '0';
        n /= 2;
    }
    return binary;
}

int GolombCoder::binaryToInt(const string &binary) {
    int num = 0;
    for (char bit : binary) {
        num = num * 2 + (bit - '0');
    }
    return num;
}

string GolombCoder::encodeGolomb(int num) {
    int q = num / m;
    int r = num % m;
    int bits = ceil(log2(m));
    string qBits = string(q, '1') + "0";
    string rBits = intToBinary(r, bits);

    return qBits + rBits;
}

int GolombCoder::decodeGolomb(const string& golomb) {
    int q = 0;
    int index = 0;

    // Count the number of '1's until '0' is encountered
    while (golomb[index] == '1') {
        q++;
        index++;
    }
    // Skip the '0'
    index++;

    // Calculate the number of bits for the remainder
    int b = ceil(log2(m));
    int rBitsLength = b - ((1 << b) - m);
    string rBits = golomb.substr(index, rBitsLength);

    int r = binaryToInt(rBits);
    return q * m + r;
}

string GolombCoder::encode(int num, const string& mode) {
    bool isNegative = num < 0;
    string encoded;
    if (mode == "sign-magnitude") {
        string signBit = isNegative ? "1" : "0";
        num = abs(num);
        encoded = signBit + encodeGolomb(num);
    } else if (mode == "interleaving") {
        num = (num >= 0) ? (2 * num) : (-2 * num - 1);
        encoded = encodeGolomb(num);
    }
    return encoded;
}

int GolombCoder::decode(const string& encoded, const string& mode) {
    int num = 0;
    if (mode == "sign-magnitude") {
        bool isNegative = encoded[0] == '1';
        num = decodeGolomb(encoded.substr(1)); // Decode Golomb part, excluding the sign bit
        return isNegative ? -num : num;
    } else if (mode == "interleaving") {
        num = decodeGolomb(encoded);
        if (num % 2 == 0) { // Even numbers are positive
            return num / 2;
        } else { // Odd numbers are negative
            return -((num + 1) / 2);
        }
    }
    return num; // Fallback, should not occur
}

int main(int argc, char *argv[]) {

    if(argc != 3) {
        cerr << "Usage: " << argv[0] << " <number_to_encode_and_decode> <sign-magnitude | interleaving>\n";
        return 1;
    }

    int number = 0;
    try
    {
        number = stoi(argv[argc-2]);
    }
    catch(const exception& e)
    {
        cerr << "Error: invalid number" << '\n';
        return 1;
    }

    string mode { argv[argc-1] };
    if (mode != "sign-magnitude" && mode != "interleaving")
    {
        cerr << "Error: invalid mode" << '\n';
        return 1;
    }

    GolombCoder golomb(2); // Example with m = 2

    // Example with interleaving
    string encoded = golomb.encode(number, mode); // Encode -5 using interleaving

    cout << "Original: " << number << endl;
    cout << "Encoded: " << encoded << endl;
    int decoded = golomb.decode(encoded, mode); // Decode using interleaving
    cout << "Decoded: " << decoded << endl;
    return 0;
}