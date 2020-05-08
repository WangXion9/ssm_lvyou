package com.wx.domain;

import com.wx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//游记实体类
public class Diary {
    /*
    `id` varchar(32) NOT NULL COMMENT 'id',
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `productId` varchar(32) DEFAULT NULL COMMENT '产品id（来源）',
  `collect` int(11) DEFAULT NULL COMMENT '收藏数',
  `likeCount` int(11) DEFAULT NULL COMMENT '点赞数',
  `texts` text COMMENT '正文',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员id（作者）',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `diaryStatus` int(11) DEFAULT NULL COMMENT '处理状态（0未处理1已处理）',
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `showStatus` int(11) DEFAULT NULL COMMENT '显示状态（0未处理1已处理）',
  PRIMARY KEY (`id`)
     */
    private String id;
    private String title;
    private Product product;
    private Integer collect;
    private Integer likeCount;
    private String texts;
    private Member member;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    private String createTimeStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    private String updateTimeStr;

    private Integer diaryStatus;
    private String diaryStatusStr;
    private Integer showStatus;
    private String showStatusStr;

    private List<Comment> comments;//评论list


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if (createTime != null){
            return DateUtils.date2String(createTime,"yyyy-MM-dd HH:mm");
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        if (updateTime != null){
            return  DateUtils.date2String(updateTime,"yyyy-MM-dd HH:mm");
        }
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Integer getDiaryStatus() {
        return diaryStatus;
    }

    public void setDiaryStatus(Integer diaryStatus) {
        this.diaryStatus = diaryStatus;
    }

    public String getDiaryStatusStr() {
        if (diaryStatus == 0){
            return "未处理";
        }
        if (diaryStatus == 1)
            return "已处理";
        return diaryStatusStr;
    }

    public void setDiaryStatusStr(String diaryStatusStr) {
        this.diaryStatusStr = diaryStatusStr;
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
}
