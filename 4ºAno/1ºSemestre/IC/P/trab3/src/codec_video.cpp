#include "video_utils.h"
#include "2codec_image.h"
#include <opencv2/opencv.hpp>
#include <vector>

// Constructor with all parameters
codec_video::codec_video(int mode, uint32_t p, int quantization, int blockSize, int searchArea)
{
    this->mode = mode;
    this->period = p;                  // frame period for certain processing
    this->quantization = quantization; // quantization parameter for compression
    this->blockSize = blockSize;       // size of the block for processing
    this->searchArea = searchArea;     // area to search for motion estimation
    prevMotionVec = {0, 0};            // initialize previous motion vector to zero
}

// default constructor
codec_video::codec_video()
{
    this->mode = 0;          // default mode
    this->period = 30;       // default period
    this->quantization = 10; // default quantization
    this->blockSize = 16;    // default block size
    this->searchArea = 16;   // default search area
    prevMotionVec = {0, 0};
}

/**
 * calculateSAD - Calculates the Sum of Absolute Differences (SAD) between two image blocks
 *
 * @param block1 first image block (Mat object) for comparison
 * @param block2 second image block (Mat object) for comparison
 * @return computed SAD value as an integer
 */
int codec_video::calculateSAD(const Mat &block1, const Mat &block2)
{
    int sad = 0;
    for (int i = 0; i < block1.rows; ++i)
    {
        for (int j = 0; j < block1.cols; ++j)
        {
            sad += abs(block1.at<uchar>(i, j) - block2.at<uchar>(i, j));
        }
    }
    return sad;
}

/**
 * motion_estimation - performs motion estimation for a given block within a reference frame
 *
 * @param currentBlock current image block for which the motion is being estimated
 * @param refFrame reference frame against which the current block is compared
 * @param searchArea area around the block's initial position that will be searched
 *                   to find the best matching block in the reference frame
 * @return estimated motion vector indicating the displacement from the original position
 */
MotionVector codec_video::motion_estimation(Mat currentBlock, Mat refFrame, int searchArea)
{
    MotionVector bestMotionVec = {0, 0};
    int minSAD = numeric_limits<int>::max();
    int stepSize = max(searchArea / 2, 1); // initialize step size for block matching

    int blockWidth = currentBlock.cols;  // width of the current block
    int blockHeight = currentBlock.rows; // height of the current block

    // initial center position of the search
    int xCenter = blockWidth / 2;
    int yCenter = blockHeight / 2;

    while (stepSize >= 1) // iteratively search for the block position that minimizes the SAD
    {
        bool foundBetterMatch = false;

        for (int y = -stepSize; y <= stepSize; y += stepSize)
        {
            for (int x = -stepSize; x <= stepSize; x += stepSize)
            {
                int newX = xCenter + x; // new candidate X position
                int newY = yCenter + y; // new candidate Y position

                // check if the new block is within the frame boundaries
                if (newX < 0 || newY < 0 || newX + blockWidth > refFrame.cols || newY + blockHeight > refFrame.rows)
                    continue;
                // define a rectangle in the reference frame for block matching
                Rect blockRect(newX, newY, blockWidth, blockHeight);
                Mat refBlock = refFrame(blockRect);

                // calculate the SAD for the candidate block
                int sad = calculateSAD(currentBlock, refBlock);

                // update the best motion vector if a better match is found
                if (sad < minSAD)
                {
                    minSAD = sad;
                    bestMotionVec.dx = newX;
                    bestMotionVec.dy = newY;
                    foundBetterMatch = true;
                }
            }
        }

        // update the center position to the best match found in this iteration
        if (foundBetterMatch)
        {
            xCenter = bestMotionVec.dx;
            yCenter = bestMotionVec.dy;
        }
        else
        {
            // reduce the step size for finer search in the next iteration
            stepSize /= 2;
        }
    }
    return bestMotionVec;
}

/**
 * should_encode_intra - determines whether a block should be encoded using intra-frame encoding
 * the decision is based on the Sum of Absolute Differences between the current block
 * and the best matching block in the reference frame
 *
 * @param currentBlock block in the current frame that is being evaluated
 * @param refFrame reference frame against which the current block is compared
 * @param threshold SAD threshold to decide if intra or inter-frame encoding
 * @return True if the block should be encoded using intra-frame encoding, false otherwise
 */
