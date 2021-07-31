package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {
    @Test
    public void test_stringCompression_happy() {
        Assert.assertEquals(StringCompression.compressString("aabbccdd"), "a2b2c2d2");
        Assert.assertEquals(StringCompression.compressString("aaabbbcd"), "a3b3c1d1");
    }

    @Test
    public void test_stringCompression_sad() {
        Assert.assertEquals("hhjkkkklop", StringCompression.compressString("hhjkkkklop"));
        Assert.assertEquals("abcd", StringCompression.compressString("abcd"));
    }
}
