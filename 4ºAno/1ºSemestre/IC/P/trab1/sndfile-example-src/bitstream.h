#include <fstream>
#include <string>
#include <vector>
#include <stdexcept>
#include <iostream>

class BitStream {
private:
    std::fstream file;      // file stream for reading/writing
    unsigned char buffer;  // current byte buffer, holds the current byte
    int currBitPos;            // current position in the buffer [0, 7]
    std::string filename;

    void flushBuffer() { // write current buffer to the file if there are any bits in it
        if (currBitPos == 0) return;
        file.write(reinterpret_cast<char*>(&buffer), 1);

        // reset buffer and currBitPos
        buffer = 0;
        currBitPos = 0;
    }

public:
    // constructor
    BitStream(const std::string& filename, std::ios::openmode mode)
        : buffer(0), currBitPos(0) {
        this->filename = filename;
        file.open(filename, mode | std::ios::binary); // open file in binary mode
        if (!file.is_open()) {
            throw std::runtime_error("Failed to open file"); // throw exception if fails
        }
    }

    void writeBit(bool bit) { // write a single bit to the buffer
        if (bit) {
            buffer |= (1 << (7 - currBitPos)); // create a byte where only one bit is set, in the currBitPos
            // if currBitPos=3, 7-3 = 4, 1 << 4 => 0001000
        }
        currBitPos++; // go to next position
        if (currBitPos == 8) { // if buffer is full, flush the buffer to file
            flushBuffer();
        }
    }

    bool readBit() { // read a single bit from the buffer
        if (currBitPos == 0) { // if buffer is empty, read a new byte from the file.
            if (!file.read(reinterpret_cast<char*>(&buffer), 1)) {
                throw std::runtime_error("Failed to read bit");
            }
        }
        bool bit = (buffer & (1 << (7 - currBitPos))) != 0; // extract bit at the current position from  buffer.
                                // (1 << (7 - currBitPos)) -> generates a byte where only one bit is set
                                // corresponding to the current position, others are 0
        currBitPos = (currBitPos + 1) % 8; // increment position pointer
        return bit;
    }

    void writeBits(uint64_t value, int n) { // Writes n bits to the file.
        if (n < 0 || n > 64) { // check if n is in the range
            throw std::invalid_argument("Number of bits out of range");
        }
        for (int i = n - 1; i >= 0; --i) {
            writeBit((value >> i) & 1); // (value >> i) -> shift the value to the right by 1 position
                                        // & 1 -> check if the least significant bit is 1 or 0
        }
    }

    uint64_t readBits(int n) { // read n bits from file
        if (n < 0 || n > 64) {
            throw std::invalid_argument("Number of bits out of range");
        }
        uint64_t value = 0; // var to store bits from file
        for (int i = 0; i < n; ++i) { // process 1 bit from the file
            value = (value << 1) | readBit(); // (value << 1) -> shift the current value to the left by 1position
        }                           // | readBit() -> set least significant bit to the bit read from the file
        return value;
    }

    void writeString(const std::string& str) { // write each character of str as 8 bits to file
        for (char c : str) {
            writeBits(static_cast<uint64_t>(c), 8);
        }
    }

    std::string readString(int len) { // read len characters (8 bits each) from file and return as a string.
        std::string result;
        for (int i = 0; i < len; ++i) {
            result.push_back(static_cast<char>(readBits(8))); // append to result casted 8 bits readed from file
        }
        return result;
    }

    void close() { // close the file
        flushBuffer();  // flush the remaining bits in buffer to the file
        file.close();
    }
};