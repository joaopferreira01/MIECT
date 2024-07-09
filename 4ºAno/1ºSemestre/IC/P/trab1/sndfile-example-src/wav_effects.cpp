#include <iostream>
#include <vector>
#include <math.h>
#include <cmath>
#include <sndfile.hh>
#include "wav_hist.h"

using namespace std;

constexpr size_t FRAMES_BUFFER_SIZE = 65536; // Buffer for reading frames

int main(int argc, char *argv[])
{
    if (argc < 4)
    {
        cerr << "Usage: " << argv[0] << " <input file> ( reverse | left | right | single_echo | double_echo  | triple_echo | amplitude_loop)\n";
        return 1;
    }
    string effect = argv[3];
    SndfileHandle sfhIn{argv[1]};

    if (sfhIn.error())
    {
        cerr << "Error: invalid input file\n";
        return 1;
    }

    if ((sfhIn.format() & SF_FORMAT_TYPEMASK) != SF_FORMAT_WAV)
    {
        cerr << "Error: file is not in WAV format\n";
        return 1;
    }

    if ((sfhIn.format() & SF_FORMAT_SUBMASK) != SF_FORMAT_PCM_16)
    {
        cerr << "Error: file is not in PCM_16 format\n";
        return 1;
    }

    SndfileHandle sfhOut{argv[argc - 2], SFM_WRITE, sfhIn.format(),
                         sfhIn.channels(), sfhIn.samplerate()};
    if (sfhOut.error())
    {
        cerr << "Error: invalid output file\n";
        return 1;
    }

    size_t nFrames;
    bool flag = true;
    vector<short> samples(FRAMES_BUFFER_SIZE * sfhIn.channels());
    vector<short> echo_out(FRAMES_BUFFER_SIZE * sfhIn.channels());
    vector<short> samples_out;
    int value = 0;
    // int counter = 0;
    int i = 0;

    if (effect == "reverse")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            i++;
            if (effect == "reverse")
            {
                // short aux = 0;
                for (size_t i = 0; i < samples.size(); i++)
                {
                    samples_out.push_back(samples[samples.size() - 1 - i]);
                }
            }
        }
        sfhOut.writef(samples_out.data(), FRAMES_BUFFER_SIZE * i);
    }
    else if (effect == "left")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            for (size_t i = 0; i < samples.size(); i++)
            {
                echo_out[i] = (++value % 2) * samples[i];
            }

            sfhOut.writef(echo_out.data(), nFrames);
        }
    }
    else if (effect == "right")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            for (size_t i = 0; i < samples.size(); i++)
            {
                echo_out[i] = (value++ % 2) * samples[i];
            }

            sfhOut.writef(echo_out.data(), nFrames);
        }
    }
    else if (effect == "single_echo")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            for (size_t i = 0; i < samples.size(); i++)
            {
                echo_out[i] = (samples[i] + samples[i - 44000]) * 0.5;
            }

            sfhOut.writef(echo_out.data(), nFrames);
        }
    }
    else if (effect == "double_echo")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            for (size_t i = 0; i < samples.size(); i++)
            {
                echo_out[i] = (samples[i] + samples[i - 44100] + samples[i - 88200]) * 0.4;
            }

            sfhOut.writef(echo_out.data(), nFrames);
        }
    }
    else if (effect == "triple_echo")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            for (size_t i = 0; i < samples.size(); i++)
            {
                echo_out[i] = (samples[i] + samples[i - 44100] + samples[i - 88200] + samples[i - 132300]) * 0.2;
            }

            sfhOut.writef(echo_out.data(), nFrames);
        }
    }
    else if (effect == "amplitude_loop")
    {
        while ((nFrames = sfhIn.readf(samples.data(), FRAMES_BUFFER_SIZE)))
        {
            i++;
            for (size_t i = 0; i <= samples.size(); i++)
            {
                samples_out.push_back(samples[i] * (double(value) / double(samples.size())));
                if (flag == 1)
                {
                    value++;
                }
                else
                {
                    value--;
                }
            }
            flag = !flag;
        }
        sfhOut.writef(samples_out.data(), FRAMES_BUFFER_SIZE * i);
    }
    else
    {
        cerr << "Error: invalid effect\n";
        return 1;
    }
    cout << "Done!\n";
}
