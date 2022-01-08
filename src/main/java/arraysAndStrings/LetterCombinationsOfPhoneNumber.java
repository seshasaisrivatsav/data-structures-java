package arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Compute all menoz
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
    Input: digits = ""
    Output: []

Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]

Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

NOTE:
    2: abc
    3: def
        you can't form ade, aef

Solution. Think of
    1. Choice
    2. Constraints
    3. Goal

1. Choice - choose a letter
2. Constraints - none
3. Goal - digits to possibilities

 */
public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> res =  new ArrayList<>();
        if (digits.length()==0) { return res; }
        HashMap<Integer, String> digitStringMap = new HashMap<>();
        digitStringMap.put(2, "abc");
        digitStringMap.put(3, "def");
        digitStringMap.put(4, "ghi");
        digitStringMap.put(5, "jkl");
        digitStringMap.put(6, "mno");
        digitStringMap.put(7, "pqrs");
        digitStringMap.put(8, "tuv");digitStringMap.put(9, "wxyz");

        return res;

    }

    public static void main(String[] args) {
        String[] res = {"adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"};
        System.out.println(res.length);
    }
}
