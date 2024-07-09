#ifndef WAV_QUANT_H
#define WAV_QUANT_H

#include <sndfile.hh>
#include <vector>

class WavQuant {
public:
    // constructor
    WavQuant(const std::string &inputPath, const std::string &outputPath, int newBitDepth);
    void quantize();

private:
    std::string inputPath; // store the input WAV file path
    std::string outputPath; // store the output WAV file path
    int newBitDepth; // store the desired bit depth for quantization

    void quantizeSample(short &sample); // function to quantize an individual audio sample
};

#endif