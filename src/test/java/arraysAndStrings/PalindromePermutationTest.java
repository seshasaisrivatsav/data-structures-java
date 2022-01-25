package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePermutationTest {

    @Test
    public void test_palindrome () {
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("taco cat"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("my gym"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("red rum, sir, is murder"));
        Assert.assertTrue(PalindromePermutation.checkPalindrome_string_ignoreSpecialCharsOof1("red rum, sir, is murder"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("top spot"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("no lemon, no melon"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("never odd or even"));
    }

//    @Test // TODO: fix the test
    public void test_palindromeFailure() {
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("tacod cat"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("my gymsasdasd"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("red rum, sasdir, is murder"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("top spotm"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("no lemon, no melons"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("never odd or evensz"));
    }

    @Test
    public void test_palindrome_iterate() {
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("abba"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("123321"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("a"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("ab"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("abcdeffedcba"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_iterate("abcdeffedcbaa"));

        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("taco cat"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("my gym"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("top spot"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("no lemon, no melon"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_iterate("never odd or even"));
    }
}
