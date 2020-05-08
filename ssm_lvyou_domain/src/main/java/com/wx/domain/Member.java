package com.wx.domain;

import com.wx.utils.DateUtils;

import java.util.Date;
import java.util.List;

//会员
public class Member {
    /*
       id VARCHAR(32) PRIMARY KEY,
       NAME VARCHAR(20),
       nickname VARCHAR(20),
       phoneNum VARCHAR(20),
       email VARCHAR(20)
     */
    private String id ;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
    private Date createTime;
    private String createTimeStr;
    private List<Traveller> travellers;

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if (createTime != null){
            return DateUtils.date2String(createTime,"yyyy-MM-dd hh:mm");
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
