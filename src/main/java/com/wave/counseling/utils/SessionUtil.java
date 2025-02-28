package com.wave.counseling.utils;

/**
 * @author ziwei.huang
 * @date 2025/2/28 14:59
 */
import java.util.UUID;

public class SessionUtil {

    /**
     * 生成一个随机的 session ID
     *
     * @return 返回一个随机的 session ID
     */
    public static String generateSessionId() {
        // 使用 UUID 生成一个随机的 session ID
        return UUID.randomUUID().toString().replace("-", "");
    }
}

