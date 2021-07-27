package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;


public class CheckPermutationTest {

    @Test
    public void test_isPermutation_optimal_basic() {
        boolean actual = CheckPermutation.isPermutation_optimal("abc", "cab");
        Assert.assertTrue(actual);
    }

    @Test
    public void test_isPermutation_optimal_fails() {
        boolean actual = CheckPermutation.isPermutation_optimal("abc", "caa");
        Assert.assertFalse(actual);
    }

    @Test
    public void test_isPermutation_mixed() {
        String str1 = "1234567890qwertyuiop";
        String str2 = "poiutyrewq0987564321";
        boolean actual = CheckPermutation.isPermutation_optimal(str1, str2);
        Assert.assertTrue(actual);
    }
}
