package arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringCompressionArrayTest {
    /*
    

Example 1:
    Input: chars = ['a','a','b','b','c','c','c']
    Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
    Explanation: The groups are 'aa', 'bb', and 'ccc'. This compresses to 'a2b2c3'.

Example 2:
    Input: chars = ['a']
    Output: Return 1, and the first character of the input array should be: ['a']
    Explanation: The only group is 'a', which remains uncompressed since it's a single character.

Example 3:
    Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
    Output: Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
    Explanation: The groups are 'a' and 'bbbbbbbbbbbb'. This compresses to 'ab12'.
     */
    
//    @Test // TODO: fix the test
    public void test_stringCompression() {
        char[] chars1 = {'a','a','b','b','c','c','c'};
        int length = StringCompressionArray.compressChars(chars1);
        System.out.println(Arrays.toString(chars1));
        Assert.assertEquals(chars1, new char[]{'a', '2', 'b', '2', 'c', '3'});


        char[] chars2 = {'a'};
        StringCompressionArray.compressChars(chars2);
        System.out.println(Arrays.toString(chars2));
        Assert.assertEquals(chars2, new char[]{'a'});

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        StringCompressionArray.compressChars(chars3);
        System.out.println(Arrays.toString(chars3));
        Assert.assertEquals(chars3, new char[]{'a','b','1','2'});
    }
}