bool codec_video::should_encode_intra(Mat currentBlock, Mat refFrame, int threshold)
{
    // perform motion estimation to find the best matching block in the reference frame
    MotionVector bestMotionVec = motion_estimation(currentBlock, refFrame, this->searchArea);

    // calculate the position of the best matching block
    Rect bestMatchRect(bestMotionVec.dx, bestMotionVec.dy, currentBlock.cols, currentBlock.rows);
    Mat bestMatchBlock = refFrame(bestMatchRect);

    // calculate the SAD between the current block and the best matching block
    int sad = 0;
    for (int i = 0; i < currentBlock.rows; ++i)
    {
        for (int j = 0; j < currentBlock.cols; ++j)
        {
            sad += abs(currentBlock.at<uchar>(i, j) - bestMatchBlock.at<uchar>(i, j));
        }
    }

    return sad > threshold; // if the SAD is lower than the threshold, it's more efficient to encode in inter mode
}

/**
 * encode_motion_vector - encodes a motion vector using Golomb coding
 *
 * @param mv current motion vector to be encoded
 * @param encoder Golomb encoder used for encoding
 * @return string representing the encoded motion vector
 */
string codec_video::encode_motion_vector(MotionVector mv, golomb &encoder)
{
    // calculate the difference in motion vector components from the previous motion vector
    int dx_diff = mv.dx - prevMotionVec.dx;
    int dy_diff = mv.dy - prevMotionVec.dy;
    prevMotionVec = mv; // ppdate previous motion vector

    // encode the differences using Golomb coding
    string encoded_dx = encoder.encode_number(dx_diff, 1); // Use mapping
    string encoded_dy = encoder.encode_number(dy_diff, 1); // Use mapping
    return encoded_dx + encoded_dy;
}

/**
 * decode_motion_vector - decodes a motion vector from a bitstream using Golomb coding
 *
 * @param bitstream bitstream containing the encoded motion vector differences
 * @param decoder Golomb decoder used for decoding
 * @return decoded MotionVector
 */
MotionVector codec_video::decode_motion_vector(string bitstream, golomb &decoder)
{
    long dx_diff, dy_diff;
    char *bitstreamPtr = &bitstream[0];

    // decode the differences in the x and y components from the bitstream
    bitstreamPtr = decoder.decode_string(bitstreamPtr, &dx_diff, 1);
    bitstreamPtr = decoder.decode_string(bitstreamPtr, &dy_diff, 1);

    MotionVector mv = {prevMotionVec.dx + static_cast<int>(dx_diff), prevMotionVec.dy + static_cast<int>(dy_diff)};
    prevMotionVec = mv; // update previous motion vector

    return mv;
}

/**
 * quantizeDCT - quantizes the DCT coefficients of a block
 *
 * @param block matrix of DCT coefficients to be quantized
 * @param quantization quantization factor used to reduce the precision of the DCT coefficients
 */
void quantizeDCT(Mat &block, int quantization)
{
    // iterate over each DCT coefficient in the block
    for (int i = 0; i < block.rows; ++i)
    {
        for (int j = 0; j < block.cols; ++j)
        {
            // reduce the precision of the coefficient => data compression
            block.at<float>(i, j) = round(block.at<float>(i, j) / quantization);
        }
    }
}

/**
 * dequantizeDCT - dequantizes the DCT coefficients of a block
 *
 * @param block matrix of quantized DCT coefficients to be dequantized
 * @param quantization quantization factor used for dequantization
 */
void dequantizeDCT(Mat &block, int quantization)
{
    // iterate over each quantized DCT coefficient in the block
    for (int i = 0; i < block.rows; ++i)
    {
        for (int j = 0; j < block.cols; ++j)
        {
            block.at<float>(i, j) *= quantization; // reconstruct the original scale of the coefficients
        }
    }
}

/**
 * calculateBlockVariance - calculate variance of a block
 *
 * @param block image block
 * @return calculated variance of the block
 */
