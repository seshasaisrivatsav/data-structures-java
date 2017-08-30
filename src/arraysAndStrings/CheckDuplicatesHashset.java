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
public class CheckDuplicatesHashset {
    
    public static void main(String[] args){
       int[] A = { 6,5, 7, 1, 4, 6};
       checkHashset(A);
        
    }
    
    public static void checkHashset(int[] A){
        HashSet<Integer> myHashSet = new HashSet<Integer>();
        
        for(int i=0; i<A.length; i++){
            if(myHashSet.contains(A[i])){
                System.out.println("Has dupes");
                return;
            }
             myHashSet.add(A[i]);   
        }
         System.out.println("Has no dupes");
        
        
    }
}
