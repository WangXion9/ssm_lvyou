package com.wx.domain;

import com.wx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//评论实体类
public class Comment {
    /*
    `id` varchar(32) NOT NULL COMMENT 'id',
  `writeName` varchar(32) DEFAULT NULL COMMENT '评论者名称',
  `commentDesc` varchar(255) DEFAULT NULL COMMENT '评论正文',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `commentStatus` int(11) DEFAULT NULL COMMENT '处理状态（0未处理1处理）',
  `diaryId` varchar(32) DEFAULT NULL COMMENT '游记id',
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `showStatus` int(11) DEFAULT NULL COMMENT '显示状态（0不显示1显示）',
  PRIMARY KEY (`id`)
     */
    private String id;
    private String writeName;
    private String commentDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    private String updateTimeStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    private String createTimeStr;

    private Integer commentStatus;
    private String commentStatusStr;
    private Integer showStatus;
    private String showStatusStr;

    private Diary diary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWriteName() {
        return writeName;
    }

    public void setWriteName(String writeName) {
        this.writeName = writeName;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        if (updateTime != null)
            return DateUtils.date2String(updateTime,"yyyy-MM-dd HH:mm");
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if (createTime != null)
            return DateUtils.date2String(createTime,"yyyy-MM-dd HH:mm");
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentStatusStr() {
        if (commentStatus == 0)
            return "未处理";
        if (commentStatus == 1)
            return "已处理";
        return commentStatusStr;
    }

    public void setCommentStatusStr(String commentStatusStr) {
        this.commentStatusStr = commentStatusStr;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getShowStatusStr() {
        if (showStatus == 0)
            return "不显示";
        if (showStatus == 1)
            return "显示";
        return showStatusStr;
    }

    public void setShowStatusStr(String showStatusStr) {
        this.showStatusStr = showStatusStr;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }
}
