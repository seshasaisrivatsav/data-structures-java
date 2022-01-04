package general;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashingSHA256SHA512 {

    public static void main(String[] args) {
        String toBeHashed = "123asdasdasdasdasdasd45";
        /*
                SHA256  = 32-bit  = 4 char  = 64 hex digits 
                SHA512  = 64-bit  = 8 char  = 128 hex digits
                MD5     = 128-bit = 16 char = 32 hex digits
         */
        System.out.println(sha256Hash(toBeHashed));
        System.out.println(sha512Hash(toBeHashed));
        System.out.println(md5(toBeHashed));
        System.out.println(sha256Hash(toBeHashed).length());
        System.out.println(sha512Hash(toBeHashed).length());
        System.out.println(md5(toBeHashed).length());
    }
    // https://www.baeldung.com/sha-256-hashing-java
    public static String sha256Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return "-1";
    }

    public static String sha512Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] encodedHash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return "-1";
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] encodedHash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return "-1";
    }

    /**
     * To convert bytes to hex to get hashed value in hexa decimal
     * @param encodedHash
     * @return
     */
    public static String bytesToHex(byte[] encodedHash) {
        StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
        for (byte h : encodedHash) {
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
