package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringAndSentenceTest {

    @Test
    public void test_reverseSentence() {
        String actual = ReverseStringAndSentence.reverseSentence_stringBuilder("crazy fox jumps into a well");
        Assert.assertEquals("well a into jumps fox crazy", actual);

        Assert.assertEquals("reverse", ReverseStringAndSentence.reverseSentence_stringBuilder("reverse"));
    }

    @Test
    public void test_reverseString() {
        Assert.assertEquals("esrever", ReverseStringAndSentence.reverseString_stringBuilder_removeSpace("reverse"));
        Assert.assertEquals("catdog", ReverseStringAndSentence.reverseString_stringBuilder_removeSpace("g o d t a c"));
    }
}
