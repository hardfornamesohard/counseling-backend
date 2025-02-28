package com.wave.counseling.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wave.counseling.model.User;
import org.springframework.stereotype.Component;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:49
 */

@Component
public class IUserService extends ServiceImpl<UserMapper, User> implements IService<User> {
    // 你可以在这里添加自定义的业务逻辑方法
}