#ifndef GOLOMB_CODER_H
#define GOLOMB_CODER_H

#include <string>
#include <bitset>
#include <cmath>

using namespace std;

class GolombCoder
{
private:
    int m;
    uint32_t m_decode, m_encode;

    string intToBinary(int n, int bits);
    int binaryToInt(const string &binary);
    string encodeGolomb(int num);
    int decodeGolomb(const string &golomb);

public:
    GolombCoder(int m);
    GolombCoder(){
            this->m_encode = 1000;
            this->m_decode = 1000;
        }

    string encode(int num, const string &mode);
    int decode(const string &encoded, const string &mode);

    char *decode_string(char *p_bits, long *result_n, int mapping_on);

    uint32_t get_m_decode()
    {
        return this->m_decode;
    }

    void change_m_encode(uint32_t m)
    {
        this->m_encode = m;
    }

    uint32_t get_m_encode()
    {
        return this->m_encode;
    }

    void change_m_decode(uint32_t m)
    {
        this->m_decode = m;
    }
};

#endif