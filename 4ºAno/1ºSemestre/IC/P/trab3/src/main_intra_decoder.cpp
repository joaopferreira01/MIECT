#include "video_utils.h"
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
    if (argc != 3) // check if the correct number of arguments is passed
    {
        cerr << "Usage: " << argv[0] << " <encoded_file> <output_file>" << endl;
        return -1;
    }

    // parse command line arguments
    string encoded_file = argv[1];
    string output_file = argv[2];

    cout << "Decoding video..." << endl;
    // create a codec_video object with default parameters
    codec_video videoCodec;
    if (videoCodec.decode_video(encoded_file.c_str(), output_file.c_str()) != 0)
    {
        cerr << "Error during video decoding." << endl;
        return -1;
    }

    cout << "Decoding completed." << endl;
    return 0;
}
