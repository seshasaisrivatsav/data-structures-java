package sortingAndSearching;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};

		System.out.println("median using merge: " + getMedianBruteForce(nums1, nums2));
		int[] nums3 = {1, 3, 8, 9, 15};
		int[] nums4 = {7, 11, 18, 19, 21, 25 };
		System.out.println("median using log: " + getMedianOLogMN(nums3, nums4));
    }

    /*

    	Explanation Video: https://youtu.be/LPFhl65R7ww

    	if
    	x = x1, x2, x3, x4, x5, x6
    	y = y1, y2, y3, y4, y5, y6, y6, y7, y8

    	Split each array into two halves such that sum of both halves is equal 8+6 = 14/ 7
    	x = x1, x2              |   x3, x4, x5, x6
    	y = y1, y2, y3, y4, y5  |   y6, y7, y8
    	 	------  7 -----	      ------  7 -----

    	If every element on left < every element on right
    	We already know x2 < x3	and y5 < y6
    		and if : x2 <= y6 AND  (maxLeftX <= MinRightY)
    				y5 <= x3		(maxLeftY <= minRightX)
		Once such a partition is found, we know median is around those 4 elements.
			= avg(Max(x2,y5) , Min(x3, y6)) => For total even elements
		if the combined elements are odd, we have one extra element on left
			= max(x2, y5)	 => For odd elements

		To find partition
			- Do a binary search on smaller of two arrays and find a point such that every element on left < every element on right

		Time Complexity: O(log ( min (x, y)) = Where x = number of elements in arr1, y = number of elements in arr2

		Eg 1: even
		x = 1, 3, 5, 9, 10, 11, 16		Sorted = 1,2,3,4,5,6,8,9,10,11,16
		y = 2, 4, 6, 8, 15

		Split
		x = 1, 3, 5 	|  9, 10, 11, 16
		y = 2, 4, 6		|  8, 15
			---6---			---6----
		Median = Avg(max(xi, yj), min(xi+1, yi+1)) = Avg (Max(5, 6), Min(9,8)) = Avg(6, 8) = 7

		Another split that won't work
		x = 1, 3, 5, 9 	|  10, 11, 16
		y = 2, 4		|  6, 8, 15

		Eg 2: odd
		x = 1, 3, 8, 9, 15
		y = 7, 11, 18, 19, 21, 25  Sorted = 1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25 . median = 11

		x = 1, 3, 8, 9	| 15
		y = 7, 11 		| 18, 19, 21, 25
			--- 5 ----		--- 5 ----
		Median = max(xi, yj) = max(9, 11) = 11


		Algorithm:
			partitionX + partitionY = (X+Y+1)/2; // we added 1 to account for even number

			Found:
				maxLeftX <= minRightY
				maxLeftY <= minRight X
			Else if
				maxLeftX > minRightY
				move towards left in X
			Else if
				move towards right in Y

		index	  	 0   1   2   3   4   5
		Elements  	 1   3   8   9   15
				 	 7   11  18	 19  21  25
		partition  0   1   2   3   4    5    6


		start = 0
		end = 4
		partitionX = (start + end)/2
		partitionY = (X+y+1)/2 - partitionX = (5 + 6+ 1)/2 - 2 = 4

		partitioning x around 2		1 3      	|  8 9 15
		partitioning y around 4		7 11 18 19 	|  21 25
				we check for if 	3 <= 21  => T
									19 <= 8  => F

		move binary search to right in X
			start = partitionX + 1 = 3
		partitioning x around 		1 3  8    	|  9 15
		partitioning y around 		7 11 18  	|  19, 21 25
			Here						8 <=19 and     => T
										18 <= 9 		=> F

		moving right
		partitioning x around 		1 3  8  9  	|  15
		partitioning y around 		7 11 	  	|  18, 19, 21 25
						9 <= 18  T
						11 <=15  T
					Median = max (9, 11) = 11
     */

	public static double getMedianOLogMN(int[] nums1, int[] nums2) {
		// passing smaller array first, larger next
		if (nums1.length > nums2.length) {
			return getMedianOLogMN(nums2, nums1);
		}
		int nums1Length = nums1.length; // smaller length
		int nums2Length = nums2.length; // larger length

		int low = 0;
		int high = nums2Length;
		while (low <= high) {
			int partitionX = (low+high)/2;
			int partitionY = (nums1Length+nums2Length+1)/2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
			int minRightX = (partitionX == nums1Length) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
			int minRightY = (partitionX == nums2Length) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((nums1Length + nums2Length) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				// We're too on right side of partition X, go to left
				high = partitionX - 1;
			} else {
				// we're roo far on left side for partition X, go on right side
				low = partitionX + 1;
			}

		}
		throw new IllegalArgumentException("arrays not sorted");
	}

	/**
	 * TC : O(M+N)
	 * SC: O(M+N)
	 * 	Approach:
	 * 		1. merge sorted list
	 * 		2. if even, return mid
	 * 		   if odd, return avg of mid, mid-1
	 * @param nums1 int[]
	 * @param nums2 int[]
	 * @return median
	 */
	public static double getMedianBruteForce(int[] nums1, int[] nums2) {
		double res;
		int[] mergedList = mergeSortedLists(nums1, nums2);
		if (mergedList.length % 2 == 0) {
			res = (double) (mergedList[(mergedList.length) / 2] + mergedList[(mergedList.length - 1) / 2]) / 2;

		} else {
			res = mergedList[(mergedList.length) / 2];
		}
		return res;
	}
    public static int[] mergeSortedLists(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length + nums2.length];
        // i = Iterator for A1
        // j = Iterator for A2
        // k = For res
        int i = 0, j = 0, k = 0;

        // Traverse both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                k++;
                i++;
            } else {
                res[k] = nums2[j];
                k++;
                j++;
            }
        }
        // Store remaining elements of first array A1
        while (i < nums1.length) {
            res[k] = nums1[i];
            k++;
            i++;
        }
        // Store remaining elements of first array A2
        while (j < nums2.length) {
            res[k] = nums2[j];
            k++;
            j++;
        }
        return res;
    }

}
