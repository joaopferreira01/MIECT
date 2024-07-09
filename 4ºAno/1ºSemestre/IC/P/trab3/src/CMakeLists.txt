cmake_minimum_required(VERSION 3.16)
project(trab3)

find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})

SET (CMAKE_BUILD_TYPE "Release")
#SET (CMAKE_BUILD_TYPE "Debug")

SET (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wall -Wextra -std=c++17")
SET (CMAKE_CXX_FLAGS_RELEASE "-O3")
SET (CMAKE_CXX_FLAGS_DEBUG "-g3 -fsanitize=address")

SET (BASE_DIR ${CMAKE_SOURCE_DIR} )
SET (CMAKE_RUNTIME_OUTPUT_DIRECTORY ${BASE_DIR}/../bin)

include_directories(/usr/local/Cellar/libsndfile/1.2.2/include)
link_directories(/usr/local/Cellar/libsndfile/1.2.2/lib)

include_directories(/usr/local/Cellar/fftw/3.3.10_1/include)
link_directories(/usr/local/Cellar/fftw/3.3.10_1/lib)

# Define the executable for the decoder
add_executable (video_decoder main_intra_decoder.cpp codec_video.cpp)
# Link the decoder executable with OpenCV libraries
target_link_libraries(video_decoder ${OpenCV_LIBS})

# Define the executable for the encoder
add_executable (video_encoder main_intra_encoder.cpp codec_video.cpp)
# Link the encoder executable with OpenCV libraries
target_link_libraries(video_encoder ${OpenCV_LIBS})

add_executable (decoder_image decoder_image.cpp)
target_link_libraries(decoder_image ${OpenCV_LIBS})

add_executable (encoder_image encoder_image.cpp)
target_link_libraries(encoder_image ${OpenCV_LIBS})

add_executable (codec_video_tests codec_video_tests.cpp)
target_link_libraries(codec_video_tests ${OpenCV_LIBS})
