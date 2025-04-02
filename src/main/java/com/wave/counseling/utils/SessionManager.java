package com.wave.counseling.utils;

import com.wave.counseling.model.Role;
import com.wave.counseling.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

    public static Set<User> onlineCounselor(){
        return sessions.values().stream().filter(user-> user.getRole().equals(Role.Counselor)).collect(Collectors.toSet());
    }
}
