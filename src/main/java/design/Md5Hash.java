package design;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Example class to Hash using MD5 and Encode the result using base 64
 */
public class Md5Hash {

    public static void main(String[] args) {
        String hash = "828D96436ED603559ADDE81CADF29EA4";
        String pwd = "https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904/";

        try {

            // STEP 1: Hashing using MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pwd.getBytes());
            byte[] digest = md5.digest();
            String myHashMd5 = DatatypeConverter.
                    printHexBinary(digest);

            System.out.println(myHashMd5);

            // STEP 2: Encoding using base64
            String myHashmd5Encoded = Base64.getEncoder()
                    .encodeToString(digest);
            System.out.println(myHashmd5Encoded.length());
            System.out.println(Base64.getEncoder().encodeToString(myHashMd5.getBytes()).length());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
