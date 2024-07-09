#ifndef GOLOMB_H
#define GOLOMB_H

#include <iostream>
#include <map>
#include <bitset>
#include <stdio.h>
#include <stdlib.h>
#include <bits/stdc++.h>

using namespace std;

class golomb
{
private:
    uint32_t m_encode, m_decode;

    string encode_unary(uint32_t n)
    {
        uint32_t f = n / m_encode;
        string unary = "";
        for (uint32_t i = 0; i < f; i++)
        {
            unary += "1";
        }
        unary += "0";
        return unary;
    }

    // receives natural number and returns the binary string of decimal part
    string encode_decimal(uint32_t n)
    {
        // calculate decimal part
        uint32_t r = n % m_encode;
        uint32_t b = floor(log2(m_encode));
        string bin;

        if (r < (pow(2, b + 1) - m_encode))
        {
            bitset<32> bin_r(r);
            // cut string to b bits
            bin = bin_r.to_string();
            bin.erase(0, bin.size() - b);
        }
        else
        {
            r = r + pow(2, b + 1) - m_encode;
            bitset<32> bin_r(r);
            // cut string to b+1 bits
            bin = bin_r.to_string();
            bin.erase(0, bin.size() - (b + 1));
        }

        return bin;
    }

public:
    golomb(uint32_t m)
    {
        this->m_encode = m;
        this->m_decode = m;
    }

    golomb()
    {
        this->m_encode = 1000;
        this->m_decode = 1000;
    }

    // decode binary string to decimal
    char *decode_string(char *p_bits, long *result_n, int mapping_on)
    {

        // counted number of 1s is the unary part stop at 0
        uint32_t count = 0;
        uint32_t index = 0;
        // calculate index of null char in p_bits

        while (p_bits[index] != '0' && p_bits[index] != '\0')
        {
            count++;
            index++;
        }

        // read b bits from p_bits to key
        uint32_t b = floor(log2(m_decode));
        string key = "";
        for (uint32_t i = 0; i < b; i++)
        {
            index++;
            key += p_bits[index];
        }
        for (uint32_t i = 0; i < key.size(); i++)
        {
            if (key[i] != '0' && key[i] != '1')
            {
                key.erase(i);
            }
        }
        uint32_t decimal = (uint32_t)bitset<32>(key).to_ulong(); // transform key to uint32_t
        if (!(decimal < (pow(2, (b + 1)) - m_decode)))
        {
            index++;
            key += p_bits[index];
            for (uint32_t i = 0; i < key.size(); i++)
            {
                if (key[i] != '0' && key[i] != '1')
                {
                    key.erase(i);
                }
            }
            decimal = (uint32_t)bitset<32>(key).to_ulong(); // r
            decimal = decimal - pow(2, (b + 1)) + m_decode; // r = r' - 2^(b+1) + m
        }

        uint32_t result = count * m_decode + decimal;
        *result_n = (long)result;
        if (mapping_on)
        {
            if (result % 2 == 0)
            {
                *result_n = (long)(*result_n / -2);
            }
            else
            {
                *result_n = (long)((*result_n - 1) / 2);
            }
        }

        p_bits += (index + 1);
        return p_bits;
    }

    string encode_number(int n, int mapping_on)
    {
        uint32_t mapped;
        if (mapping_on)
        {
            if (n < 0)
            {
                mapped = -2 * n;
            }
            else
            {
                mapped = (2 * n) + 1;
            }
        }
        else
        {
            mapped = n;
        }

        string unary = encode_unary(mapped);
        string binary = encode_decimal(mapped);

        return unary + binary;
    }

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
    };
};

#endif