double codec_video::calculateBlockVariance(const Mat &block)
{
    Scalar mean, stddev;
    meanStdDev(block, mean, stddev); // compute mean and standard deviation of the block
    return stddev[0] * stddev[0];    // variance is the square of standard deviation
}

/**
 * encode_residual - encode residual block using Golomb coding with dynamic quantization
 *
 * @param residual residual block to be encoded
 * @param encoder Golomb encoder used for encoding
 * @return string representing the encoded residual block
 */
string codec_video::encode_residual(const Mat &residual, golomb &encoder)
{
    double variance = calculateBlockVariance(residual); // get variance of the residual block

    // adjust the quantization level based on the variance of the block
    int dynamicQuantization = std::max(1, static_cast<int>(this->quantization * (1 + variance / 1000)));

    // clone the residual block and apply dynamic quantization
    Mat quantizedResidual = residual.clone();
    quantizeDCT(quantizedResidual, dynamicQuantization);

    string encoded;
    for (int i = 0; i < quantizedResidual.rows; i++)
    {
        for (int j = 0; j < quantizedResidual.cols; j++)
        {
            int value = static_cast<int>(quantizedResidual.at<float>(i, j));
            // Encode the quantized value
            encoded += encoder.encode_number(value, 1); // Use mapping
        }
    }
    return encoded;
}

/**
 * applyDCT - apply Discrete Cosine Transform to a block
 *
 * @param block image block
 * @return DCT-transformed block
 */
Mat applyDCT(const Mat &block)
{
    Mat dctBlock;
    dct(block, dctBlock);
    return dctBlock;
}

/**
 * compute_residual - compute residual block between the current block and its predicted version
 *
 * @param currentBlock current image block
 * @param refBlock reference image block used for prediction
 * @param mv motion vector
 * @return DCT-transformed residual block
 */
Mat codec_video::compute_residual(const Mat &currentBlock, const Mat &refBlock, const MotionVector &mv)
{
    // create floating point matrix to store the residual
    Mat residual(currentBlock.size(), CV_32F);

    // define region in the reference frame that corresponds to the predicted block
    Rect refRect(mv.dx, mv.dy, currentBlock.cols, currentBlock.rows);
    Mat predictedBlock = refBlock(refRect);

    for (int y = 0; y < currentBlock.rows; ++y)
    {
        for (int x = 0; x < currentBlock.cols; ++x)
        {
            // calculate the difference in pixel intensity and store in the residual matrix
            float diff = static_cast<float>(currentBlock.at<uchar>(y, x)) - static_cast<float>(predictedBlock.at<uchar>(y, x));
            residual.at<float>(y, x) = diff;
        }
    }

    // apply DCT to residual block to convert it into the frequency domain
    return applyDCT(residual);
}

/**
 * decode_residual - decode residual block from a compressed bitstream
 *
 * @param bitstream compressed bitstream containing the encoded residual block
 * @param rows number of rows in the residual block
 * @param cols number of columns in the residual block
 * @param decoder Golomb decoder used for decoding
 * @return dequantized residual block
 */
Mat codec_video::decode_residual(string bitstream, int rows, int cols, golomb &decoder)
{
    // create a floating point matrix to store the decoded residual
    Mat residual(rows, cols, CV_32F);
    long value;
    char *bitstreamPtr = &bitstream[0];

    // decode each value from bitstream and populate residual matrix
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            bitstreamPtr = decoder.decode_string(bitstreamPtr, &value, 1);
            residual.at<float>(i, j) = static_cast<float>(value);
        }
    }

    // get variance of the residual block
    double variance = calculateBlockVariance(residual);
    // adjust quantizaiton
    int dynamicQuantization = std::max(1, static_cast<int>(this->quantization * (1 + variance / 1000))); // Adjust quantization

    dequantizeDCT(residual, dynamicQuantization); // reconstruct original values
    return residual;
}

/**
 * encodePFrame - ncode a P frame in a video sequence
 *
 * @param currentFrame current P-frame to be encoded
 * @param refFrame reference frame used for motion compensation
 * @param encoder Golomb encoder used for encoding
 * @return string representing the encoded bitstream of the P-frame
 */
