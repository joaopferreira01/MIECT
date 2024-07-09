#ifndef VIDEO_UTILS_H
#define VIDEO_UTILS_H

#include <fstream>
#include <string>
#include <bitset>
#include <opencv2/opencv.hpp>
#include "2codec_image.h"
#include "golomb.h"

using namespace cv;
using namespace std;

// structure to represent motion vectors with horizontal (dx) and vertical (dy) components
struct MotionVector {
    int dx, dy;
};

// class representing a video codec with functionality for encoding and decoding video streams
class codec_video {
public:
    // constructors
    codec_video(int mode, uint32_t p, int quantization, int blockSize, int searchArea);
    codec_video(int mode, uint32_t p, int quantization);
    codec_video();
    codec_video(int mode, uint32_t p);

    // method to encode a video file
    int encode_video(const char *fileIn, const char *fileOut, const string &yuv_format);

    // method to decode a video file
    int decode_video(const char *fileIn, const char *fileOut);

    // static methods for writing YUV420 and YUV422 formatted frames to a file
    static int YUV420_write(const char *fileOut, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_write, string header);
    static int YUV422_write(const char *fileOut, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_write, string header);

    // static methods to read and write binary data to and from a file
    static string read_bin_from_file(const char *fileIn);
    static int write_bin_to_file(const char *fileOut, const string &encoded);

private:
    // private members to store codec settings and state
    int mode;
    uint32_t period;
    int quantization;
    int blockSize;
    int searchArea;
    MotionVector prevMotionVec;

    // private methods for internal processing
    int calculateSAD(const Mat &block1, const Mat &block2);  // calculates the Sum of Absolute Differences
    MotionVector motion_estimation(Mat currentBlock, Mat refFrame, int searchArea);  // estimates motion vector for a block
    bool should_encode_intra(Mat currentBlock, Mat refFrame, int threshold);  // determines whether to use intra-frame encoding
    string encode_motion_vector(MotionVector mv, golomb &encoder);  // encodes a motion vector
    string encode_residual(const Mat &residual, golomb &encoder);  // encodes residual data
    Mat compute_residual(const Mat &currentBlock, const Mat &refBlock, const MotionVector &mv);  // computes residual block
    string encodePFrame(const Mat &currentFrame, const Mat &refFrame, golomb &encoder);  // encodes P-frames
    string encodeIFrame(const Mat &frame, golomb &encoder);  // encodes I-frames
    void intToByteArray(int value, char *byteArray);  // converts an integer to a byte array

    // methods for decoding
    MotionVector decode_motion_vector(string bitstream, golomb &decoder);  // decodes a motion vector from a bitstream
    Mat decode_residual(string bitstream, int rows, int cols, golomb &decoder);  // decodes residual data from a bitstream
    double calculateBlockVariance(const cv::Mat &block);  // calculates the variance of a block
};

#endif // VIDEO_UTILS_H
