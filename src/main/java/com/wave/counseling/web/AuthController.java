package com.wave.counseling.web;

import com.wave.counseling.utils.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/auth")
    public Result login(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = SessionUtil.generateSessionId();
        response.setHeader("session", sessionId);

        return Result.buildSuccess("登录成功");
    }
}