string codec_video::encodePFrame(const Mat &currentFrame, const Mat &refFrame, golomb &encoder)
{
    string bitstream;
    int blockWidth = blockSize;
    int blockHeight = blockSize;

    for (int y = 0; y < currentFrame.rows; y += blockHeight)
    {
        for (int x = 0; x < currentFrame.cols; x += blockWidth)
        {
            // adjust block size for edges
            int actualBlockWidth = std::min(blockWidth, currentFrame.cols - x);
            int actualBlockHeight = std::min(blockHeight, currentFrame.rows - y);

            Rect blockRect(x, y, actualBlockWidth, actualBlockHeight);

            // extract the current and reference blocks
            Mat currentBlock = currentFrame(blockRect);
            Mat refBlock = refFrame(blockRect);

            // perform motion estimation
            MotionVector mv = motion_estimation(currentBlock, refBlock, this->searchArea);

            // encode the motion vector
            bitstream += encode_motion_vector(mv, encoder);

            // compute and encode the residual block
            Mat residual = compute_residual(currentBlock, refBlock, mv);
            bitstream += encode_residual(residual, encoder);
        }
    }

    return bitstream;
}

/**
 * encodeIFrame - Encodes I-frames in a video sequence
 *
 * @param frame I-frame to be encoded
 * @param encoder Golomb encoder used for encoding
 * @return string representing the encoded bitstream of the I-frame
 */
string codec_video::encodeIFrame(const Mat &frame, golomb &encoder)
{
    string bitstream;
    int blockWidth = blockSize;
    int blockHeight = blockSize;

    for (int y = 0; y < frame.rows; y += blockHeight)
    {
        for (int x = 0; x < frame.cols; x += blockWidth)
        {
            // djust block size for edges
            int actualBlockWidth = std::min(blockWidth, frame.cols - x);
            int actualBlockHeight = std::min(blockHeight, frame.rows - y);

            Rect blockRect(x, y, actualBlockWidth, actualBlockHeight);

            // extract the block
            Mat currentBlock = frame(blockRect);

            // encode the block
            for (int i = 0; i < currentBlock.rows; i++)
            {
                for (int j = 0; j < currentBlock.cols; j++)
                {
                    uchar pixel = currentBlock.at<uchar>(i, j);
                    bitstream += encoder.encode_number(pixel, 0);
                }
            }
        }
    }

    return bitstream;
}

/**
 * intToByteArray - helper function to convert an integer value to a byte array
 *
 * @param value
 * @param byteArray
 */
void codec_video::intToByteArray(int value, char *byteArray)
{
    for (int i = 0; i < 4; i++)
    {
        byteArray[i] = (value >> (24 - i * 8)) & 0xFF; // shift and mask the integer to extract each byte
    }
}

/**
 * encode_video - encode a video file and write encoded data to an output file
 *
 * @param fileIn path to the input video file
 * @param fileOut path to the output file
 * @param yuv_format YUV format of the video (YUV420, YUV422)
 * @return 0 on successful encoding
 */
