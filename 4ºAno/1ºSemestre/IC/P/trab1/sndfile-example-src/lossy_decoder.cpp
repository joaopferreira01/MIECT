#include <iostream>
#include <vector>
#include <cmath>
#include <fftw3.h>
#include <sndfile.hh>
#include "bitstream.h"

using namespace std;

const size_t QUANTIZATION_FACTOR = 10; // constant for dequantization
                                    // has to be the same as used in the encoder 

int main(int argc, char *argv[])
{
    if (argc != 3) // check command line arguments
    {
        cerr << "Usage: " << argv[0] << " <input binary file> <output WAV file>\n";
        return 1;
    }

    string inputFileName = argv[1]; // get input file
    string outputFileName = argv[2]; // get output file
    int numChannels = 1; // mono audios only have 1 channel

    BitStream inStream(inputFileName, ios::in); // open bin file

    // get metadata from bin file
    size_t block_size = inStream.readBits(16); // each sample block size
    size_t nBlocks = inStream.readBits(16); // get number of blocks
    int sampleRate = inStream.readBits(16);
    size_t discarded_units = inStream.readBits(16); // discarded units 

    vector<short> outputSamples(block_size * nBlocks); // vector to store the decoded audio samples

    // vectors for the DCT coefficients and their inverse transformation
    vector<double> x_dct(block_size);
    vector<double> x(block_size);

    fftw_plan plan_id = fftw_plan_r2r_1d(block_size, x_dct.data(), x.data(), FFTW_REDFT01, FFTW_ESTIMATE);

    for (size_t i = 0; i < nBlocks; i++) // process blocks of coefficients
    {
        // read and dequantize coefficients
        for (size_t j = 0; j < block_size; ++j) // read and dequantize coefficients
        {
            if (j < block_size - discarded_units)
            {
                int quantized = inStream.readBits(32);
                x_dct[j] = quantized / static_cast<double>(QUANTIZATION_FACTOR);
            }
            else
            {
                x_dct[j] = 0; // zero out the discarded coefficients
            }
        }

        fftw_execute(plan_id);  // get back the original audio samples with inverse DCT

        for (size_t j = 0; j < block_size; ++j) // save reconstructed samples, within the 16-bit range
        {
            outputSamples[i * block_size + j] = min(max(static_cast<int>(round(x[j])), -32768), 32767);
        }
    }

    fftw_destroy_plan(plan_id);
    inStream.close();

    // write output WAV file
    SndfileHandle sfhOut(outputFileName, SFM_WRITE, SF_FORMAT_WAV | SF_FORMAT_PCM_16, numChannels, sampleRate);
    sfhOut.writef(outputSamples.data(), outputSamples.size());

    return 0;
}