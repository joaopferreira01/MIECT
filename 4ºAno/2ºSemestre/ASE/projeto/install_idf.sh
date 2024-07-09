#!/bin/bash

# Installing prerequisites
echo "## Install prerequisites"

export DEBIAN_FRONTEND=noninteractive

sudo apt-get install -y git wget flex bison gperf python3 python3-pip python3-setuptools cmake ninja-build ccache libffi-dev libssl-dev dfu-util

# Making Python 3 the default interpreter
sudo update-alternatives --install /usr/bin/python python /usr/bin/python3 10

# Create the esp directory for repo download
mkdir ~/esp
cd ~/esp

echo "## Download esp-idf repository"
git clone --recursive --depth=1 --shallow-submodules https://github.com/espressif/esp-idf.git

# Navigate to esp idf repository
cd ~/esp/esp-idf

# Installing tools
echo "## Install esp-idf tools"

# Install required tools
./install.sh