package arraysAndStrings;

import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(leftRotate(arr, 2)));
    }
    
    public static int[] leftRotate(int[] arr, int rotations){
        rotations = rotations % arr.length; // if array length is 5, rotating 5, 10, 15, 20, 25 times gives same result
        if (rotations == 0) {
            return arr;
        }
        int newPos, temp;
        for(int i=0; i<arr.length; i++){
            newPos = i-rotations;
            if (newPos >=0) {
                temp = arr[newPos-1];
                arr[newPos]=arr[i];
                arr[i]=temp;
            } else {
                int newPos1  = arr.length + newPos;
                temp         = arr[newPos1-1];
                arr[newPos1] = arr[i];
                arr[i]       = temp;
            }
        }
        return arr;
    }
    
}
