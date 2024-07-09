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

std::vector<std::vector<Pixel>> createNegative(const std::vector<std::vector<Pixel>> &data) {
    std::vector<std::vector<Pixel>> result = data; // get a copy of the image

    // iterate over each pixel and invert the colors by subtracting the current value from 255
    for (auto &row : result) {
        for (auto &pixel : row) {
            pixel.r = 255 - pixel.r; // red component
            pixel.g = 255 - pixel.g; // green component
            pixel.b = 255 - pixel.b; // blue component
        }
    }

    return result;
}

int main(int argc, char* argv[]) {
    if (argc != 3) { // check for the correct number of args
        std::cerr << "Usage: " << argv[0] << " <input_file> <output_file>" << std::endl;
        return 1;
    }

    std::string inputFile = argv[1]; // get input image
    std::string outputFile = argv[2]; // get output image name

    try {
        auto imageData = readImage(inputFile); // read image
        auto negativeImage = createNegative(imageData); // get the negative image
        writeImage(outputFile, negativeImage); // write to the output file
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
