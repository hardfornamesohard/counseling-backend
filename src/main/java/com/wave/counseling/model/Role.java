package com.wave.counseling.model;

public enum Role {
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
