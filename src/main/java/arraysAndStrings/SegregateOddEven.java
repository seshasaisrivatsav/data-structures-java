package arraysAndStrings;

import java.util.Arrays;

public class SegregateOddEven {
	
	
	public static void main (String[] args) {
        int[] arr = {13,10,21,20, 22, 23, 24, 25, 26};
 
        segregateEvenOdd(arr);
        System.out.print("Array after segregation ");
		System.out.println(Arrays.toString(arr));
    }
	
	 static int[] segregateEvenOdd(int arr[]) {
		 int count = 0 ;
	        /* Initialize left and right indexes */
	        int left = 0, right = arr.length - 1;
	        while (left < right){
	            /* Increment left index while we see 0 at left */
	            while (arr[left]%2 == 0 && left < right)
	                left++;
	 
	            /* Decrement right index while we see 1 at right */
	            while (arr[right]%2 == 1 && left < right)
	                right--;
	 
	            if (left < right) {
	                /* Swap arr[left] and arr[right]*/
	                int temp = arr[left];
	                arr[left] = arr[right];
	                arr[right] = temp;
	                left++;
	                right--;
	                count++;
	            }
	        }
	        
	        System.out.println("Number of Swaps "+ count);

	        return arr;
	    }
	

}
