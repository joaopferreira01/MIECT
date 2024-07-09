#include "wav_quant.h"
#include <iostream>

// Constructor: initializes the WavQuant object with inputPath, outputPath and desired bit depth
WavQuant::WavQuant(const std::string &inputPath, const std::string &outputPath, int newBitDepth)
    : inputPath(inputPath), outputPath(outputPath), newBitDepth(newBitDepth) {}

void WavQuant::quantize() { // main quantization function
    SndfileHandle inFile(inputPath); // open input WAV file for reading
    if (inFile.error()) {
        std::cerr << "Error reading input file." << std::endl;
        return;
    }

    // create output WAV file for writing, copying the format, channels, and sample rate from the input file
    SndfileHandle outFile(outputPath, SFM_WRITE, inFile.format(), inFile.channels(), inFile.samplerate());
    if (outFile.error()) {
        std::cerr << "Error creating output file." << std::endl;
        return;
    }

    std::vector<short> samples(inFile.frames() * inFile.channels()); // read audio samples from the input file into a vector
    inFile.read(samples.data(), samples.size());

    for (short &sample : samples) { // quantize each sample in the vector
        quantizeSample(sample);
    }

    outFile.write(samples.data(), samples.size()); // write the quantized samples
}

void WavQuant::quantizeSample(short &sample) { // quantize an individual sample
    int numBitsToCut = 16 - newBitDepth; // get how many bits to discard based on desired bit depth

    // bitwise operations to quantize the sample
    sample = sample >> numBitsToCut;
    sample = sample << numBitsToCut;
}

int main(int argc, char *argv[]) {
    if (argc != 4) { // check number of command-line arguments
        std::cerr << "Usage: " << argv[0] << " <input.wav> <output.wav> <bitsToKeep>" << std::endl;
        return 1;
    }

    // parse command-line arguments
    std::string inputPath = argv[1];
    std::string outputPath = argv[2];
    int bitsToKeep = std::stoi(argv[3]);

    if (bitsToKeep <= 0 || bitsToKeep > 16) { // check bit range
        std::cerr << "Please provide a valid number of bits to keep between 1 and 16." << std::endl;
        return 1;
    }

    WavQuant quantizer(inputPath, outputPath, bitsToKeep); // create a WavQuant object
    quantizer.quantize();

    std::cout << "Quantization completed." << std::endl;
    return 0;
}
