| Problem  | URL| Description|
| :------------ |:---------------| :-----|
| isUnique | [IsUniqueString](../src/main/java/arraysAndStrings/IsUniqueString.java)  | check if string is unique without using DS |
| twoSum | [TwoSum](../src/main/java/arraysAndStrings/TwoSum.java)  | determine if sum of two elements in array matches up to a target |
| checkPermutation | [CheckPermutation](../src/main/java/arraysAndStrings/CheckPermutation.java) | Return true if two strings are permutations of one other |
| urlify | [URLify](../src/main/java/arraysAndStrings/URLify.java) | In place replacement of spaces with %20 |
| palindromePermutation | [PalindromePermutation](../src/main/java/arraysAndStrings/PalindromePermutation.java)  | Given a string determine if it's a palindrome |
| OneAway | [OneAway](../src/main/java/arraysAndStrings/OneAway.java) | Detect if two strings are 1 edit away from one another |
| StringCompression | [StringCompression](../src/main/java/arraysAndStrings/StringCompression.java) | Given a string, compress it to return a string with char and occurence count |
| xxx | [xxx](../src/main/java/arraysAndStrings/xxx.java) | Desc |
| xxx | [xxx](../src/main/java/arraysAndStrings/xxx.java) | Desc |
| xxx | [xxx](../src/main/java/arraysAndStrings/xxx.java) | Desc |
| xxx | [xxx](../src/main/java/arraysAndStrings/xxx.java) | Desc |


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