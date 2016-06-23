package org.thehellnet.utility.gaming.pb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sardylan on 09/06/16.
 */
public final class Hash {

    public static String md5(String input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return byteToHex(messageDigest.digest(input.getBytes()));
    }

    public static String guid(String input, long seed) {
        PBMD5 pbmd5 = new PBMD5();
        pbmd5.init(seed);
        pbmd5.update(input);
        return byteToHex(pbmd5.finish());
    }

    private static String byteToHex(byte[] hash) {
        StringBuilder buf = new StringBuilder(hash.length * 2);
        for (byte aHash : hash) {
            if (((int) aHash & 0xff) < 0x10)
                buf.append("0");
            buf.append(Long.toString((int) aHash & 0xff, 16));
        }
        return buf.toString();
    }
}
