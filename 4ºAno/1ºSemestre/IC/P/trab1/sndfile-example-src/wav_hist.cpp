#include <iostream>
#include <vector>
#include <sndfile.hh>
#include "wav_hist.h"

using namespace std;

constexpr size_t FRAMES_BUFFER_SIZE = 65536; // Buffer for reading frames

int main(int argc, char *argv[]) {

    if(argc != 4) {
        cerr << "Usage: " << argv[0] << " <input file> <channel | version> <coarseness>\n";
        return 1;
    }

    SndfileHandle sndFile { argv[argc-3] };
    if(sndFile.error()) {
        cerr << "Error: invalid input file\n";
        return 1;
    }

    if((sndFile.format() & SF_FORMAT_TYPEMASK) != SF_FORMAT_WAV) {
        cerr << "Error: file is not in WAV format\n";
        return 1;
    }

    if((sndFile.format() & SF_FORMAT_SUBMASK) != SF_FORMAT_PCM_16) {
        cerr << "Error: file is not in PCM_16 format\n";
        return 1;
    }

    string version { argv[argc-2] };
    int channel = 0;
    if (version != "normal" && version != "avg" && version != "diff")
    {
        try
        {
            channel = stoi(argv[argc-2]);
        }
        catch(const exception& e)
        {
            cerr << "Error: invalid version" << '\n';
            return 1;
        }
    
        if(channel >= sndFile.channels()) {
            cerr << "Error: invalid channel\n";
            return 1;
        }
    }

    int coarseness = 0;
    try
    {
        coarseness = stoi(argv[argc-1]);
    }
    catch(const exception& e)
    {
        cerr << "Error: invalid coarseness" << '\n';
        return 1;
    }

    size_t nFrames;
    vector<short> samples(FRAMES_BUFFER_SIZE * sndFile.channels());
    WAVHist hist { sndFile, coarseness };
    while((nFrames = sndFile.readf(samples.data(), FRAMES_BUFFER_SIZE))) {
        samples.resize(nFrames * sndFile.channels());

        if (version == "avg")
            hist.update_avg(samples, sndFile.channels());
        else if (version == "diff")
            hist.update_diff(samples, sndFile.channels());
        else
            hist.update(samples);
    }

    hist.dump(channel, version);
    return 0;
}