package com.wave.counseling.service;

import com.wave.counseling.model.User;
import com.wave.counseling.model.UserInfo;

/**
 * @author ziwei.huang
 * @date 2025/3/4 17:41
 */
public interface UserInfoService {
    UserInfo findByUser(User user);
    boolean saveOrUpdate(UserInfo userInfo);
}
