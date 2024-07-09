#include <opencv2/opencv.hpp>
#include <iostream>
#include <string>
#include <cstdlib>
#include "image_processing.h"

// read an image file and convert it into a 2D vector of Pixels
std::vector<std::vector<Pixel>> readImage(const std::string &file) {
    cv::Mat img = cv::imread(file, cv::IMREAD_COLOR); // Read the image using OpenCV

    if (img.empty()) { // check if image loading was successful
        throw std::runtime_error("Error in loading the image");
    }

    int height = img.rows;
    int width = img.cols;
    std::vector<std::vector<Pixel>> data(height, std::vector<Pixel>(width));

    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            cv::Vec3b color = img.at<cv::Vec3b>(cv::Point(x,y));
            data[y][x] = {color[2], color[1], color[0]}; // Note: OpenCV uses BGR format
        }
    }

    return data;
}

// function to write a 2D vector of Pixels to an image file
void writeImage(const std::string &file, const std::vector<std::vector<Pixel>> &data) {
    int height = data.size();
    int width = data[0].size();
    cv::Mat img(height, width, CV_8UC3); // OpenCV image

    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            img.at<cv::Vec3b>(cv::Point(x,y)) = cv::Vec3b(data[y][x].b, data[y][x].g, data[y][x].r); // Note: OpenCV uses BGR format
        }
    }

    cv::imwrite(file, img); // Write the image using OpenCV
}

// function to adjust the brightness of an image
void adjustBrightness(std::vector<std::vector<Pixel>> &data, int adjustment) {
    for (auto &row : data) { // iterate over each row
        for (auto &pixel : row) { // iterate over each pixel
            // adjust the red, green, and blue components
            pixel.r = std::min(std::max(pixel.r + adjustment, 0), 255); // increase or decrease the red component
            pixel.g = std::min(std::max(pixel.g + adjustment, 0), 255); // increase or decrease the green component
            pixel.b = std::min(std::max(pixel.b + adjustment, 0), 255); // // increase or decrease the blue component
        }
    }
}

int main(int argc, char* argv[]) {
    if (argc != 4) { // check number of args
        std::cerr << "Usage: " << argv[0] << " <input_file> <output_file> <brightness_adjustment>" << std::endl;
        return 1;
    }

    std::string inputFileName = argv[1]; // get input image
    std::string outputFileName = argv[2]; // get output image name
    int brightnessAdjustment = std::atoi(argv[3]); // get brightness adjustment value

    try {
        auto imageData = readImage(inputFileName); // read image
        adjustBrightness(imageData, brightnessAdjustment); // adjust the brightness
        writeImage(outputFileName, imageData); // write adjusted image to the output file
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
