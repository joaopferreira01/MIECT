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

// create a horizontal mirror of an image
std::vector<std::vector<Pixel>> mirrorHorizontal(const std::vector<std::vector<Pixel>> &data) {
    std::vector<std::vector<Pixel>> result = data; // copy of the original image data
    int width = result[0].size();
    int height = result.size();
    
    // iterate through each row and swap pixels horizontally
    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width / 2; ++x) { // width / 2 ensures that each pixel is only swapped onceº
            // without width / 2, reaching the midpoint of the image, starts swapping the pixels back 
            // to their original positions.
            std::swap(result[y][x], result[y][width - x - 1]); // swap pixels for horizontal mirroring
        }
    }

    return result;
}

// create a vertical mirror of an image
std::vector<std::vector<Pixel>> mirrorVertical(const std::vector<std::vector<Pixel>> &data) {
    std::vector<std::vector<Pixel>> result = data; // copy of the original image data
    int width = result[0].size();
    int height = result.size();

    // iterate through each row and swap pixels vertically
    for (int x = 0; x < width; ++x) {
        for (int y = 0; y < height / 2; ++y) { // height / 2 ensures that each pixel is only swapped once
            std::swap(result[y][x], result[height - y - 1][x]); // swap pixels for vertical mirroring
        }
    }

    return result;
}

int main(int argc, char* argv[]) {
    if (argc != 4) { // check number of args
        std::cerr << "Usage: " << argv[0] << "<input_file> <output_file_horizontal> <output_file_vertical>" << std::endl;
        return 1;
    }

    std::string inputFile = argv[1];
    std::string outputFileHorizontal = argv[2];
    std::string outputFileVertical = argv[3];

    try {
        auto imageData = readImage(inputFile); // read image

        auto mirroredHorizontal = mirrorHorizontal(imageData); // mirror image horizontally
        writeImage(outputFileHorizontal, mirroredHorizontal); // write mirroed image to output file

        auto mirroredVertical = mirrorVertical(imageData); // mirror image vertically
        writeImage(outputFileVertical, mirroredVertical); // write mirroed image to the output file
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}