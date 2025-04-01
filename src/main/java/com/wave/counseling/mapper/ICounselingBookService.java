package com.wave.counseling.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wave.counseling.model.CounselingBook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ziwei.huang
 * @date 2025/3/28 16:28
 */
@Component
public class ICounselingBookService extends ServiceImpl<CounselingBookMapper, CounselingBook> implements IService<CounselingBook> {
    @Override
    public String toString() {
        return "ICounselingBookService{}";
    }
}
