package com.wave.counseling.web;

import com.wave.counseling.model.CounselingBook;
import com.wave.counseling.service.CounselingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController("/counseling")
public class CounselingController {

    @Resource
    CounselingService counselingService;

    @PostMapping("/book")
    public Result<String> book(@RequestBody CounselingBook book){
        return counselingService.book(book);
    }
}
