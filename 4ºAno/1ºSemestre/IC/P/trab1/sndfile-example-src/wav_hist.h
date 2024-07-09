#ifndef WAVHIST_H
#define WAVHIST_H

#include <iostream>
#include <vector>
#include <map>
#include <sndfile.hh>
#include <cmath>

class WAVHist {
  private:
  std::vector<std::map<short, size_t>> counts;
  std::map<short, size_t> avg_counts; // Histogram for average of channels
  std::map<short, size_t> diff_counts; // Histogram for difference of channels
  int coarseness_factor; // to determine 2^k 

  public:
  WAVHist(const SndfileHandle& sfh, int k): coarseness_factor(pow(2,k)) {
    counts.resize(sfh.channels());
  }

  // Adjusts the sample to the coarseness factor
  // For a coarseness factor of 2k, the sample value can be divided by 2k and then multiplied by 2k, effectively rounding it down to the nearest multiple of 2k.
  short adjustForCoarseness(short sample) const {
    return (sample / coarseness_factor) * coarseness_factor;
  }

  void update(const std::vector<short>& samples) {
    size_t n { };
    for(auto s : samples)
      counts[n++ % counts.size()][adjustForCoarseness(s)]++;
  }

  void update_avg(const std::vector<short>& samples, int num_channels) {
    if (num_channels == 2)
    {
      for (size_t i = 0; i < samples.size(); i += 2) {
        short left = samples[i];
        short right = samples[i + 1];
        
        short avg = adjustForCoarseness((left + right) / 2);
        avg_counts[avg]++;
      }
    }
  }

  void update_diff(const std::vector<short>& samples, int num_channels) {
    if (num_channels == 2)
    {
      for (size_t i = 0; i < samples.size(); i += 2) {
        short left = samples[i];
        short right = samples[i + 1];
        
        short diff = adjustForCoarseness((left - right) / 2);
        diff_counts[diff]++;
      }
    }
  } 

  void dump(const size_t channel, const std::string version) const {
    if (version == "avg")
    {
      std::cout << "Average (MID) channel:\n";
      for(auto [value, counter] : avg_counts)
      std::cout << value << '\t' << counter << '\n';
    }
    else if (version == "diff")
    {
      std::cout << "Difference (SIDE) channel:\n";
      for(auto [value, counter] : diff_counts)
        std::cout << value << '\t' << counter << '\n';
    }
    else
    {
      std::cout << "Normal (Stereo) channel:\n";
      for(auto [value, counter] : counts[channel])
      std::cout << value << '\t' << counter << '\n';
    }
  }
};

#endif