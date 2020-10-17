package indi.axikuazei.pigletter.utils;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author axikuazei
 * @date 2020/10/17 上午11:31
 */
public class MDUtilsTest {
    @Test
    public void sha1Test(){
        try {
            String salt1 = UUID.randomUUID().toString();
            String salt2 = UUID.randomUUID().toString();
            String salt3 = UUID.randomUUID().toString();
            String p1 = MDUtils.sha256("m123456", salt1);
            String p2 = MDUtils.sha256("m123456", salt2);
            String p3 = MDUtils.sha256("m123456", salt3);
            System.out.println("salt1: "+salt1);
            System.out.println("p1: "+p1);
            System.out.println("salt2: "+salt2);
            System.out.println("p2: "+p2);
            System.out.println("salt3: "+salt3);
            System.out.println("p3: "+p3);
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
