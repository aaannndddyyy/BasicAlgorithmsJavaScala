/**
 * Berlin Brown , berlin dot brown at gmail.com
 * 
 * Java Insertion Sort based on Haskell impl (Convert from Haskell to Java).
 * 
 */
package org.berlin.algo.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Insertion Sort using list of integers.
 * Based on logic from "Introduction to algorithms", coreman, stein.
 *
 * Using recursion for later use with Haskell.
 * 
 * Expected Output:
 * <pre>
 * Running main - insertion sort - with recursion
 * A {N=11}= [5, 2, 4, 6, 1, 3, 83, 12, 3, 5, 7, ].
 * A(after sort) = [1, 2, 3, 3, 4, 5, 5, 6, 7, 12, 83, ].
 * </pre>
 */
public class InsertionSortRecursionLists {
  
/* 
 * Based on Haskell version:
  insert e [] = [e]
  insert e lst@(x:xs)
    | e < x     = e : lst
    | otherwise = x : (insert e xs)
  insertionSort lst = insertionSort' lst [] where
    insertionSort' [] lst = lst
    insertionSort' (x:xs) lst = insertionSort' xs (insert x lst)
 */
  
  public InsertionSortRecursionLists insertionSort(final Integer [] A) {    
    final List<Integer> list = Arrays.asList(A);
    final List<Integer> res = insertionSort(list);
    int i = 0;    
    for (final Integer x : res) {
      A[i] = x;
      i++;
    }
    return this;
  }
  public List<Integer> insertionSort(final List<Integer> A) {
    if ((A == null) || (A.size() == 0)) { 
      return $();
    }
    if (A.size() == 1) {
      return A;
    }
    final Pair<Integer, List<Integer>> xxs = toXs(A);    
    return insertionSort(xxs, $());
  }  
  public List<Integer> insertionSort(final Pair<Integer, List<Integer>> xxs, final List<Integer> addToLst) {           
    if (xxs.x() == null) {
      // insertionSort' [] lst = lst
      return addToLst;
    } else {
      // Haskell: insertionSort' (x:xs) lst = insertionSort' xs (insert x lst)
      // Java code for this declaration
      return insertionSort(toXs(xxs.xs()), insert(xxs.x(), addToLst));
    }
  } 
  public List<Integer> insert(final Integer e, final List<Integer> lst) {
    final Pair<Integer, List<Integer>> xxs = toXs(lst);    
    final Integer x = xxs.x();
    final List<Integer> xs = xxs.xs();                 
    if ((lst == null) || (lst.size() == 0)) {
      final List<Integer> l = $();
      l.add(e);
      return l;
    } else {
      // Haskell:
      // insert e lst@(x:xs)
      //  | e < x     = e : lst
      //  | otherwise = x : (insert e xs)
      if (e < x) {
        final List<Integer> addEtoList = $();
        addEtoList.add(e);
        for (final Integer z:lst) { addEtoList.add(z);}               
        return addEtoList;
      } else {            
        final List<Integer> recursiveResultCallInsert = insert(e, xs);
        final List<Integer> addXtoRecursiveList = $();
        addXtoRecursiveList.add(x);
        for (final Integer z:recursiveResultCallInsert) {
          addXtoRecursiveList.add(z);
        }       
        return addXtoRecursiveList;
      }
    }
  }
  /**
   * Return x:xs
   * @param lst
   * @return
   */
  public Pair<Integer, List<Integer>> toXs(final List<Integer> lst) {
    if ((lst == null) || (lst.size() == 0)) {
      return new Pair<Integer, List<Integer>>(null, $());
    } else if (lst.size() == 1) {
      return new Pair<Integer, List<Integer>>(lst.get(0), $());
    }    
    final Integer x = lst.get(0);
    final List<Integer> xs = $();
    for (int i = 1; i < lst.size(); i++) { xs.add(lst.get(i)); }
    return new Pair<Integer, List<Integer>>(x, xs);
  }
  public List<Integer> xsToList(final Pair<Integer, List<Integer>> xxs) {
    final List<Integer> addToList = $();
    addToList.add(xxs.x());
    for (final Integer z:xxs.xs()) { addToList.add(z);}               
    return addToList;
  }
  public final List<Integer> $() {
    return new ArrayList<Integer>();
  }
  public static class Pair <T, S> implements Serializable {        
     private static final long serialVersionUID = -2202117371650541073L;   
     private final T first;
     private final S second;
     public Pair(final T f, final S s) {
         first = f;
         second = s;
     }
     public T x() {
         return getFirst();
     }
     public S xs() {
         return getSecond();
     }
     public T getFirst() {
         return first;
     }     
     public S getSecond() {
         return second;
     }
     /**
      * Return String string representation of object.
      * @return String
      */
     public String toString() {
         return "(" 
             + ((first  == null) ? "" : first.toString()) + ", " 
             + ((second == null) ? "" : second.toString()) + ")";
     }
  }     
  public static void logBefore(final Integer [] A) {
    System.out.print("A {N=" + A.length + "}= [");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println("].");    
  }  
  public static void logAfter(final Integer [] A, final InsertionSortRecursionLists insertionSort) {

    System.out.print("A(after sort) = [");
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", " );
    }
    System.out.println("].");    
    System.out.println();     
  }
  
  public static void main(final String [] args) {
    System.out.println("Running main - insertion sort - with recursion");
    {
      final Integer A [] = {
          5, 2, 4, 6, 1, 3, 83, 12, 3, 5, 7
      };
      logBefore(A);
      // Run the insertion sort and update the entries for the array A
      final InsertionSortRecursionLists insertionSort = new InsertionSortRecursionLists().insertionSort(A);
      logAfter(A, insertionSort);          
    }         
    {
      // With random N
      final Integer A2 [] = new Integer [30];
      final Random rand = new Random(System.currentTimeMillis());
      for (int i = 0; i < A2.length; i++) {
        A2[i] = rand.nextInt(1000);
      }
      logBefore(A2);    
      final InsertionSortRecursionLists insertionSort2 = new InsertionSortRecursionLists().insertionSort(A2);
      logAfter(A2, insertionSort2);
    }
    System.out.println("Done");
  }  
  
} // End of the Class //
