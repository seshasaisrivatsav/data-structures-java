package general;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

// https://howtodoinjava.com/java/java-security/aes-256-encryption-decryption/
public class AES256EncryptionDecryption {
    public static class AES256Encryption {
        private static final String SECRET_KEY = "aaa";
        private static final String SALT = "salt";

        public String encrypt(String strToEncrypt) {
            try {
                byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                IvParameterSpec ivspec = new IvParameterSpec(iv);

                SecretKeyFactory factory = SecretKeyFactory.getInstance("a");
                KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
                SecretKey tmp = factory.generateSecret(spec);
                SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
                return Base64.getEncoder()
                        .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
            } catch (Exception e) {
                System.out.println("Error while encrypting: " + e.toString());
            }
            return null;
        }
    }
    public static class AES256Decrption {
        private static final String SECRET_KEY = "aaa";
        private static final String SALT = "ssshhhhhhhhhhh!!!!";

        public String decrypt(String strToDecrypt) {
            try {
                byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                IvParameterSpec ivspec = new IvParameterSpec(iv);

                SecretKeyFactory factory = SecretKeyFactory.getInstance("a");
                KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
                SecretKey tmp = factory.generateSecret(spec);
                SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
                return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            } catch (Exception e) {
                System.out.println("Error while decrypting: " + e.toString());
            }
            return null;
        }
    }


    public static void main(String[] args) {
        String secretStringToEncrypt = "This movie is great. don't tell anyone";

        String encrypted = new AES256Encryption().encrypt(secretStringToEncrypt);
        String decrypted = new AES256Decrption().decrypt(encrypted);

        System.out.println("original string = " + secretStringToEncrypt);
        System.out.println("encrypted = " + encrypted);
        System.out.println("decrypted = " + decrypted);
    }
}
