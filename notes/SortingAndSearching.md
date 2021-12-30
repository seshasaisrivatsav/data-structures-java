## Sorting And Searching

| # | Problem | Description| Source | 
| :------------ |:---------------| :-----| :-----|
| 1 | [MergeTwoSortedArraysInPlace](../src/main/java/sortingAndSearching/MergeTwoSortedArraysInPlace.java) | Given 2 sorted arrays one with extra space, merge in the first | CTCI/Leetcode |
| 2 | [MedianOfSortedArrays](../src/main/java/sortingAndSearching/MedianOfSortedArrays.java) | Find Median of Sorted arrays | Source |
| 3 | [MergeSort](../src/main/java/sortingAndSearching/MergeSort.java) | Merge Sort | CTCI |
| 4 | [BinarySearch](../src/main/java/sortingAndSearching/BinarySearch.java) | BinarySearch | CTCI |
| 5 | [RadixSort](../src/main/java/sortingAndSearching/RadixSort.java) | Radix Sort | CTCI |
| 6 | [BubbleSort](../src/main/java/sortingAndSearching/BubbleSort.java) | BubbleSort | CTCI |
| 7 | [InsertionSort](../src/main/java/sortingAndSearching/InsertionSort.java) | InsertionSort | CTCI |
| 8 | [SelectionSort](../src/main/java/sortingAndSearching/SelectionSort.java) | SelectionSort | CTCI|
| 9 | [xxx](../src/main/java/sortingAndSearching/xxx.java) | Desc | Source |
| 10 | [xxx](../src/main/java/sortingAndSearching/xxx.java) | Desc | Source |
| 11 | [xxx](../src/main/java/sortingAndSearching/xxx.java) | Desc | Source |

### Merge Sort
MergeSort(A, p, r):
    if p > r 
        return
    q = (p+r)/2
    mergeSort(A, p, q)
    mergeSort(A, q+1, r)
    merge(A, p, q, r)

### Binary Search
- In binary search we look for an element x in a sorted array
- If x is to left side, we search in left side
- If x is greater, we search right half of array until we find it

### Radix Sort
- Avg: O(nk) n=number of elements, k=number of passes 
- 
- Sorting algorithm for integers (and some other data types)
- Takes advantage of the fact that integers have finite number of bits
- We iterate through each digit of the number, grouping numbers by digit
- if we have array of integers, we sort by first digit so that 0s are grouped togerher
- Next, we sort groupings by net digit 


### Bubble Sort
- O(n2)
- Start at beginning of array , swap first two elements if first is greater
- We go on to next pair

```java
for (int i=0; i<arr.length-1; i++) {
    for (int j=0; j<arr.length-i-1; j++) {
        if (arr[j] > arr[j+1]) {
            int temp = arr[j+1];
            arr[j+1] = arr[j];
            arr[j] = temp;
        }
    }
}
```
 
 ### Selection Sort
 - O(n2)
 - Find the smallest element using linear scan, move to the front
 
 ```java
for (int i=0; i<arr.length-1; i++) {
    int currIndex = i;
    for (int j=i+1; j<arr.length; j++) {
        // Find the minimum in arr[i+1.. n]
        if (arr[j] < arr[currIndex]) {
            currIndex = j;
        }
        // swap the element
        int temp = arr[currIndex];
        arr[currIndex] = arr[i];
        arr[i] = temp;
    }
}
```