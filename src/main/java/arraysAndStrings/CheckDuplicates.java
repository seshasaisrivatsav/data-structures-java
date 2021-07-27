/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysAndStrings;
import java.util.*;
/**
 *
 * @author seshasai
 */
public class CheckDuplicates {
    
    public static void main(String[] args){
       
               
        int[] A = {9, 1, 2, 3, 9, 3, 3, 3};
        if(checkDups(bubbleSort(A)) == true){
            System.out.println("Has DUpes");
        }else{
               System.out.println("Has no DUpes");
        }
        
        
    }
    
    public static boolean checkDups(int[] A){
         for(int i=0; i< A.length-1; i++){
            if (A[i]==A[i+1]){
                return true;
            }
        }
        return false;      
      
    }
    
    public static int[] bubbleSort(int[] A){
       for(int i=0; i<A.length-1; i++){
            if(A[i]>A[i+1]){
                int temp = A[i];
                A[i+1] = A[i];
                A[i]=temp;
            }
        }
        return A;
    }
}
