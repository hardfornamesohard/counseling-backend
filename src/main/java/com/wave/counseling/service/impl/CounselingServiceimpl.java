package com.wave.counseling.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wave.counseling.mapper.ICounselingBookService;
import com.wave.counseling.model.CounselingBook;
import com.wave.counseling.service.CounselingService;
import com.wave.counseling.web.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ziwei.huang
 * @date 2025/3/28 17:05
 */
@Service
public class CounselingServiceimpl implements CounselingService {

    @Resource
    ICounselingBookService bookService;

    @Override
    public Result<String> book(CounselingBook book) {
        try {

            bookService.save(book);
            System.out.println("save");
        }catch (Exception e){
            Result.buildFail("内部服务器错误:" + e.getMessage(), 501);
        }
        return Result.buildSuccess("预约成功！");
    }

    @Override
    public Result<String> getMyCounselings(int id) {
        final List<CounselingBook> books = bookService.list(Wrappers.<CounselingBook>query().eq("puid", id));

        return Result.buildSuccess(books);
    }
}
