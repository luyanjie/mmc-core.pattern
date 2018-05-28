package com.maochong.xiaojun.commons;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;

/**
 * @author jokin
 * @date 2018/5/28 18:01
 */
public class CryptoUtils {
    private static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final String DEFAULT_DES_ALGORITHM_ECB = "DES/ECB/PKCS5Padding";
    private static final String DEFAULT_DES_ALGORITHM_CBC = "DES/CBC/PKCS5Padding";

    /**
     * Des加解密
     * */
    public static  class  Des{
        /**
         * 生成key的算法
         * */
        private static final String DEFAULT_KEY_ALGORITHM = "DES";
        /**
         * 已知密钥的情况下加密
         * @param str 需要加密字符串
         * @param pKey 密钥
         * */
        public static String encode(String str, String pKey) throws Exception{
            byte[] data = str.getBytes(DEFAULT_CHARSET_NAME);
            byte[] encryptedData = encode(data,pKey.getBytes(DEFAULT_CHARSET_NAME),null);
            return bytesToHexFun(encryptedData);
        }

        /**
         * 已知密钥的情况下加密(有iKey)
         * @param str 需要加密字符串
         * @param pKey 密钥
         * @param iKey 初始化向量
         * @return decode
         * */
        public static String encode(String str, String pKey,String iKey) throws Exception{
            byte[] data = str.getBytes(DEFAULT_CHARSET_NAME);
            if("".equals(iKey) || iKey.length()!=8)
                return str;
            byte[] encryptedData = encode(data,pKey.getBytes(DEFAULT_CHARSET_NAME),iKey.getBytes(DEFAULT_CHARSET_NAME));
            return bytesToHexFun(encryptedData);
        }

        /**
         * 已知密钥的情况下解密
         * @param str 需要解密字符串16进制
         * @param pKey key
         * @return decode
         * @throws Exception Exception
         */
        public static String decode(String str, String pKey) throws Exception {
            byte[] bytes = hexToBytesToFun(str);
            if(bytes == null){
                return "";
            }
            byte[] decryptedData = decode(bytes,pKey.getBytes(),null);
            return new String(decryptedData, DEFAULT_CHARSET_NAME);
        }

        /**
         * 已知密钥的情况下解密(有iKey)
         * @param str 需要解密字符串
         * @param pKey key
         * @param iKey 初始化向量
         * @return decode
         * @throws Exception Exception
         */
        public static String decode(String str, String pKey,String iKey) throws Exception {
            byte[] bytes = hexToBytesToFun(str);
            if(bytes == null){
                return "";
            }
            if("".equals(iKey) || iKey.length() !=8) {
                return str;
            }
            byte[] decryptedData = decode(bytes,pKey.getBytes(),iKey.getBytes());
            return new String(decryptedData, DEFAULT_CHARSET_NAME);
        }

        /**
         * 数据加密
         * @param str 待加密数据
         * @param pKey 密钥
         * @param iKey 初始化向量
         * */
        public static byte[] encode(byte[] str, byte[] pKey,byte[] iKey) throws Exception{
            Cipher cipher;
            if(iKey == null || iKey.length == 0){
                //无向量使用ECB
                cipher = Cipher.getInstance(DEFAULT_DES_ALGORITHM_ECB);
                cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(pKey));
            }else {
                IvParameterSpec iv = new IvParameterSpec(iKey);
                //有向量使用CBC
                cipher = Cipher.getInstance(DEFAULT_DES_ALGORITHM_CBC);
                cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(pKey), iv);
            }
            return cipher.doFinal(str);
        }

        /**
         * 数据解密
         * @param str 待加密数据
         * @param pKey 密钥
         * @param iKey 初始化向量
         * */
        public static byte[] decode(byte[] str,byte[] pKey, byte[] iKey) throws Exception {
            Cipher cipher;
            if (iKey == null || iKey.length == 0) {
                //无向量使用ECB
                cipher = Cipher.getInstance(DEFAULT_DES_ALGORITHM_ECB);
                cipher.init(Cipher.DECRYPT_MODE, getSecretKey(pKey));
            } else {
                IvParameterSpec iv = new IvParameterSpec(iKey);
                //有向量使用CBC
                cipher = Cipher.getInstance(DEFAULT_DES_ALGORITHM_CBC);
                cipher.init(Cipher.DECRYPT_MODE, getSecretKey(pKey), iv);
            }
            return cipher.doFinal(str);
        }

        /**
         * 创建工厂
         * */
        private static SecretKey getSecretKey(byte[] key) throws Exception {
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DEFAULT_KEY_ALGORITHM);
            return keyFactory.generateSecret(dks);
        }

        /**
         * byte[] 转16进制
         * */
        private static String bytesToHexFun(byte[] encryptedData){
            StringBuilder buf = new StringBuilder(encryptedData.length * 2);
            for(byte b : encryptedData) {
                // 使用String的format方法进行转换
                buf.append(String.format("%02x", b & 0xff));
            }
            return buf.toString();
        }

        private static byte[] hexToBytesToFun(String str){
            if(str == null || "".equals(str.trim())) {
                return null;
            }
            byte[] bytes = new byte[str.length() / 2];
            for(int i = 0; i < str.length() / 2; i++) {
                String subStr = str.substring(i * 2, i * 2 + 2);
                bytes[i] = (byte) Integer.parseInt(subStr, 16);
            }
            return bytes;
        }
    }

    /**
     * MD5单项加密
     * */
    public static class MD5{
        /**
         * 获取MD5
         * */
        public static String getMD5(String str) throws Exception {
            MessageDigest md5;
            try{
                md5 = MessageDigest.getInstance("MD5");
            }catch (Exception e){
                System.out.println(e.toString());
                e.printStackTrace();
                return "";
            }
            char[] charArray = str.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuilder hexValue = new StringBuilder();
            for (byte md5Byte : md5Bytes) {
                int val = ((int) md5Byte) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        }
    }

    /**
     * SHA单项加密
     * */
    public static class SHA {
        private static final String KEY_SHA = "SHA";
        public static String getSHA(String str)
        {
            BigInteger sha = null;
            byte[] inputData = str.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
                messageDigest.update(inputData);
                sha = new BigInteger(messageDigest.digest());
            } catch (Exception e) {e.printStackTrace();}
            return sha != null? sha.toString(32):"";
        }
    }

    /**
     * Base64加解密（应该算是一种编码）
     * */
    public static class BASE64{
        /**
         * BASE64 加密
         * @param key
         * @return
         * @throws Exception
         */
        public static String encode(String key) throws Exception {
            return new String(Base64.getEncoder().encode(key.getBytes()));
        }

        public static String decode(String key) throws Exception{
            return new String(Base64.getDecoder().decode(key));
        }
    }
}
