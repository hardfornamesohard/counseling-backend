package com.wave.counseling.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wave.counseling.model.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author ziwei.huang
 * @date 2025/3/4 17:39
 */
@Component
public class IUserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> {
}
