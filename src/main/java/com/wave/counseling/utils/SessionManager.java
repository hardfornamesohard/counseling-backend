package com.wave.counseling.utils;

import com.wave.counseling.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ziwei.huang
 * @date 2025/2/28 17:47
 */
public class SessionManager {
    private final static Map<String, User> sessions = new ConcurrentHashMap<>();
    public static void addSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }
    public static boolean remove(String sessionId) {
        return sessions.remove(sessionId) != null;
    }
    public static User find(String sessionId) {
        return sessions.get(sessionId);
    }
}
