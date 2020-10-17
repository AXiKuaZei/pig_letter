package indi.axikuazei.pigletter.utils;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author axikuazei
 * @date 2020/10/17 上午11:31
 */
public class MDUtilsTest {
    @Test
    public void sha1Test(){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            sha.update("hello world".getBytes());
            System.out.println("jdk sha256:"+ byteToString(sha.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }
}
