#include <opencv2/opencv.hpp>
#include <iostream>

int main(int argc, char **argv)
{
    if (argc != 4)
    { // check for the right number of arguments
        std::cout << "Usage: " << argv[0] << " <Image_Path> <Output_Path> <Channel_Number>\n";
        return -1;
    }

    cv::Mat image = cv::imread(argv[1], cv::IMREAD_COLOR); // read image file
    if (image.empty())
    {
        std::cout << "Could not read the image: " << argv[1] << std::endl;
        return -1;
    }

    int channel = std::stoi(argv[3]); // get channel from command line

    int bgrChannel; // convert to R (0) G (1) B(2) (instead of opencv default BGR)
    switch (channel)
    {
    case 0:
        bgrChannel = 2;
        break; // Red
    case 1:
        bgrChannel = 1;
        break; // Green
    case 2:
        bgrChannel = 0;
        break; // Blue
    default:
        std::cout << "Invalid channel number. It should be 0 (Red), 1 (Green), or 2 (Blue).\n";
        return -1;
    }

    // create a single channel image with the same size as the input image
    cv::Mat singleChannel(image.rows, image.cols, CV_8UC1);

    for (int y = 0; y < image.rows; ++y)
    { // iterate over each pixel
        for (int x = 0; x < image.cols; ++x)
        {
            uchar color = image.at<cv::Vec3b>(y, x)[bgrChannel]; // extract specific channel value
            singleChannel.at<uchar>(y, x) = color;            // write the color to the single channel image
        }
    }

    // save the single channel image
    cv::imwrite(argv[2], singleChannel);

    return 0;
}
