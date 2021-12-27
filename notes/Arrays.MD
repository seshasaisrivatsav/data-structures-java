| Problem  | URL | Description | Source |
| :------------ |:---------------| :-----| :-----|
| isUnique | [IsUniqueString](../src/main/java/arraysAndStrings/IsUniqueString.java)  | check if string is unique without using DS |
| checkPermutation | [CheckPermutation](../src/main/java/arraysAndStrings/CheckPermutation.java) | Return true if two strings are permutations of one other |
| urlify | [URLify](../src/main/java/arraysAndStrings/URLify.java) | In place replacement of spaces with %20 |
| palindromePermutation | [PalindromePermutation](../src/main/java/arraysAndStrings/PalindromePermutation.java)  | Given a string determine if it's a palindrome | CTCI |
| CheckPalindromeNumberNoSpace | [CheckPalindromeNumberNoSpace](../src/main/java/arraysAndStrings/CheckPalindromeNumberNoSpace.java)  | Check if a number is palindrome without using extra space | Leetcode |
| OneAway | [OneAway](../src/main/java/arraysAndStrings/OneAway.java) | Detect if two strings are 1 edit away from one another |
| StringCompression | [StringCompression](../src/main/java/arraysAndStrings/StringCompression.java) | Given a string, compress it to return a string with char and occurence count |
| RotateMatrix | [RotateMatrix](../src/main/java/arraysAndStrings/RotateMatrix.java) | Given a 2D matrix clockwise and anticlockwise IN-PLACE |
| ZeroMatrix | [ZeroMatrix](../src/main/java/arraysAndStrings/ZeroMatrix.java) | If an element of matrix is  zero, make the row and column zero|
| StringRotation | [StringRotation](../src/main/java/arraysAndStrings/StringRotation.java) | Given two strings check if one is a rotation of another |
| ReverseStringAndSentence | [ReverseStringAndSentence](../src/main/java/arraysAndStrings/ReverseStringAndSentence.java) | Reverse a string. Reverse a sentence |
| twoSum | [TwoSum](../src/main/java/arraysAndStrings/TwoSum.java)  | determine if sum of two elements in array matches up to a target |
| longestSubstringWithoutRepeatingChars | [longestSubstringWithoutRepeatingChars](../src/main/java/arraysAndStrings/LongestSubstringWithoutRepeatingChars.java)  | sliding window - longestSubstringWithoutRepeatingChars |
| MaxSumContiguousArray | [MaxSumContiguousArray](../src/main/java/arraysAndStrings/MaxSumContiguousArray.java) | sliding window - max contiguous sum | Leetcode |
| MaxSubarray | [MaxSubarray](../src/main/java/arraysAndStrings/MaxSubarray.java) | largest sum - kadane's algo | Leetcode |
| CustomSortArrayEvenOdd | [CustomSortArrayEvenOdd](../src/main/java/arraysAndStrings/CustomSortArrayEvenOdd.java) | given an array sort it into even half and odd half|
| CheckAnagram | [CheckAnagram](../src/main/java/arraysAndStrings/CheckAnagram.java) | check if given two strings are anagrams|
| LeftRotateArray | [LeftRotateArray](../src/main/java/arraysAndStrings/LeftRotateArray.java) | LeftRotateArray|
| MinimumAbsoluteDifference | [MinimumAbsoluteDifference](../src/main/java/arraysAndStrings/MinimumAbsoluteDifference.java) | Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.|
| LongestCommonPrefix | [LongestCommonPrefix](../src/main/java/arraysAndStrings/LongestCommonPrefix.java) | Return longest common prefix string if an array of strings is given | LeetCode | 
| RomanToInt | [RomanToInt](../src/main/java/arraysAndStrings/RomanToInt.java) | Given a Roman Number, convert it to Int | Leetcode |
| ValidParentheses | [ValidParentheses](../src/main/java/arraysAndStrings/ValidParentheses.java) | Given string representing brackets, return if it's valid | Leetcode |
| RemoveDuplicatesSortedArray | [RemoveDuplicatesSortedArray](../src/main/java/arraysAndStrings/RemoveDuplicatesSortedArray.java) | Remove duplicates from sorted array (use for loop and another variable) | Leetcode |
| IndexOfStr | [IndexOfStr](../src/main/java/arraysAndStrings/IndexOfStr.java) | Return first index of occurrence, -1 not found, 0 if empty | Leetcode |
| BestTimeToBuyStock | [BestTimeToBuyStock](../src/main/java/arraysAndStrings/BestTimeToBuyStock.java) | Given array, find max profit | Leetcode |
| HappyNumber | [HappyNumber](../src/main/java/arraysAndStrings/HappyNumber.java) | Determine if happy number | leetcode |
| SingleNumber | [SingleNumber](../src/main/java/arraysAndStrings/SingleNumber.java) | Find the number that occurs only once in an array | Leetcode |
| MissingRanges | [MissingRanges](../src/main/java/arraysAndStrings/MissingRanges.java) | Return missing ranges in given sorted array | Leetcode |
| MajorityElement | [MajorityElement](../src/main/java/arraysAndStrings/MajorityElement.java) | Return element in array which appears more than half times | Leetcode |
| FirstUniqueCharacterInString | [FirstUniqueCharacterInString](../src/main/java/arraysAndStrings/FirstUniqueCharacterInString.java) | In a string first non repeating character | Leetcode 
| xx | [xx](../src/main/java/arraysAndStrings/xx.java) | xx | Leetcode 
| xx | [xx](../src/main/java/arraysAndStrings/xx.java) | xx | Leetcode 
| xx | [xx](../src/main/java/arraysAndStrings/xx.java) | xx | Leetcode |
| xx | [xx](../src/main/java/arraysAndStrings/xx.java) | xx | xx |
| xx | [xx](../src/main/java/arraysAndStrings/xx.java) | xx | xx |



