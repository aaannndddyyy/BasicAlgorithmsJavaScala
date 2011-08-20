package org.berlin.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Misc euler problem. 
 */
public class EulerProblem18 {

  static class Data {
    private final List<List<Integer>> data = new ArrayList<List<Integer>>();
    
    public Data print() {
      for (final List<Integer> arr : data) {
        System.out.print("{");
        for (final Integer a : arr ) {
          System.out.print(a + ", ");
        }
        System.out.println("}");
      } // End of the for //
      return this;
    }
    public Data addRow(final Integer [] arr) {
      final List<Integer> row = new ArrayList<Integer>();
      for (final Integer x : arr) {
        row.add(x);
      }
      data.add(row);
      return this;
    }          
    public List<List<Integer>> getData() {
      return this.data;
      
    }
    public Data testData() {
      this.addRow(new Integer [] {3});
      this.addRow(new Integer [] {7, 4});
      this.addRow(new Integer [] {2, 4, 6});
      this.addRow(new Integer [] {8, 5, 9, 3});
      return this;
    }
    public Data testData2() {
            
      this.addRow(new Integer [] {75});
      this.addRow(new Integer [] {95, 64});
      this.addRow(new Integer [] {17, 47, 82});
      this.addRow(new Integer [] {18, 35, 87, 10});
      this.addRow(new Integer [] {20, 4, 82, 47, 65});
      this.addRow(new Integer [] {19, 1, 23, 75, 3, 34});
      this.addRow(new Integer [] {88, 2, 77, 73, 7, 63, 67});
      this.addRow(new Integer [] {99, 65, 4, 28, 6, 16, 70, 92});
      this.addRow(new Integer [] {41, 41, 26, 56, 83, 40, 80, 70, 33});
      this.addRow(new Integer [] {41, 48, 72, 33, 47, 32, 37, 16, 94, 2,9});
      this.addRow(new Integer [] {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14});
      this.addRow(new Integer [] {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57});
      this.addRow(new Integer [] {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48});
      this.addRow(new Integer [] {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31});
      this.addRow(new Integer [] {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23});      
      return this;
    }
    
    static int numbers [][] = {
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        /*
        {20, 4, 82, 47, 65},
        {19, 1, 23, 75, 3, 34},
        {88, 2, 77, 73, 7, 63, 67},
        {99, 65, 4, 28, 6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23} */
    };    
  }  // End of data //
  
  static class EulerProblem {    
    public int maxSimpleSum(final int [][] graph, final int x, final int y, final int sum, final List<String> path) {
      path.add("{x=" + x + ",y=" + y + "v=" + graph[x][y] + "}");
      if (x == graph.length-1) {
        return sum + graph[x][y];
      }
      final int a = maxSimpleSum(graph, x + 1, y, sum, path);
      final int b = maxSimpleSum(graph, x + 1, y + 1, sum, path);
      final int max = Math.max(a, b);      
      
      final int newSum = sum + graph[x][y];
      return newSum + max;
    }
    /**
     * Simple build random path for debugging.
     * @param d
     * @return
     */
    public List<Integer> buildRandomPath(final Data d) {
      final List<List<Integer>> data = d.getData();
      final List<Integer> newPath = new ArrayList<Integer>();      
      final int lenRows = data.size();
      int onNextRowCol = 0;
      final Random rand = new Random();
      newPath.add(data.get(0).get(0));
      onNextRowCol = rand.nextBoolean() ? 1 : 0;
      for (int i = 1; i < lenRows; i++) {
        final List<Integer> row = data.get(i);
        final int lenCols = row.size();
        if (rand.nextBoolean()) {
          onNextRowCol--;
        } else {
          onNextRowCol++;
        }
        if (onNextRowCol < 0) { onNextRowCol = 1; } 
        if (onNextRowCol >= lenCols) { onNextRowCol = lenCols-2; }
        newPath.add(row.get(onNextRowCol));
      } // end of for //          
      return newPath;
    }
    public int sumSimple(final List<Integer> data) {
      int sum = 0;
      for (final Integer a : data) {
        sum += a;
      } // End of the for //
      return sum;
    }
    public EulerProblem printRandomPath(final Data d) {      
      final List<Integer> path = buildRandomPath(d);      
        System.out.print("{path ");
        for (final Integer a : path) {
          System.out.print(a + " -> ");
        }
        System.out.println("<- }");
        System.out.println("Sum = " + sumSimple(path));
      return this;
    }
    public EulerProblem randomSums(final Data d) {
      int max = -1;
      final List<Integer> sum = new ArrayList<Integer>();
      for (int i = 0; i < (10000 * d.getData().size()); i++) {        
        final int v = sumSimple(buildRandomPath(d));
        //System.out.print(", i:" + i + ";" + sumSimple(buildRandomPath(d)));
        max = Math.max(v, max);
        sum.add(v);
      }
      System.out.println();
      System.out.println("MaxRandom = " + max);
      int totalMaxFound = 0;
      for (final Integer a:sum) {
        if (a == max){
          totalMaxFound++;
        }
      }
      // basic statistics
      final String p = String.format("%.1f%%", 100.0 * ((double) totalMaxFound / sum.size()));
      System.out.println("Probability : fnd=" + totalMaxFound + " / " + sum.size() + " p=" + p);
      return this;
    }
  } // End of Euler Problems
  
  public static void main(final String [] args) {
    System.out.println("Running");
    final Data d = new Data();
    //d.testData().print();
    d.testData2().print();
    new EulerProblem().printRandomPath(d);
    new EulerProblem().randomSums(d);
    
    // New simple approach
    final List<String> path = new ArrayList<String>();
    System.out.println("Max from simple sum : " + new EulerProblem().maxSimpleSum(Data.numbers, 0, 0, 0, path));
    System.out.println("Simple Path ; ");
    int i = 0;
    for (final String a : path) {
      System.out.print("i:" + i + "; " + a + " -> ");
      if ((i % 10) == 0) {
        System.out.println();
      }                          
      i++;
    }
    System.out.println("<- }");
    System.out.println("Done");
  }   
} // End of class 

