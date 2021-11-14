package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class URLifyTest {

    @Test
    public void test_URLify_happy() {
        char[] input = "ping pong   ".toCharArray();
        Assert.assertEquals(URLify.urlify(input, 9), "ping%20pong");

        char[] inputTwo = "ping pong poop      ".toCharArray();
        Assert.assertEquals(URLify.urlify(inputTwo, 14), "ping%20pong%20poop");

        char[] inputThree = "hum do hamare do         ".toCharArray();
        Assert.assertEquals(URLify.urlify(inputThree, 16), "hum%20do%20hamare%20do");

        char[] inputFour = "a bc def ghi         ".toCharArray();
        Assert.assertEquals(URLify.urlify(inputFour, 12), "a%20bc%20def%20ghi");
    }
}
