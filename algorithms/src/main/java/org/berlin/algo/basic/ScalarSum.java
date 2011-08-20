/**
 * Berlin Brown
 * Simple scalar sum class in Java. 
 */
package org.berlin.algo.basic;

/**
 * Simple scalar sum class.
 * Normally use j=1, stops at n.
 * <pre>
 * Sum:
 * i=1, n=100, summation = 5050
 * </pre>
 * 
 * <pre>
 * System.out.println("Sum: " + new ScalarSum().sum(new ScalarSum.Fx(), 1, 100));
 * Output: 5050
 * </pre>
 */
public class ScalarSum {   
  public int sum(final f f, int j, int n) {
    int sum = 0;
    for (int index = j; index <= n; index++) {      
      sum = sum + f.$(index);
    }    
    return sum;
  }  
  public interface f {
    public int $(final int x);    
  }
  public static class Fx implements f {
    public int $(int x) {
      return x;
    }    
  }  
  public static class Fx2 implements f {
    public int $(int x) {
      return x*x;
    }    
  }
  public static class Fx3 implements f {
    public int $(int x) {
      return x*x*x;
    }    
  }
}