int codec_video::encode_video(const char *fileIn, const char *fileOut, const string &yuv_format)
{
    clock_t time_req = clock(); // measure the encoding duration

    VideoCapture cap(fileIn);
    if (!cap.isOpened())
    {
        cerr << "Error opening video file" << endl;
        return -1;
    }

    // get properties of the input video
    Size frameSize = Size((int)cap.get(CAP_PROP_FRAME_WIDTH), (int)cap.get(CAP_PROP_FRAME_HEIGHT));
    uint32_t frameCount = (uint32_t)cap.get(CAP_PROP_FRAME_COUNT);

    cout << "Original video properties:" << endl;
    cout << "\tWidth: " << frameSize.width << endl;
    cout << "\tHeight: " << frameSize.height << endl;
    cout << "\tFrame count: " << frameCount << endl;

    // initialize Golomb encoder with a predefined M-value
    golomb golombEncoder(1000);

    ofstream outputFile(fileOut, ios::binary);
    if (!outputFile.is_open())
    {
        cerr << "Error opening output file" << endl;
        return -1;
    }

    cout << "Encoding video properties before writing to file:" << endl;
    cout << "\tMode: " << mode << endl;
    cout << "\tPeriod: " << period << endl;
    cout << "\tQuantization: " << quantization << endl;
    cout << "\tBlock Size: " << blockSize << endl;
    cout << "\tSearch Area: " << searchArea << endl;

    // convert and write video properties to the output file
    char buffer[4];
    intToByteArray(frameSize.width, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(frameSize.height, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(frameCount, buffer);
    outputFile.write(buffer, 4);

    int yuvFormatCode = (yuv_format == "YUV420") ? 1 : (yuv_format == "YUV422") ? 2
                                                                                : 0;
    intToByteArray(yuvFormatCode, buffer);
    outputFile.write(buffer, 4);

    // write encoding settings
    intToByteArray(mode, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(period, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(quantization, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(blockSize, buffer);
    outputFile.write(buffer, 4);
    intToByteArray(searchArea, buffer);
    outputFile.write(buffer, 4);

    // iterate over each frame and encode
    Mat currentFrame, previousFrame;
    for (uint32_t frameIndex = 0; frameIndex < frameCount; frameIndex++)
    {
        cap >> currentFrame;
        if (currentFrame.empty())
            break;

        bool isIFrame = (frameIndex % period == 0); // determine if current frame is an I-frame or a P-frame
        string frameBitstream = isIFrame ? encodeIFrame(currentFrame, golombEncoder) : encodePFrame(currentFrame, previousFrame, golombEncoder);
        outputFile.write(frameBitstream.c_str(), frameBitstream.size());
        currentFrame.copyTo(previousFrame);
    }

    outputFile.close();
    cout << "Encoding time: " << static_cast<float>(clock() - time_req) / CLOCKS_PER_SEC << " seconds" << endl;
    return 0;
}

/**
 * decode_video - decodes an encoded video file and writes the decoded frames to file
 *
 * @param fileIn path to the input encoded file
 * @param fileOut path to the output file
 * @return 0 on successful decoding
 */
int codec_video::decode_video(const char *fileIn, const char *fileOut)
{
    clock_t time_req; // measure the decoding duration
    time_req = clock();

    string encoded = read_bin_from_file(fileIn); // read binary data

    if (encoded.length() < 288)
    {
        cerr << "Encoded data is too short to contain required metadata." << endl;
        return -1;
    }

    // decode video metadata
    uint32_t width = std::stoul(encoded.substr(0, 32), nullptr, 2);
    uint32_t height = std::stoul(encoded.substr(32, 32), nullptr, 2);
    uint32_t frames = std::stoul(encoded.substr(64, 32), nullptr, 2);
    uint32_t yuvFormatCode = std::stoul(encoded.substr(96, 32), nullptr, 2);
    mode = static_cast<int>(std::stoul(encoded.substr(128, 32), nullptr, 2));
    period = static_cast<uint32_t>(std::stoul(encoded.substr(160, 32), nullptr, 2));
    quantization = static_cast<int>(std::stoul(encoded.substr(192, 32), nullptr, 2));
    blockSize = static_cast<int>(std::stoul(encoded.substr(224, 32), nullptr, 2));
    searchArea = static_cast<int>(std::stoul(encoded.substr(256, 32), nullptr, 2));

    // get YUV format based on the decoded code
    string yuvFormatStr;
    if (yuvFormatCode == 1)
    {
        yuvFormatStr = "YUV420";
    }
    else if (yuvFormatCode == 2)
    {
        yuvFormatStr = "YUV422";
    }
    else
    {
        cerr << "Error: YUV format code not recognized" << endl;
        return -1;
    }

    cout << "Decoded video info: " << endl;
    cout << "\tWidth: " << width << endl;
    cout << "\tHeight: " << height << endl;
    cout << "\tFrames: " << frames << endl;
    cout << "\tYUV format: " << yuvFormatStr << endl;
    cout << "\tMode: " << mode << endl;
    cout << "\tP: " << period << endl;
    cout << "\tQuantization: " << quantization << endl;
    cout << "\tBlock Size: " << blockSize << endl;
    cout << "\tSearch Area: " << searchArea << endl;

    char *encoded_ptr = &encoded[0] + 288; // Adjust pointer to start reading after the metadata

    image_codec codec_img(mode, period, quantization);

    // allocate memory for storing the decoded frames
    Mat *to_write = new Mat[frames];
    Mat *decoded_frame = new Mat(height, width, CV_8UC3);

    if (yuvFormatStr == "YUV420")
    {
        // handle YUV420 decoding
        for (uint32_t i = 0; i < frames; i++)
        {
            encoded_ptr = codec_img.YUV420_decode_video_frame(encoded_ptr, decoded_frame, height, width);
            to_write[i] = *decoded_frame;
        }
        // write decoded video to file
        if (YUV420_write(fileOut, frames, height, width, to_write, "Header") != 0)
        {
            cerr << "Error writing video" << endl;
            return -1;
        }
    }
    else if (yuvFormatStr == "YUV422")
    {
        // handle YUV422 decoding
        for (uint32_t i = 0; i < frames; i++)
        {
            encoded_ptr = codec_img.YUV422_decode_video_frame(encoded_ptr, decoded_frame, height, width);
            to_write[i] = *decoded_frame;
        }
        // write decoded video to file
        if (YUV422_write(fileOut, frames, height, width, to_write, "Header") != 0)
        {
            cerr << "Error writing video" << endl;
            return -1;
        }
    }
    else
    {
        cerr << "Error: YUV format not supported: " << yuvFormatStr << endl;
        return -1;
    }

    time_req = clock() - time_req;
    cout << "Decoding time: " << (float)time_req / CLOCKS_PER_SEC << " seconds" << endl;

    delete[] to_write;    // free memory
    delete decoded_frame; // free memory

    return 0;
}

// function to read YUV420 file to frames
string YUV420_read(const char *fileIn, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_store)
{
    // open file with fopen
    FILE *input = fopen(fileIn, "rb");
    if (!input)
    {
        cerr << "Failed to open file: " << fileIn << endl;
        return "";
    }

    char header[100];
    if (fgets(header, 100, input) == NULL)
    {
        cerr << "Error reading header from file." << endl;
        fclose(input);
        return "";
    }
    header[strlen(header) - 1] = '\0'; // remove trailing newline

    // read next line
    char line[100]; // line to "FRAMES\n"
    for (uint32_t i = 0; i < n_frames; i++)
    {
        // create frame to store
        Mat tmp = Mat::zeros(height, width, CV_8UC3);

        if (fgets(line, 100, input) == NULL)
        {
            cerr << "Error reading line from file." << endl;
            fclose(input);
            return "";
        }
        // read Y values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k++)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[0] = (unsigned int)c;
            }
        }

        // read U values, 4 pixels per byte
        for (uint32_t j = 0; j < height; j += 2)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[1] = (unsigned int)c;
                tmp.at<Vec3b>(j, k + 1)[1] = (unsigned int)c;
                tmp.at<Vec3b>(j + 1, k)[1] = (unsigned int)c;
                tmp.at<Vec3b>(j + 1, k + 1)[1] = (unsigned int)c;
            }
        }

        // read V values, 4 pixels per byte
        for (uint32_t j = 0; j < height; j += 2)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[2] = (unsigned int)c;
                tmp.at<Vec3b>(j, k + 1)[2] = (unsigned int)c;
                tmp.at<Vec3b>(j + 1, k)[2] = (unsigned int)c;
                tmp.at<Vec3b>(j + 1, k + 1)[2] = (unsigned int)c;
            }
        }

        // store frame
        to_store[i] = tmp.clone();
        // free(tmp);
        tmp.release();
    }

    fclose(input);
    return header;
}

