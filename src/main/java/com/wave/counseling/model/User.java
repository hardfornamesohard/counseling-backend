package com.wave.counseling.model;

/**
 * @author ziwei.huang
 * @date 2025/2/28 15:40
 */



import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

@TableName("counseling_user") // 表示映射到数据库中的 user 表
public class User {

    @TableId(type = IdType.AUTO) // 自动生成 ID
    private int id;

    @TableField("name") // 映射数据库中的 name 字段
    private String name;

    @TableField("secret") // 映射数据库中的 secret 字段
    private String secret;

    @TableField("role") // 映射数据库中的 role 字段
    private Role role;

    @TableField("email") // 映射数据库中的 email 字段
    private String email;

    @TableField("nickname") // 映射数据库中的 nickname 字段
    private String nickname;

    @TableField(value = "gmtCreated", fill = FieldFill.INSERT) // 自动填充插入时的时间
    private Timestamp gmtCreated;

    @TableField(value = "gmtModified", fill = FieldFill.INSERT_UPDATE) // 自动填充更新时间
    private Timestamp gmtModified;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getRole() {
        return role.getVal();
    }

    public void setRole(int val) {
        this.role = Role.values()[val];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Timestamp getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Timestamp gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secret='" + secret + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
 enum Role {
    Student(0, "学生"),
    Counselor(1, "咨询师"),
    Admin(2, "管理员");

    private final int val;    // 用来存储角色的值
    private final String role; // 用来存储角色的描述

    // 构造函数，接收整数值和描述字符串
    Role(int val, String role) {
        this.val = val;
        this.role = role;
    }


    // 获取角色值
    public int getVal() {
        return val;
    }

    // 获取角色描述
    public String getRole() {
        return role;
    }

    // 根据值获取对应的角色
    public static Role fromValue(int val) {
        for (Role role : Role.values()) {
            if (role.getVal() == val) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + val);
    }
}

