package com.wave.counseling.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 使用 MD5 加密算法对字符串进行加密
     *
     * @param input 明文字符串
     * @return 加密后的密文（32位）
     */
    public static String md5Encrypt(String input) {
        try {
            // 创建 MD5 加密对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 执行加密操作
            byte[] digest = md.digest(input.getBytes());

            // 转换为 16 进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                // 将每个 byte 转换为 2 位的十六进制数
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

            // 返回 32 位 MD5 密文
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 加密算法不存在", e);
        }
    }

}

