#include "bitstream.h"
#include <string>
#include <iostream>

using namespace std;

// Decoder: Converts a binary file to a text file with 0s and 1s
int main(int argc, char* argv[]) {
    if (argc != 3) {
        cerr << "Usage: <program> <inputFile> <outputFile>" << endl;
        return 1;
    }

    string inputFilename = argv[1];
    string outputFilename = argv[2];

    BitStream inStream(inputFilename, ios::in);
    ofstream outputFile(outputFilename);

    // Read the total number of bits from the input file
    uint64_t totalBitsToDecode = inStream.readBits(32);

    // Read each bit from the input file
    while (totalBitsToDecode > 0) {
        // Determine the number of bits to read in this batch (up to 64)
        uint64_t bitsToRead = min(totalBitsToDecode, static_cast<uint64_t>(64));

        // Read totalBitsToDecode bits from the input file
        uint64_t byteValue = inStream.readBits(bitsToRead);

        // Write each bit to the output file
        for (int i = bitsToRead - 1; i >= 0; --i) {
            outputFile << ((byteValue >> i) & 1);  // Extract each bit and write to file
        }

        totalBitsToDecode -= bitsToRead;
    }
}
