package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class OneAwayTest {
    @Test
    public void test_oneAway() {
        Assert.assertTrue(OneAway.oneAway("abcd", "abcd"));
        Assert.assertTrue(OneAway.oneAway("abcd", "abce"));
        Assert.assertFalse(OneAway.oneAway("abcd", "abee"));
        Assert.assertFalse(OneAway.oneAway("abcd", "abeeee"));
    }

    @Test
    public void test_oneAwayCharDiff() {
        Assert.assertTrue(OneAway.oneAway("pab", "pabe"));
        Assert.assertTrue(OneAway.oneAway("pab", "apab"));
    }

    @Test
    public void test_officialTests() {
        Assert.assertTrue(OneAway.oneAway("pale", "ple"));
        Assert.assertTrue(OneAway.oneAway("pales", "pale"));
        Assert.assertTrue(OneAway.oneAway("pale", "bale"));
        Assert.assertFalse(OneAway.oneAway("pale", "bae"));
    }
}
