package org.berlin.algo.basic.test;

import java.util.ArrayList;
import java.util.List;

import org.berlin.algo.basic.InsertionSortRecursionLists;
import org.berlin.algo.basic.ScalarSum;
import org.berlin.algo.basic.InsertionSortRecursionLists.Pair;

public class T1 {

  public static void t2() {
    final InsertionSortRecursionLists test = new InsertionSortRecursionLists();
    {    
    final List<Integer> lst = new ArrayList<Integer>();
    lst.add(1);
    lst.add(2);
    lst.add(3);
    System.out.println(test.toXs(lst));
    System.out.println(test.toXs(new ArrayList<Integer>()));
    }
    {
    System.out.println("Test2:");    
    final List<Integer> list2 = new ArrayList<Integer>();
    list2.add(4);
    list2.add(5);
    list2.add(6);
    final Pair<Integer, List<Integer>> xxs = test.toXs(list2);
    System.out.println(test.insert(1, xxs.xs()));
    System.out.println(test.insert(7, xxs.xs()));
    }
  }  
  public static void main(final String [] args) {
    System.out.println("Running scalar test");
    System.out.println("Sum: " + new ScalarSum().sum(new ScalarSum.Fx2(), 1, 100));    
    System.out.println("Done");    
    t2();
  }
  
}
