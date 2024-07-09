#ifndef IMAGE_PROCESSING_H
#define IMAGE_PROCESSING_H

#include <vector>
#include <string>

struct Pixel { // define Pixel structure to represent individual pixels of an image
    unsigned char r, g, b;
};

// function prototype for reading an image file and converting it into a 2D vector of Pixels
std::vector<std::vector<Pixel>> readImage(const std::string &file);

// function prototype for writing a 2D vector of Pixels to an image file
void writeImage(const std::string &file, const std::vector<std::vector<Pixel>> &data);

// function prototype to get the negative of the image
std::vector<std::vector<Pixel>> createNegative(const std::vector<std::vector<Pixel>> &data);

// function prototype to adjust the brightness of an image
void adjustBrightness(std::vector<std::vector<Pixel>> &data, int adjustment);

// function prototype for rotating an image by a specified angle
std::vector<std::vector<Pixel>> rotateImage(const std::vector<std::vector<Pixel>>& data, int angle);

// function prototype for creating a horizontal mirror of an image
std::vector<std::vector<Pixel>> mirrorHorizontal(const std::vector<std::vector<Pixel>> &data);

// function prototype for creating a vertical mirror of an image
std::vector<std::vector<Pixel>> mirrorVertical(const std::vector<std::vector<Pixel>> &data);

#endif
