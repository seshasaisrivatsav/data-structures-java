| Problem  | URL| Description|
| :------------ |:---------------| :-----|
| isUnique | [IsUniqueString](../src/main/java/arraysAndStrings/IsUniqueString.java)  | check if string is unique without using DS |
| checkPermutation | [CheckPermutation](../src/main/java/arraysAndStrings/CheckPermutation.java) | Return true if two strings are permutations of one other |
| urlify | [URLify](../src/main/java/arraysAndStrings/URLify.java) | In place replacement of spaces with %20 |
| palindromePermutation | [PalindromePermutation](../src/main/java/arraysAndStrings/PalindromePermutation.java)  | Given a string determine if it's a palindrome |
| OneAway | [OneAway](../src/main/java/arraysAndStrings/OneAway.java) | Detect if two strings are 1 edit away from one another |
| StringCompression | [StringCompression](../src/main/java/arraysAndStrings/StringCompression.java) | Given a string, compress it to return a string with char and occurence count |
| RotateMatrix | [RotateMatrix](../src/main/java/arraysAndStrings/RotateMatrix.java) | Given a 2D matrix clockwise and anticlockwise IN-PLACE |
| ZeroMatrix | [xxx](../src/main/java/arraysAndStrings/ZeroMatrix.java) | If an element of matrix is  zero, make the row and column zero|
| StringRotation | [StringRotation](../src/main/java/arraysAndStrings/StringRotation.java) | Given two strings check if one is a rotation of another |
| ReverseStringAndSentence | [ReverseStringAndSentence](../src/main/java/arraysAndStrings/ReverseStringAndSentence.java) | Reverse a string. Reverse a sentence |
| twoSum | [TwoSum](../src/main/java/arraysAndStrings/TwoSum.java)  | determine if sum of two elements in array matches up to a target |
| longestSubstringWithoutRepeatingChars | [longestSubstringWithoutRepeatingChars](../src/main/java/arraysAndStrings/LongestSubstringWithoutRepeatingChars.java)  | sliding window - longestSubstringWithoutRepeatingChars |
| MaxSumContiguousArray | [MaxSumContiguousArray](../src/main/java/arraysAndStrings/MaxSumContiguousArray.java) | sliding window - max contiguous sum |

## Notes

### Iterating a hashmap
- For keys and values  (.entrySet => entry.getKey, entry.getValue)
```java
for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
    sysout(entry.getKey() + " " + entry.getValue);
}
```

- For keys (.keyset)
```java
for (String key: hashMap.keySet()) {
    sysout(entry.getKey() + " " + key);
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