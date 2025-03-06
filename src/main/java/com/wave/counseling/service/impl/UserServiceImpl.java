package com.wave.counseling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wave.counseling.mapper.IUserService;
import com.wave.counseling.model.User;
import com.wave.counseling.service.UserService;
import com.wave.counseling.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    IUserService service;
    @Override
    public boolean register(User user) {
//        user.setSecret(MD5Util.md5Encrypt(user.getSecret()));
        return service.save(user);
    }

    @Override
    public User login(User user) {
//        user.setSecret(MD5Util.md5Encrypt(user.getSecret()));
        // 构造查询条件
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getName, user.getName())
                .eq(User::getSecret, user.getSecret());

        // 执行查询，返回符合条件的单条记录
        return service.getOne(queryWrapper);

    }

    @Override
    public List<User> findAll() {
        return service.lambdaQuery()
                .select(User::getId, User::getName, User::getRole, User::getEmail,
                        User::getNickname, User::getGmtCreated, User::getGmtModified)
                .list();
    }

}
