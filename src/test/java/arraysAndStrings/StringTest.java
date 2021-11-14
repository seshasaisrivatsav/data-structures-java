package arraysAndStrings;

import org.junit.Test;

public class StringTest {

    @Test
    public void test_StringBuilderBuffer() {

        String s1 = "Geeks";
        s1 = s1 + "forgeeks";
        System.out.println("String: " + s1);


        String source = "source";

        String str = "asdb" + source;

        StringBuilder stringBuilder = new StringBuilder("asdb");
        stringBuilder.append(source);

        StringBuffer stringBuffer = new StringBuffer("asdb");
        stringBuffer.append(source);

        System.out.println(str);
        System.out.println(stringBuilder);
        System.out.println(stringBuffer);

    }
}
