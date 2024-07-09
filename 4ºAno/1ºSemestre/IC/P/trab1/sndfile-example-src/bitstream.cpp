#include <iostream>
#include "bitstream.h"

int main() {
    BitStream writer("testfile.bin", std::ios::out);
    writer.writeBit(1);
    writer.writeBit(0);
    writer.writeBit(1);
    writer.close();

    BitStream reader("testfile.bin", std::ios::in);
    std::cout << reader.readBit() << std::endl;
    std::cout << reader.readBit() << std::endl;
    std::cout << reader.readBit() << std::endl;
    reader.close();

    BitStream writer2("testfile2.bin", std::ios::out);
    writer2.writeBits(5, 3);  // write multiple bits to a file -> 5 in binary is 101
    writer2.close();

    BitStream reader2("testfile2.bin", std::ios::in);
    std::cout << reader2.readBits(3) << std::endl;  // should print 5
    reader2.close();

    BitStream writer3("testfile3.bin", std::ios::out);
    writer3.writeString("Hello"); // write a string to a file
    writer3.close();

    BitStream reader3("testfile3.bin", std::ios::in);
    std::cout << reader3.readString(5) << std::endl;  // should print "Hello"
    reader3.close();

    return 0;
}
