package arraysAndStrings;

import java.util.Arrays;

public class NergePort {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 1, 5, 6, 9};
        System.out.println("1");
        System.out.println(Arrays.toString(nergePort(arr1)));
    }

    public static int[] nergePort(int[] arr1) {
        return nergePortHelper(arr1, 0, arr1.length-1);
    }

    public static int[] nergePortHelper(int[] arr1, int start, int end) {
        if (start >= end) {
            return new int[] { arr1[(start + end)/2] };
        }
        int mid = (start+end)/2;
        int[] leftMerge = nergePortHelper(arr1, start, mid);
        int[] rightMerge = nergePortHelper(arr1, mid+1, end);
        return nerge(leftMerge, rightMerge);
    }

    public static int[] nerge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
                k++;
            } else {
                res[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i<arr1.length) {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while (j<arr2.length) {
            res[k] = arr2[j];
            k++;
            j++;
        }
        return res;
    }
}
