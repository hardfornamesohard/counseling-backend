package com.wave.counseling.service;

import com.wave.counseling.model.User;
import com.wave.counseling.web.Result;

import java.util.List;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:48
 */
public interface UserService {
    boolean register(User user);
    User login(User user);

    List<User> findAll();

    Result<String> changePassword(User user);

    Result<String> changeOther(User user);
}
