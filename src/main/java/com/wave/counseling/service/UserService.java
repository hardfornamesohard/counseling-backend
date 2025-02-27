package com.wave.counseling.service;

import com.wave.counseling.model.User;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:48
 */
public interface UserService {
    boolean register(User user);
    User login(User user);
}
