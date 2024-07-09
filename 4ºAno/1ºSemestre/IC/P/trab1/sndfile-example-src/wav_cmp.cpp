#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
#include <cstdint>

using namespace std;

struct WAVHeader {
    char riff[4];
    uint32_t chunkSize;
    char wave[4];
    char fmt[4];
    uint32_t subChunkSize;
    uint16_t audioFormat;
    uint16_t numChannels;
    uint32_t sampleRate;
    uint32_t byteRate;
    uint16_t blockAlign;
    uint16_t bitsPerSample;
};

vector<int16_t> readWAV(const string &filename) {
    WAVHeader header;
    ifstream file(filename, ios::binary);

    if (!file.read((char*)&header, sizeof(WAVHeader))) {
        throw runtime_error("Error reading WAV header");
    }

    vector<int16_t> samples;
    int16_t sample;
    while (file.read((char*)&sample, sizeof(int16_t))) {
        samples.push_back(sample);
    }

    return samples;
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        cerr << "Usage: wav_cmp <original_file> <processed_file>\n";
        return 1;
    }

    vector<int16_t> original = readWAV(argv[1]);
    vector<int16_t> processed = readWAV(argv[2]);

    if (original.size() != processed.size()) {
        cerr << "Error: The two audio files are of different sizes\n" << original.size() << " - " << processed.size() << endl;
        return 1;
    }

    double mse = 0.0;
    double maxError = 0.0;
    double snr = 0.0;
    double signalPower = 0.0;
    double noisePower = 0.0;

    for (size_t i = 0; i < original.size(); i++) {
        double error = original[i] - processed[i];
        mse += error * error;
        maxError = max(maxError, abs(error));
        signalPower += original[i] * original[i];
        noisePower += error * error;
    }

    mse /= original.size();
    snr = 10 * log10(signalPower / noisePower);
    cout << "Average mean squared error (L2 norm): " << mse << "\n";
    cout << "Maximum per sample absolute error (L∞ norm): " << maxError << "\n";
    cout << "Signal-to-noise ratio (SNR): " << snr << " dB\n";

    return 0;
}
    