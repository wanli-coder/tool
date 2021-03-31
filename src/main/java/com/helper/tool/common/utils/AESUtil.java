package com.helper.tool.common.utils;

import com.helper.tool.common.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class AESUtil {
    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);
    private static String GCM256ALGORITHM = "AES/GCM/PKCS5Padding";

    public static String encode(String content, String key) {
        try {
            if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key)) {
                throw new ApplicationException("AESUtil encode Exception");
            }
            SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(key), "AES");

            Cipher cipher = Cipher.getInstance(GCM256ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] iv = cipher.getIV();
            assert iv.length == 12;
            byte[] encryptData = cipher.doFinal(content.getBytes());
            assert encryptData.length == content.getBytes().length + 16;
            byte[] message = new byte[12 + content.getBytes().length + 16];
            System.arraycopy(iv, 0, message, 0, 12);
            System.arraycopy(encryptData, 0, message, 12, encryptData.length);
            return Base64.encodeBase64String(message);
        } catch (Exception e) {
            logger.error("AESUtil 加密文本处理失败,error:{}", e);
        }
        return null;

    }

    public static String decode(String content, String key) {
        try {
            if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key)) {
                throw new Exception("AESUtil 解密异常,检查文本或密钥");
            }
            Cipher cipher = Cipher.getInstance(GCM256ALGORITHM);
            SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(key), "AES");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] message = Base64.decodeBase64(content);
            if (message.length < 12 + 16) throw new IllegalArgumentException();
            GCMParameterSpec params = new GCMParameterSpec(128, message, 0, 12);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
            byte[] decryptData = cipher.doFinal(message, 12, message.length - 12);
            return new String(decryptData);
        } catch (Exception e) {
            logger.error("AESUtil 解密文本处理失败,error:{}", e);
        }
        return null;
    }

    public static String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        //初始化密钥生成器，AES要求密钥长度为128位、192位、256位
        generator.init(256);
        SecretKey secretKey = generator.generateKey();
        return Base64.encodeBase64String(secretKey.getEncoded());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String key = "ecQfypumxKdO8jVPikCkC2hG3ILGcGeBgaZm8wa2ZXo=";//AESUtil.generateKey();
        String password = "root";
        System.out.println(key);
        // System.out.println(AESUtil.encode(password,key));
        System.out.println(AESUtil.decode("WoDX4Ge+KQWIBwksgl4r3EQtqV5gUcyiS+AyZzCFM2c=", key));

    }
}