## Notes


### Iterating a hashmap
- For keys and values  (.entrySet => entry.getKey, entry.getValue)
```java
    Map<String, Integer> itemMap = new HashMap<>();
    itemMap.forEach((key, value) => {
        System.out.println(key + " " + value);
    })
```

- Using entrySet (for )
IMP: Make sure you write `.entrySet` other wise we won't get iterator
```java
for (Map.Entry<String, Integer> entry: itemMap.entrySet()) {
     System.out.println(entry.getKey() + " " + entry.getValue);
}
```

- For keys (.keyset)
```java
for (String key: hashMap.keySet()) {
      System.out.println(entry.getKey() + " " + key);
}
```

- For values
```java

for (Integer value: hashMap.values()) {
    sysout(entry.getKey() + " " + value);
}

```
## Sliding window
### [MaxSumContiguousArray](../src/main/java/arraysAndStrings/MaxSumContiguousArray.java)
### [LongestSubstringWithoutRepeatingChars](../src/main/java/arraysAndStrings/LongestSubstringWithoutRepeatingChars.java)
More sliding window problems - https://www.geeksforgeeks.org/tag/sliding-window/

```java
[a b c d e f g h]
```

Sliding window of size 3
```java
[a b c]
  [b c d]
    [c d e]
      [d e f]
        [e f g]
          [f g h]
```

- eg 1: find number of elements needed to give a largest sum of 5 consecutive elements
- Given array
```java
[ 5, 7, 1, 4, 3, 6, 2, 9, 2 ]

```
- Possible sliding windows
- Here rather than computing all possibilities, we slide our window
- To proceed one step ahead, we delete the first most element and add the new element
- imagine a window of length N, and sliding pane of length K, while we move 1 increment forward, we compute the elements in 
   each pane accordingly.
```java
[5, 7, 1, 4, 3] = 20
[ 7, 1, 4, 3, 6] = 21
[1, 4, 3, 6, 2]=16
[4, 3, 6, 2, 9]=24
[ 3, 6, 2, 9, 2]=22
```
## Notes
- For rotating an array (transpose + vertical flip)
![image](https://user-images.githubusercontent.com/19309898/127751865-418eff9f-0a88-4527-89bd-9bdfc5ad4e51.png)