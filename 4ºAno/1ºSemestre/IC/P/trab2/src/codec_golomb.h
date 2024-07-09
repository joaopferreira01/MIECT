#ifndef CODEC_GOLOMB_H
#define CODEC_GOLOMB_H

#include <bitset>
#include <stdio.h>
#include <stdlib.h>
#include <bits/stdc++.h>
#include <fstream>
#include <sndfile.hh>

#include "golomb_coder.h"

using namespace std;

constexpr size_t FRAMES_BUFFER_SIZE = 65536; // Buffer for reading/writing frames

class golomb_codec
{
private:
    GolombCoder codec_alg;
    char buffer = 0;
    int count = 0, order, lossless, cut_n_bits;
    uint32_t x, y;

    int write_wav_file(const char *fileOut, vector<short> &samples, int format, int samplerate, int num_channels);

    int write_bin_to_file(const char *fileOut, string encoded);

    string read_bin_from_file(const char *fileIn);

    uint32_t calc_m(double avg);

public:
    golomb_codec(int n_order, int x_in, int y_in, int lossless_on, int cut_bits) : codec_alg()
    {
        order = n_order;
        x = x_in;
        y = y_in;
        lossless = lossless_on;
        cut_n_bits = cut_bits;
    };
    golomb_codec()
    {
        this->codec_alg = GolombCoder();
        this->order = 3;
        this->x = 200;
        this->y = 150;
        this->lossless = 1;
        this->cut_n_bits = 0;
    }

    int encode_wav_file(const char *fileIn, const char *fileOut);

    int decode_to_wav(const char *fileIn, const char *fileOut);
};

#endif