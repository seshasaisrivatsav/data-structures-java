/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.*;
/**
 *
 * @author seshasai
 */
public class SelectionFromSorted {
    
    public static void main(String[] args){
       int[] A = {1,2,3,4,7,99,100};
       int[] B = {12,13,19,20,35,47,90};
       
       
       medianInBoth(A, B);
    }
    
    public static int medianInBoth(int[] A, int[] B){
       
       int median = 0;
       int midA = (int) Math.floor(A.length-1/2);
       int m1 = A[midA];
       int midB = (int) Math.floor(B.length-1/2);
       int m2 = B[midB];
       
       if (m1==m2){
          return m1;
       }
       
       else if(A.length == 2 &&  B.length == 2 ){
           median = (A[1]+B[0])/2;
           return median;
        }
       else if (A.length==1 && B.length==1){
           median = (A[0]+B[0])/2;
           return median;
        }
       else if (m1 < m2){
          //int[] A1= A{1,2};
           medianInBoth(A , B); }
       return median;
    }
    
}
