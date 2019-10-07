package com.wowo.ffms.utils;



import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Usage:
 *
 * <pre>
 * String crypto = AESUtil.encrypt(passwd, cleartext)
 * ...
 * String cleartext = AESUtil.decrypt(passwd, crypto)
 * </pre>
 *
 * @author mrsimple
 */
public class AESUtil {
    /**
     * @Title: encrypt
     * @Description: AES加密
     * @param passwd 加密的密钥
     * @param originStr 需要加密的字符串
     * @return 返回已加密的字符串
     * @throws Exception
     * @throws
     */
    public static String encrypt(String passwd, String originStr) throws Exception {
        byte[] rawKey = getRawKey(passwd.getBytes());
        byte[] result = encrypt(rawKey, originStr.getBytes());
        return toHex(result);
    }

    /**
     * @Title: decrypt
     * @Description: AES解密
     * @param passwd 加密的密钥
     * @param encrypted 已加密的密文
     * @return String 返回解密后的数据
     * @throws Exception
     * @throws
     */
    public static String decrypt(String passwd, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(passwd.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result);
    }

    /**
     * @Title: getRawKey
     * @Description: 将密钥转换成字节数组
     * @param passwd 密钥字符串
     * @return byte[] 字节数组
     * @throws Exception
     * @throws
     */
    private static byte[] getRawKey(byte[] passwd) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(passwd);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return raw;
    }

    /**
     * @Title: encrypt
     * @Description: 加密字节数组
     * @param raw 密钥字节数组
     * @param originStr 明文字节数组
     * @return byte[] 加密后的字节数组
     * @throws Exception
     * @throws
     */
    private static byte[] encrypt(byte[] raw, byte[] originStr) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(originStr);
        return encrypted;
    }

    /**
     * @Title: decrypt
     * @Description: 解密字节数组
     * @param passwd 密钥字节数组
     * @param encrypted 密文字节数组
     * @return byte[] 解密的字节数组
     * @throws Exception
     * @throws
     */
    private static byte[] decrypt(byte[] passwd, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(passwd, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    /**
     * @Title: toHex
     * @Description:将字符串转换成十六进制字符串
     * @param txt
     * @return
     * @throws
     */
    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    /**
     * @Title: fromHex
     * @Description:
     *      将十六进制字符串转换成普通字符串
     *
     * @param hex
     * @return
     * @throws
     */
    public static String fromHex(String hex) {
        return new String(toByte(hex));
    }

    /**
     * @Title: toByte
     * @Description:
     *      将字符串转换成字节数组
     *
     * @param hexString
     * @return
     * @throws
     */
    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        return result;
    }

    /**
     * @Title: toHex
     * @Description:
     * @param buf
     * @return
     * @throws
     */
    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private final static String HEX = "0123456789ABCDEF";
    /**
     * @Title: appendHex
     * @Description:
     *
     *
     * @param sb
     * @param b
     * @throws
     */
    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }

}
