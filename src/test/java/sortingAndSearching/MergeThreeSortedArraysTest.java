package sortingAndSearching;

import org.junit.Assert;
import org.junit.Test;


public class MergeThreeSortedArraysTest {
    @Test
    public void test_mergeThreeArrays_oneElementOnly() {
        int[] arr4 = {1};
        int[] arr5 = {2};
        int[] arr6 = {3};
        int[] res2 = {1,2,3};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_equalSizes() {
        int[] arr1 = { 1, 4, 9, 13, 16 };
        int[] arr2 = { 2, 5, 10, 15, 19 };
        int[] arr3 = { 3, 6, 11, 14, 20 };
        int[] res1 = {1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16, 19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr1, arr2, arr3), res1);
    }

    @Test
    public void test_mergeThreeArrays_unequalSizes() {
        int[] arr4 = { 1};
        int[] arr5 = { 2, 5, 19 };
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = {1, 2, 3,  5, 6,  11,  14,  19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_oneEmpty() {
        int[] arr4 = {};
        int[] arr5 = { 2, 5, 19 };
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = {2, 3,  5, 6,  11,  14,  19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_twoEmpty() {
        int[] arr4 = {};
        int[] arr5 = {};
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = { 3,  6,  11,  14,   20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_allEmpty() {
        int[] arr4 = {};
        int[] arr5 = {};
        int[] arr6 = {};
        int[] res2 = {};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_threePointers(arr4, arr5, arr6), res2);
    }



    @Test
    public void test_mergeThreeArrays_oneElementOnly_mergeTwoAtTime() {
        int[] arr4 = {1};
        int[] arr5 = {2};
        int[] arr6 = {3};
        int[] res2 = {1,2,3};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_equalSizes_mergeTwoAtTime() {
        int[] arr1 = { 1, 4, 9, 13, 16 };
        int[] arr2 = { 2, 5, 10, 15, 19 };
        int[] arr3 = { 3, 6, 11, 14, 20 };
        int[] res1 = {1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 14, 15, 16, 19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr1, arr2, arr3), res1);
    }

    @Test
    public void test_mergeThreeArrays_unequalSizes_mergeTwoAtTime() {
        int[] arr4 = { 1};
        int[] arr5 = { 2, 5, 19 };
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = {1, 2, 3,  5, 6,  11,  14,  19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_oneEmpty_mergeTwoAtTime() {
        int[] arr4 = {};
        int[] arr5 = { 2, 5, 19 };
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = {2, 3,  5, 6,  11,  14,  19, 20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_twoEmpty_mergeTwoAtTime() {
        int[] arr4 = {};
        int[] arr5 = {};
        int[] arr6 = { 3, 6, 11, 14, 20 };
        int[] res2 = { 3,  6,  11,  14,   20};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6), res2);
    }

    @Test
    public void test_mergeThreeArrays_allEmpty_mergeTwoAtTime() {
        int[] arr4 = {};
        int[] arr5 = {};
        int[] arr6 = {};
        int[] res2 = {};
        Assert.assertArrayEquals(MergeThreeSortedArrays.mergeThreeSortedArrays_twoAtATime(arr4, arr5, arr6), res2);
    }
}
