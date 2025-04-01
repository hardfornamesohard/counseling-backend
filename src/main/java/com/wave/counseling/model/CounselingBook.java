package com.wave.counseling.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("counseling_book")
public class CounselingBook {

    @TableId(type = IdType.AUTO)
    private Integer id; // 预约ID，主键，自增

    @TableField
    private Byte status; // 预约状态（0=待处理，1=已确认，2=已取消）


    @TableField("gmtCreated") private LocalDateTime gmtCreated; // 预约操作时间，默认当前时间



    @TableField("counselDate") private LocalDateTime counselDate; // 预约时间


    @TableField private Integer suid; // 预约学生ID


    @TableField private Integer puid; // 被预约咨询师ID


    @TableField private String topic; // 咨询主题，可为空


    @TableField private String description; // 问题简述，可为空

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }



    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public Integer getPuid() {
        return puid;
    }

    public void setPuid(Integer puid) {
        this.puid = puid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCounselDate() {
        return counselDate;
    }

    public void setCounselDate(LocalDateTime counselDate) {
        this.counselDate = counselDate;
    }

    public void setCounselDate(long counselDate) {
        System.out.println(counselDate);
        final Instant instant = Instant.ofEpochMilli(counselDate);

        this.counselDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    @Override
    public String toString() {
        return "CounselingBook{" +
                "id=" + id +
                ", status=" + status +
                ", gmtCreated=" + gmtCreated +
                ", counselDate=" + counselDate +
                ", suid=" + suid +
                ", puid=" + puid +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}