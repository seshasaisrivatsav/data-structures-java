package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {

    @Test
    public void test_isRotation() {
        Assert.assertTrue(StringRotation.isRotation("party", "rtypa"));
        Assert.assertTrue(StringRotation.isRotation("elephant", "phantele"));
        Assert.assertFalse(StringRotation.isRotation("panther", "antherz"));
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void test_isSubstring_success() {
        Assert.assertTrue(StringRotation.isSubstring("abcdef", "bcd"));
        Assert.assertTrue(StringRotation.isSubstring("bcd", "abcdef"));
        Assert.assertTrue(StringRotation.isSubstring("bcd", "bcd"));
    }

    @Test
    public void test_isSubstring_almosttwosubs() {
        Assert.assertTrue(StringRotation.isSubstring("ppabcdefabcz", "abcz"));
    }

    @Test
    public void test_isSubstring_failure() {
        Assert.assertFalse(StringRotation.isSubstring("abcd", "ad"));
        Assert.assertFalse(StringRotation.isSubstring("zzzzzz", "za"));
    }
}
