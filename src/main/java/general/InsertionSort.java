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
public class InsertionSort {
    
    public static void main(String[] args){
        
        int[] array = {1, 2, 3, 4, 5, 6};
        insertionSort(array);
    }
    
    public static void insertionSort(int array[]){
        
        for (int j = 1; j< array.length; j++){
            int i = j-1;
            int key = array[j];
            while(i>0 && array[i]> key){
                array[i+1]=array[i];
                i=i-1;
            }
            array[i+1]=key;
            printnumbers(array);
        }
            
             
    }
    
    public static void printnumbers(int[] input){
          for (int i = 0; i < input.length; i++) {
            System.out.print( input[i] +" " );
        }
        System.out.println("\n");

    }
}