// function to read YUV422 file to frames
string YUV422_read(const char *fileIn, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_store)
{
    // open file with fopen
    FILE *input = fopen(fileIn, "rb");
    if (!input)
    {
        cerr << "Failed to open file: " << fileIn << endl;
        return "";
    }

    char header[100];
    if (fgets(header, 100, input) == NULL)
    {
        cerr << "Error reading header from file." << endl;
        fclose(input);
        return "";
    }
    header[strlen(header) - 1] = '\0'; // remove trailing newline

    // read next line
    char line[100]; // line to "FRAMES\n"
    for (uint32_t i = 0; i < n_frames; i++)
    {
        // create frame to store
        Mat tmp = Mat::zeros(height, width, CV_8UC3);

        if (fgets(line, 100, input) == NULL)
        {
            cerr << "Error reading line from file." << endl;
            fclose(input);
            return "";
        }

        // read Y values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k++)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[0] = (unsigned int)c;
            }
        }

        // read U values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[1] = (unsigned int)c;
                tmp.at<Vec3b>(j, k + 1)[1] = (unsigned int)c;
            }
        }

        // read V values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                char c = fgetc(input);
                tmp.at<Vec3b>(j, k)[2] = (unsigned int)c;
                tmp.at<Vec3b>(j, k + 1)[2] = (unsigned int)c;
            }
        }

        // store frame
        to_store[i] = tmp.clone();
        // free(tmp);
        tmp.release();

        // break;
    }

    fclose(input);
    return header;
}

