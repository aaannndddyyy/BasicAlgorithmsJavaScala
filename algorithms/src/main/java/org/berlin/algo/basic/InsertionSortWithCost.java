/**
 * Berlin Brown 
 * Insertion Sort.
 */
package org.berlin.algo.basic;

import java.util.Random;

/**
 * Insertion Sort with simple cost and time statistics.
 * Based on logic from "Introduction to algorithms", coreman, stein.
 */
public class InsertionSortWithCost {

  private final CalledTimesCount times = new CalledTimesCount();
  
  private class CalledTimesCount {
    private int c1N = 0;
    private int c2N = 0;
    private int c4N = 0;
    private int c5N = 0;
    private int c6N = 0;  
    private int c7N = 0;
    private int c8N = 0;
    
    public String toString() {
      return "{Cost and Times T(n): N-for-C2=" + c2N + ", N-for-C6=" + c6N + ", N-for-C8=" + c8N + "}";
    }
  }  
  public InsertionSortWithCost insertionSort(final int [] A) {           
    int i = 0;
    int key = 0;
    // n = length[A]
    times.c1N = A.length;
    for (int j = 1; j < A.length; j++) {        
        key = A[j];        
        i = j - 1;
        times.c2N++;
        times.c4N = times.c2N;
        int tj = 0;
        while(i >= 0 && A[i] > key) {          
          times.c6N++;
          tj++;
          A[i + 1] = A[i];
          i = i - 1;          
        } // End of while
        A[i + 1] = key;
        times.c8N++;
    } // End of for
    return this;
  }
  public String toString() {
    return String.valueOf(times);
  }
  
  public static void logBefore(final int [] A) {
    System.out.print("A {N=" + A.length + "}= [");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println("].");    
  }  
  public static void logAfter(final int [] A, final InsertionSortWithCost insertionSort) {

    System.out.print("A(after sort) = [");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println("].");
    System.out.println(insertionSort);
    System.out.println();     
  }
  
  public static void main(final String [] args) {
    System.out.println("Running main - insertion sort");
    {
      final int A [] = {
          5, 2, 4, 6, 1, 3
      };
      logBefore(A);
      // Run the insertion sort and update the entries for the array A
      final InsertionSortWithCost insertionSort = new InsertionSortWithCost().insertionSort(A);
      logAfter(A, insertionSort);          
    }
    {
      // With random N
      final int A2 [] = new int [30];
      final Random rand = new Random(System.currentTimeMillis());
      for (int i = 0; i < A2.length; i++) {
        A2[i] = rand.nextInt(1000);
      }
      logBefore(A2);    
      final InsertionSortWithCost insertionSort2 = new InsertionSortWithCost().insertionSort(A2);
      logAfter(A2, insertionSort2);
    }
    {
      // Best case with sorted values.
      final int A3 [] = {
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
      };
      logBefore(A3);
      // Run the insertion sort and update the entries for the array A
      final InsertionSortWithCost insertionSort = new InsertionSortWithCost().insertionSort(A3);
      logAfter(A3, insertionSort);          
    }
    System.out.println("Done");
  }  
  
} // End of the Class //
