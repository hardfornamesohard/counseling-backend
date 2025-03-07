package com.wave.counseling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wave.counseling.mapper.IUserService;
import com.wave.counseling.model.User;
import com.wave.counseling.service.UserService;
import com.wave.counseling.utils.MD5Util;
import com.wave.counseling.web.Result;
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

    @Override
    public Result<String> changePassword(User user) {
        final boolean update = service.lambdaUpdate()
                .set(User::getSecret, user.getSecret())
                .eq(User::getId, user.getId()).update();
        if (update){
            return Result.buildSuccess("密码修改成功！");
        }
        return Result.buildFail( "用户不存在", 400);
    }

    @Override
    public Result<String> changeOther(User user) {
        final boolean update = service.lambdaUpdate()
                .set(User::getEmail, user.getEmail())
                .set(User::getNickname, user.getNickname())
                .eq(User::getId, user.getId()).update();
        if (update){
            return Result.buildSuccess("用户信息修改成功！");
        }
        return Result.buildFail( "用户不存在", 400);
    }

}
