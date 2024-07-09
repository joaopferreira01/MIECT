#include "bitstream.h"
#include <string>
#include <iostream>

using namespace std;

// o ultimo buffer tem de ser escrito para o ficheiro mesmo que nao esteja completo
// tem de haver indicação mesmo que seja no header do ficheiro de quantos bits foram escritos para no decoder saber quantos bits tem de ler
// o decoder tem de ler o header para saber quantos bits tem de ler

// Encoder: Converts a text file with 0s and 1s to its binary representation
int main(int argc, char* argv[]) {
    if (argc != 3) {
        cerr << "Usage: <program> <inputFile> <outputFile>" << std::endl;
        return 1;
    }

    string inputFilename = argv[1];
    string outputFilename = argv[2];

    BitStream outStream(outputFilename, ios::out);
    ifstream inputFile(inputFilename);

    char c;
    uint64_t value = 0;
    int count = 0;
    int totalBits = 0;

    // Calculate total number of bits first.
    while (inputFile.get(c)) {
        if (c == '0' || c == '1') {
            totalBits++;
        }
    }

    // Write the total number of bits to the output file as a 32-bit integer.
    outStream.writeBits(static_cast<uint64_t>(totalBits), 32);

    // Reset input file and start encoding.
    inputFile.clear();
    inputFile.seekg(0, ios::beg);

    // Read each character from the input file
    while (inputFile.get(c)) {
        // If the character is not a 0 or 1, ignore it
        if (c == '0' || c == '1') {
            value = (value << 1) | (c - '0');  // Shift and append bit
            count++;                           // Increment bit count
        }

        // If we have 8 bits, write them to the output file
        if (count == 8){
            outStream.writeBits(value, count);
            count = 0;
            value = 0;
        }
    }

    // Write any remaining bits to the output file
    if (count > 0) {
        outStream.writeBits(value, count);
        outStream.close();
    }

    return 0;
}
