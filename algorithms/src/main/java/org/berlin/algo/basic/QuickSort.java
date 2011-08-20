/**
 * Copyright (c) 2006-2010 Berlin Brown and botnode.com  All Rights Reserved
 *
 * http://www.opensource.org/licenses/bsd-license.php

 * All rights reserved.

 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:

 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * * Neither the name of the Botnode.com (Berlin Brown) nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * QuickSort.java
 * May 7, 2011
 * bbrown
 * Contact: Berlin Brown <berlin dot brown at gmail.com>
 */
package org.berlin.algo.basic;

/**
 * @author bbrown
 *
 */
public class QuickSort {
    
    public void quickSort(final int [] A) {
        quickSort(A, 0, A.length-1);
    }
    
    public void quickSort(final int [] A, final int p, final int r) {
        if (p < r) {
            final int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }
    
    public int partition(final int [] A, final int p, final int r) {        
        final int x = A[r];
        int i = p - 1;        
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i = i + 1;
                exchange(A, i, j);                
            }
        } // End of for
        exchange(A, i+1, r);        
        return i + 1;
    }
    public void exchange(final int [] array, int i, int j) {    
        final int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    
    
    public static void main(final String [] args) {
        System.out.println("Running main - quick sort");
        final int A [] = {
            5, 2, 4, 6, 1, 3
        };
        new QuickSort().quickSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
        System.out.println("Done");
      }
    
    
}
