package com.wave.counseling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wave.counseling.mapper.IUserInfoService;
import com.wave.counseling.model.User;
import com.wave.counseling.model.UserInfo;
import com.wave.counseling.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ziwei.huang
 * @date 2025/3/4 17:42
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private IUserInfoService userInfoService;
    @Override
    public UserInfo findByUser(User user) {
        if (user == null || user.getId() == 0) {
            return null;
        }
        return userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUid, user.getId()));
    }

    @Override
    public boolean saveOrUpdate(UserInfo userInfo) {
        if (userInfo == null || userInfo.getUid() == null) {
            return false;
        }
        // 检查是否存在对应的 UserInfo
        UserInfo existing = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUid, userInfo.getUid()));

        if (existing != null) {
            // 更新
            return userInfoService.update(userInfo, new LambdaUpdateWrapper<UserInfo>()
                    .eq(UserInfo::getUid, userInfo.getUid()));
        } else {
            // 新增
            return userInfoService.save(userInfo);
        }
    }
}