// function to write YUV420 file to frames
int codec_video::YUV420_write(const char *fileOut, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_write, string header)
{
    // open file with fopen
    FILE *output = fopen(fileOut, "wb");

    // write header
    fprintf(output, "%s", header.c_str());

    fprintf(output, "\n");
    // write frames
    for (uint32_t i = 0; i < n_frames; i++)
    {
        // write FRAME\n
        fprintf(output, "FRAME\n");

        // write Y values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k++)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[0], output);
            }
        }

        // write U values, 4 pixels per byte
        for (uint32_t j = 0; j < height; j += 2)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[1], output);
            }
        }

        // write V values, 4 pixels per byte
        for (uint32_t j = 0; j < height; j += 2)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[2], output);
            }
        }
    }

    fclose(output);
    return 0;
}

// function to write YUV422 file to frames
int codec_video::YUV422_write(const char *fileOut, uint32_t n_frames, uint32_t height, uint32_t width, Mat *to_write, string header)
{
    // open file with fopen
    FILE *output = fopen(fileOut, "wb");

    // write header
    fprintf(output, "%s", header.c_str());

    fprintf(output, "\n");
    // write frames
    for (uint32_t i = 0; i < n_frames; i++)
    {
        // write FRAME\n
        fprintf(output, "FRAME\n");

        // write Y values
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k++)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[0], output);
            }
        }

        // write U values, 2 pixels per byte
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[1], output);
            }
        }

        // write V values, 2 pixels per byte
        for (uint32_t j = 0; j < height; j++)
        {
            for (uint32_t k = 0; k < width; k += 2)
            {
                fputc(to_write[i].at<Vec3b>(j, k)[2], output);
            }
        }
    }

    fclose(output);
    return 0;
}

//  function to write the encoded data to a file
int codec_video::write_bin_to_file(const char *fileOut, const string &encoded)
{
    ofstream filew(fileOut, ios::out | ios::binary);
    char buffer = 0;
    int count = 0;
    for (uint32_t i = 0; i < encoded.length(); i++)
    {
        buffer <<= 1;
        if (encoded[i] == '1')
        {
            buffer |= 1;
        }
        count++;
        if (count == 8)
        {
            // print the buffer
            // cout << "BUFFER VAL: "<< buffer << endl;
            filew.write(&buffer, 1);
            buffer = 0;
            count = 0;
        }
    }
    // write last buffer
    // if buffer is not empty
    if (count != 0)
    {
        // write buffer + padding
        buffer <<= (8 - count);
        filew.write(&buffer, 1);
        count = 0;
        buffer = 0;
    }
    filew.close();
    return 0;
}

//  function to read the encoded data from a file
string codec_video::read_bin_from_file(const char *fileIn)
{
    {
        ifstream filer(fileIn, ios::in | ios::binary);
        char c;
        string encoded;
        while (filer.get(c))
        {
            bitset<8> x(c);
            encoded += x.to_string();
        }
        filer.close();

        return encoded;
    }
}