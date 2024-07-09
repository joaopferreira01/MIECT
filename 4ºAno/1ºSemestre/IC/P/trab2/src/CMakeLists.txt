cmake_minimum_required(VERSION 3.16)
project(sndfile-example)

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

add_executable (golomb_coder golomb_coder.cpp)

add_executable (golomb_codec golomb_codec.cpp)
target_link_libraries(golomb_codec sndfile)

add_executable(brightness brightness.cpp)
target_link_libraries(brightness ${OpenCV_LIBS})
add_executable (negative_image negative_image.cpp)
target_link_libraries(negative_image ${OpenCV_LIBS})
add_executable (mirror_image mirror_image.cpp)
target_link_libraries(mirror_image ${OpenCV_LIBS})
add_executable (rotate_image rotate_image.cpp)
target_link_libraries(rotate_image ${OpenCV_LIBS})
add_executable(extract_color extract_color.cpp)
target_link_libraries(extract_color ${OpenCV_LIBS})
