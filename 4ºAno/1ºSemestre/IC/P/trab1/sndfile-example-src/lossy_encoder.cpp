#include <iostream>
#include <vector>
#include <cmath>
#include <fftw3.h>
#include <sndfile.hh>
#include "bitstream.h"

using namespace std;

const size_t QUANTIZATION_FACTOR = 10; // constant for quantization 
                                // higher values reduce representation accuracy

int main(int argc, char *argv[])
{
    if (argc < 5) // check command line arguments
    {
        cerr << "Usage: " << argv[0] << " <input WAV file> <output binary file> <block size> <discarded units per block>\n";
        return 1;
    }

    // command line args
    string inputFileName = argv[1]; // get input file
    string outputFileName = argv[2]; // get output file name 
    size_t block_size = stoi(argv[3]); // size of each block of samples
    size_t discarded_units = stoi(argv[4]); // discarded number of coefficients in dct

    SndfileHandle sfhIn(inputFileName);
    if (sfhIn.error())
    {
        cerr << "Error: Could not open the input file or there was an issue with its format.\n";
        return 1;
    }

    if (sfhIn.channels() != 1) // // check if the WAV file is mono (only one channel)
    {
        cerr << "Error: The input file is not a mono file. It has " << sfhIn.channels() << " channels.\n";
        return 1;
    }

    // read samples from the WAV file
    vector<short> samples(sfhIn.frames());
    sfhIn.readf(samples.data(), sfhIn.frames());

    // vectors to store original and DCT transformed data
    vector<double> x(block_size);
    vector<double> x_dct(block_size);

    // compute dct
    fftw_plan plan_d = fftw_plan_r2r_1d(block_size, x.data(), x_dct.data(), FFTW_REDFT10, FFTW_ESTIMATE);

    BitStream outStream(outputFileName, ios::out);

    // write metadata to the bitstream to be read by the decoder (also using bitstream methods)
    outStream.writeBits(block_size, 16);
    outStream.writeBits(samples.size() / block_size, 16);
    outStream.writeBits(sfhIn.samplerate(), 16);
    outStream.writeBits(discarded_units, 16); // passed this to dinamically iterate in decoder

    // process blocks of samples
    for (size_t i = 0; i < samples.size(); i += block_size) // iterate over samples vector
    {
        for (size_t j = 0; j < block_size; ++j) // populate `x` vector with samples for DCT
        {
            x[j] = (i + j < samples.size()) ? samples[i + j] : 0.0; // padding with 0s if necessary
        }

        fftw_execute(plan_d); // apply DCT on the block of samples

        // quantize and discard coefficients (arg from command line)
        for (size_t j = 0; j < block_size - discarded_units; ++j)
        {
            int quantized = x_dct[j] * QUANTIZATION_FACTOR;
            outStream.writeBits(quantized, 32); // 32 bits per coefficient
        }
    }

    fftw_destroy_plan(plan_d); // clean fftw
    outStream.close(); // close the output bitstream
    return 0;
}
