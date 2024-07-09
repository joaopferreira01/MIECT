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

std::vector<std::vector<Pixel>> rotateImage(const std::vector<std::vector<Pixel>>& data, int angle) {
    angle = (angle % 360 + 360) % 360; // normalize the angle to one of 0, 90, 180, 270 degrees

    if (angle % 90 != 0) { // check if the angle is a multiple of 90
        throw std::invalid_argument("Rotation angle must be a multiple of 90 degrees");
    }

    int height = data.size();
    int width = data[0].size();
    std::vector<std::vector<Pixel>> result;

    switch (angle) {
        case 90: // rotate clockwise by 90 degrees
            result.resize(width, std::vector<Pixel>(height));
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    result[x][height - 1 - y] = data[y][x];
                }
            }
            break;

        case 180: // rotate by 180 degrees
            result.resize(height, std::vector<Pixel>(width));
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    result[height - 1 - y][width - 1 - x] = data[y][x];
                }
            }
            break;

        case 270: // rotate by 270 degrees
            result.resize(width, std::vector<Pixel>(height));
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    result[width - 1 - x][y] = data[y][x];
                }
            }
            break;

        default:
            return data; // for 0 degrees or any multiple of 360 degrees, return the original image
    }

    return result;
}



int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "Usage: " << argv[0] << " <input_file> <output_file> <angle>" << std::endl;
        return 1;
    }

    std::string inputFile = argv[1]; // get input file
    std::string outputFile = argv[2]; // get output file name
    int angle = std::stoi(argv[3]); // get rotation angle [90, 180, 270]

    try {
        auto imageData = readImage(inputFile); // read image
        std::vector<std::vector<Pixel>> rotatedImage;

        rotatedImage = rotateImage(imageData, angle); // rotate image according to the rotation angle

        writeImage(outputFile, rotatedImage); // store image in the output file
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
