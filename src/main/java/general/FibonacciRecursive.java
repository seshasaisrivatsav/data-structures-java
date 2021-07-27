/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;


/**
 *
 * @author seshasai
 */
public class FibonacciRecursive {
    
    public static void main(String[] args){
        int n = 6;
        System.out.println(n+" th fibonacci is "+ fibRecurse(n));
       }
    
    public static int fibRecurse(int n){
     if(n==0 || n==1){
         return n;
     }
     else {
         return fibRecurse(n-1)+ fibRecurse(n-2);
     }
    }
}
