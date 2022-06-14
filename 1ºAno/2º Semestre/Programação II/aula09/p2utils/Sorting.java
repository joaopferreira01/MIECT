package p2utils;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 * This class contains several sorting algorithms and
 * auxiliary methods and fields for evaluating their complexity.
 */
public class Sorting {

  // Fields to measure times:
  public static long startTime;  // start time of latest measurement (in ns)
  public static double elapsedTime;  // seconds elapsed in latest measurement

  // Fields to count operations: 
  public static long assignmentCount = 0L;
  public static long comparisonCount = 0L;

  // Start a new measurement
  public static void startMeasuring() {
    assignmentCount = 0L;
    comparisonCount = 0L;
    startTime = nanoTime();
  }

  // Stop a measurement (determine elapsedTime)
  public static void stopMeasuring() {
    elapsedTime = (double)(nanoTime() - startTime) * 1e-9;
  }


  /**
   * Sequential sort ("greedy" variation of selection sort).
   * Increasing sorting of integer subarray a[start..end[
   * @param a      the array to be (partially) sorted.
   * @param start  index of the first element to sort.
   * @param end    index of the first element not to be sorted (the last element to sort is {@code end-1}).
   * Requires:   a!=null and 0 <= start <= end <= a.length
   * Ensures:  The elements a[k] with start <= k < end are sorted.  the remaining elements are not changed.
   */
  public static void sequentialSort(int[] a, int start, int end) {
    assert a!=null;
    assert 0<=start && start<=end && end<=a.length;

    for (int i=start; i<end-1; i++) { // For each element (except the last):
      for (int j=i+1; j<end; j++) {   // Scan every following element
        if (a[j] < a[i]) {            // compare them
          swap(a, i, j);              // if necessary, swap them
        }
      }
    }
  }

  /**
   * Bubble sort.
   * Optimized version.
   */
  public static void bubbleSort(int[] a, int start, int end) {
    assert a!=null;
    assert 0<=start && start<=end && end<=a.length;

    while (start < end-1) {
      int last = start;
      for (int i=start; i<end-1; i++) {
        if (a[i] > a[i+1]) {
          swap(a, i, i+1);
          last = i;   // store index of the last swap
        }
      }
      // Elements a[last+1, end[ must be sorted now
      // So, next pass may stop there
      end = last+1;
    }
  }

  /**
   * Swaps two elements of an integer array.
   * @param a the array
   * @param i index of an element to swap
   * @param j index of the other element to swap
   * {@code i},{@code j} must be valid indexes within array {@code a}
   */
  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public static void insertionSort(int[] a, int start, int end) {
    //...

  }

  public static void mergeSort(int[] a, int start, int end) {
    //...

  }

  // Test if [start, end[ defines a valid interval of indices in array a.
  public static boolean validSubarray(int[] a, int start, int end) {
    return a != null && 0 <= start && start <= end && end <= a.length;
  }

  public static boolean isSorted(int[] a, int start, int end) {
    assert validSubarray(a, start, end);
    boolean result = true;
    for(int i = start; result && i < end-1; i++)
      result = a[i] <= a[i+1];
    return result;
  }



  // Generic method for sorting arrays of any reference type:
  public static <E extends Comparable<E>>
  void mergeSort(E[] a, int start, int end) {
    //...

  }

}

