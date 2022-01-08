package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayUnion {
    public static void main(String[] args) {
        int[] arr1 = {1, 2,3 ,4, 5};
        int[] arr2 = {1, 2,4, 5, 6, 8};
        System.out.println(Arrays.toString(unionArray(arr1, arr2)));
    }

    public static Integer[] unionArray(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int arr: arr1) {
            set.add(arr);
        }
        for (int arr: arr2) {
            set.add(arr);
        }
        Integer[] res = new Integer[set.size()]; // IMP: Hashset returns Object not primitive
        set.toArray(res);
        return res;
    }
}
