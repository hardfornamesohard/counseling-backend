package com.wave.counseling.web;

import com.wave.counseling.model.User;
import com.wave.counseling.model.UserInfo;
import com.wave.counseling.service.UserInfoService;
import com.wave.counseling.utils.SessionManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 根据用户信息查询 UserInfo
     */
    @GetMapping("/find")
    public Result<UserInfo> findByUser(@RequestParam String session) {
        if (session == null) {
            return Result.buildFail("请先登录", 400);
        }
        User user = SessionManager.find(session);
        if (user == null) {
            return Result.buildFail("用户信息不存在", 404);
        }
        return Result.buildSuccess(userInfoService.findByUser(user));
    }

    /**
     * 新增或更新 UserInfo
     */
    @PostMapping("/saveOrUpdate")
    public Result<Boolean> saveOrUpdate(@RequestParam("gender") Integer gender,
                                @RequestParam("age")Integer age,
                                @RequestParam("hobby") String hobby,
                                @RequestParam("signature") String signature,
                                @RequestParam("avatar") MultipartFile  avatar,
                                @RequestParam("session") String session) {

        final UserInfo userInfo = new UserInfo();
        userInfo.setUid(SessionManager.find(session).getId());
        userInfo.setAge(age);
        userInfo.setGender(gender);
        userInfo.setHobby(hobby);
        userInfo.setSignature(signature);
        if (avatar != null && !avatar.isEmpty()) {
            try {
                // 生成唯一文件名，保留原文件扩展名
                String originalFilename = avatar.getOriginalFilename();
                String fileExtension = StringUtils.getFilenameExtension(originalFilename);
                String newFileName = UUID.randomUUID() + "." + fileExtension;

                // 目标保存路径
                String uploadDir = System.getProperty("user.dir") + "/images/avatar";
                File saveFile = new File(Paths.get(uploadDir, newFileName).toString());

                // 确保目录存在
                saveFile.getParentFile().mkdirs();

                saveFile.createNewFile();
                // 保存文件
                avatar.transferTo(saveFile);

                // 设置 avatar 字段为文件名
                userInfo.setAvatar(newFileName);

            } catch (IOException e) {
                e.printStackTrace();
                return Result.buildFail("头像上传失败", 500, e);
            }
        }
        return userInfoService.saveOrUpdate(userInfo) == true?
                Result.buildSuccess(true) : Result.buildFail("保存失败", 500);
    }

    /***
     * 返回系统中所有的咨询师信息
     *
     */
    @GetMapping("/counselors")

    public Result<HashMap<UserInfo, Boolean>> counselors(){
        return userInfoService.findAllCounselors();
    }
}

