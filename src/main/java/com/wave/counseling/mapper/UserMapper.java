package com.wave.counseling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wave.counseling.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
