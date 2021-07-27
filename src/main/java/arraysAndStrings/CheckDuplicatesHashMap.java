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
public class CheckDuplicatesHashMap {
    
    public static void main(String[] args){
        int[] A = {1, 2,3,4,7};
        checkHashMap(A);
    }
    
    public static void checkHashMap(int[] A){
        HashMap<Integer, Integer> myHashMap = new HashMap<Integer,Integer>();
        int count=0;
        for (int i=0;i<A.length;i++){
            if(myHashMap.containsKey(A[i])){
                System.out.println("There are duplicates");
                return;
            }else{
                myHashMap.put(A[i], count+1);
            }
        }
        System.out.println("There are no duplicates");
        
        
    }
    
}
