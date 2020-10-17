package indi.axikuazei.pigletter.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author axikuazei
 * @date 2020/10/17 上午11:16
 */
public class MDUtils {

    public static String Sha256(String password){
        String md="";
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            sha.update(password.getBytes());
            md = byteToString(sha.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md;
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
