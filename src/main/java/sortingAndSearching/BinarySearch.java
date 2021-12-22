package sortingAndSearching;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("expected: 0 actual: "  + binarySearchRecursive(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1));
        System.out.println("expected: 8 actual: "  + binarySearchIterative(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, 8));
    }
    /**
     * Given a sorted array arr, find element's index
     * @param arr int[] arr
     * @param element int element
     * @return element found
     */
    public static int binarySearchRecursive(int[] arr, int element) {
        return binarySearch(arr, element, 0, arr.length-1);
    }

    public static int binarySearch(int[] arr, int element, int start, int end) {
        if (start > end) return -1;
        int mid = (start+end)/2;
        if (element < arr[mid]) { return binarySearch(arr, element, start, mid-1); }
        else if (element > arr[mid]) { return binarySearch(arr, element, mid+1, end); }
        else return mid;
    }


    /**
     * Given a sorted array, find element's index
     * @param arr int[]
     * @param element int
     * @return index of element
     */
    public static int binarySearchIterative(int[] arr, int element) {
        int start = 0;
        int end = arr.length-1;
        int mid;

        while (start <= end) {
            mid =  (start + end)/2;
            if (element < arr[mid]) {
                end = mid - 1;
            } else if (element > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; // element not found
    }
}
