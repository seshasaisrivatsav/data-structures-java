package arraysAndStrings;

import java.util.Arrays;

public class CheckDuplicates {
    
    public static void main(String[] args){
        int[] A = {9, 1, 2, 3, 9, 3, 3, 3};
        if(checkDups(bubbleSort(A))){
            System.out.println("Has DUpes");
        } else{
            System.out.println("Has no DUpes");
        }
        
        
    }
    
    public static boolean checkDups(int[] A){
         for (int i=0; i< A.length-1; i++){
            if (A[i]==A[i+1]){
                return true;
            }
        }
        return false;
    }
    
    public static int[] bubbleSort(int[] arr){
       for (int i=0; i<arr.length; i++){
           for (int j=0; j<arr.length-i-1; j++) {
               if(arr[j] > arr[j+1]) { // swap j, j+1
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1]=temp;
               }
           }
        }
        return arr;
    }
}
