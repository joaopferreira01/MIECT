#include "video_utils.h"
#include <iostream>
#include <string>

using namespace std;

// function to calculate the size of a file
long getFileSize(const string &fileName)
{
    ifstream file(fileName, ios::binary | ios::ate);
    if (file.is_open())
    {
        return file.tellg();
    }
    else
    {
        return -1;
    }
}

int main(int argc, char *argv[])
{
    if (argc != 9) // check if the correct number of arguments is passed
    {
        cerr << "Usage: " << argv[0] << " <input_file> <output_file> <yuv_format> <mode> <period> <quantization> <block_size> <search_area>" << endl;
        return -1;
    }

    // parse command line arguments
    string input_file = argv[1];
    string output_file = argv[2];
    string yuv_format = argv[3];
    int mode = stoi(argv[4]);
    int period = stoi(argv[5]);
    int quantization = stoi(argv[6]);
    int block_size = stoi(argv[7]);
    int searchArea = stoi(argv[8]);

    // create a codec_video object with the provided parameters
    codec_video videoCodec(mode, period, quantization, block_size, searchArea);

    cout << "Encoding video..." << endl;
    if (videoCodec.encode_video(input_file.c_str(), output_file.c_str(), yuv_format) != 0)
    {
        cerr << "Error during video encoding." << endl;
        return -1;
    }

    // get sizes of the input and output files
    long inputSize = getFileSize(input_file);
    long outputSize = getFileSize(output_file);

    if (inputSize == -1 || outputSize == -1)
    {
        cerr << "Error: Unable to determine file sizes." << endl;
        return -1;
    }

    cout << "Input file size: " << inputSize / 1024.0 / 1024.0 << " MB" << endl;
    cout << "Output file size: " << outputSize / 1024.0 / 1024.0 << " MB" << endl;
    cout << "Encoding completed." << endl;

    return 0;
}
