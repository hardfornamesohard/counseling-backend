package com.wave.counseling.web;

import com.wave.counseling.model.User;
import com.wave.counseling.service.UserService;
import com.wave.counseling.utils.SessionManager;
import com.wave.counseling.utils.SessionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
    @Resource
    private UserService userService;
    @PostMapping("/auth")
    public Result login(@RequestBody User user, HttpServletRequest request,
                        HttpServletResponse response) {

        user = userService.login(user);
        if (user == null) {
            return Result.buildFail("用户名或密码错误");
        }

        String sessionId = SessionUtil.generateSessionId();


        response.setHeader("Session", sessionId);
        response.setHeader("x-nickname", user.getNickname());
        SessionManager.addSession(sessionId, user);
        return Result.buildSuccess("登录成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        try {
            userService.register(user);
        }catch (Exception e){
            //唯一索引冲突或者user字段不全
            return Result.buildFail(e.getMessage(), 500);
        }

        return Result.buildSuccess("注册成功");
    }
    @GetMapping("/logout")
    public Result logout(@RequestParam("session") String sessionId,
                         HttpServletResponse response){
        boolean res = SessionManager.remove(sessionId);
        if (res) {
            return Result.buildSuccess("退出登录成功");
        }else{
            return Result.buildSuccess("用户未登录！");
        }
    }
}
