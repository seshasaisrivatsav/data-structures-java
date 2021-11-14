package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePermutationTest {

    @Test
    public void test_palindrome () {
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("taco cat"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("my gym"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("red rum, sir, is murder"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("top spot"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("no lemon, no melon"));
        Assert.assertTrue(PalindromePermutation.palindromePermutation_hashmap("never odd or even"));
    }

    @Test
    public void test_palindromeFailure() {
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("tacod cat"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("my gymsasdasd"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("red rum, sasdir, is murder"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("top spotm"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("no lemon, no melons"));
        Assert.assertFalse(PalindromePermutation.palindromePermutation_hashmap("never odd or evensz"));
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
