package com.wave.counseling.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Objects;

@TableName("counseling_userinfo")
public class UserInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;  // 个人信息ID，主键，自增

    private String avatar;  // 用户头像路径，可为空

    private Integer gender;  // 性别，0=男，1=女，2=其他，默认值为 0

    private Integer age;  // 年龄，可为空

    private String hobby;  // 爱好，可为空

    private String signature;  // 个性签名，可为空

    @TableField("uid")
    private Integer uid;  // 用户ID，关联用户表，非空

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(gender, userInfo.gender) && Objects.equals(age, userInfo.age) && Objects.equals(uid, userInfo.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age, uid);
    }
}

