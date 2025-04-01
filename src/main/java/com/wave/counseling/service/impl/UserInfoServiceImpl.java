package com.wave.counseling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.wave.counseling.mapper.IUserInfoService;
import com.wave.counseling.mapper.IUserService;
import com.wave.counseling.model.Role;
import com.wave.counseling.model.User;
import com.wave.counseling.model.UserInfo;
import com.wave.counseling.service.UserInfoService;
import com.wave.counseling.web.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ziwei.huang
 * @date 2025/3/4 17:42
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private IUserInfoService userInfoService;

    @Resource
    private IUserService userService;

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

    @Override
    public Result<Set<UserInfo>> findAllCounselors() {

        List<Integer> ids = userService.lambdaQuery()
                .eq(User::getRole, Role.Counselor.getVal()) // 查询条件
                .select(User::getId) // 只查询 ID
                .list()
                .stream()
                .map(User::getId) // 提取 ID 列表
                .collect(Collectors.toList());
        if(ids == null || ids.isEmpty()){
            return Result.buildSuccess("");
        }
        final List<UserInfo> list = userInfoService.lambdaQuery()
                .in(UserInfo::getUid, ids)
                .list();


        return Result.buildSuccess(new HashSet<>(list));
    }
}
