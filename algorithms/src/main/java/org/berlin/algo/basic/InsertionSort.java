/**
 * Berlin Brown, berlin dot brown at gmail.com
 * Insertion Sort in Java.
 */
package org.berlin.algo.basic;

/**
 * Insertion Sort.
 * Based on logic from "Introduction to algorithms", coreman, stein.
 */
public class InsertionSort {

  public void insertionSort(final int [] A) {           
    int i = 0;
    int key = 0;
    for (int j = 1; j < A.length; j++) {
        key = A[j];        
        i = j - 1;
        while(i >= 0 && A[i] > key) {
          A[i + 1] = A[i];
          i = i - 1;
        } // End of while
        A[i + 1] = key;
    } // End of for    
  }
  
  public static void main(final String [] args) {
    System.out.println("Running main - insertion sort");
    final int A [] = {
        5, 2, 4, 6, 1, 3
    };
    System.out.print("A = <");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println(">.");
    
    new InsertionSort().insertionSort(A);
    
    System.out.print("A(after sort) = <");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println(">.");
    System.out.println("Done");
  }
  
} // End of the Class //
