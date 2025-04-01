package com.wave.counseling.web;

import com.wave.counseling.model.CounselingBook;
import com.wave.counseling.model.Role;
import com.wave.counseling.model.User;
import com.wave.counseling.service.CounselingService;
import com.wave.counseling.utils.SessionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/counseling")
public class CounselingController {

    @Resource
    CounselingService counselingService;

    @PostMapping("/book")
    public Result<String> book(@RequestBody CounselingBook book){
        book.setStatus((byte)0);
        return counselingService.book(book);
    }
    @GetMapping("/my-counseling")
    public Result<String> myCounseling(HttpServletRequest request){
        final String session = request.getHeader("Session");
        final User user = SessionManager.find(session);
        if (!user.getRole().equals(Role.Counselor)){
            return Result.buildFail("你不是咨询师，没有权限！", 401);
        }
        return counselingService.getMyCounselings(user.getId());
    }
}
