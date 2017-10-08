package arraysAndStrings;

public class MedianOfSortedArrays {

	
	public static void main(String[] args) {
		  double res;
		  
		  
		  	int[] nums1 = {1,2,3,4,5};
		  	int[] nums2 = {6,7,8,9,10};
		  	
	        int[] merge = mergeSortedLists(nums1, nums2);
	        if(merge.length%2 == 0){
	            res = (double) (merge[(merge.length)/2]+ merge[(merge.length-1)/2])/2;
	             
	        }else {
	        	res=merge[(merge.length)/2];
	        }
	        System.out.println(res);
	       
	}
	

    public static int[] mergeSortedLists(int[] A1, int[] A2){
		int res[] = new int[A1.length + A2.length];
		// i = Iterator for A1
		// j = Iterator for A2
		// k = For res
		int i=0, j=0, k=0;
		
		// Traverse both arrays 
		while(i<A1.length && j <A2.length) {
			if(A1[i]<A2[j]) {
				res[k]=A1[i];
				k++;i++;
			}else {
				res[k]=A2[j];
				k++;j++;
			}
		}
		
		
		// Store remaining elements of first array A1 
		while(i<A1.length) {
			res[k]= A1[i];
			k++;i++;
		}
		
		// Store remaining elements of first array A2
		while(j<A2.length) {
			res[k]=A2[j];
			k++;j++;
		}
		
		return res;
	}
    
    
}
