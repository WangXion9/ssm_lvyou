package com.wx.domain;

import com.wx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//订单
public class Orders {
    /*
      id VARCHAR(32) PRIMARY KEY,
      orderNum VARCHAR(20) NOT NULL UNIQUE,
      orderTime TIMESTAMP,
      peopleCount INT,
      orderDesc VARCHAR(500),
      payType INT,
      orderStatus INT,
      productId VARCHAR(32),
      memberId VARCHAR(32),
      FOREIGN KEY (productId) REFERENCES product(id),
      FOREIGN KEY (memberId) REFERENCES member(id)
     */
    private String id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    private String updateTimeStr;
    private int peopleCount;
    private String orderDesc;
    private Integer payType;
    private String payTypeStr;
    private Integer payStatus;
    private String payStatusStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Product product;
    private List<Traveller> travellers;
    private Member member;

    private Integer overStatus;
    private String overStatusStr;

    public Integer getOverStatus() {
        return overStatus;
    }

    public void setOverStatus(Integer overStatus) {
        this.overStatus = overStatus;
    }

    /**
     * 结束状态（0进行中1待出团2交易成功3退款）
     * @return
     */
    public String getOverStatusStr() {
        if (overStatus != null){
            if (overStatus == 0){
                return "待出团";
            }
            if (overStatus == 1){
                return "以出团";
            }
            if (overStatus == 2){
                return "交易成功";
            }
            if (overStatus == 3){
                return "退款";
            }
        }
        return overStatusStr;
    }

    public void setOverStatusStr(String overStatusStr) {
        this.overStatusStr = overStatusStr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        if (updateTime != null){
            return DateUtils.date2String(updateTime, "yyyy-MM-dd HH:mm");
        }
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusStr() {
        if (payStatus != null){
            if (payStatus == 0){
                return "未支付";
            }
            if (payStatus == 1){
                return "已支付";
            }
        }
        return payStatusStr;
    }

    public void setPayStatusStr(String payStatusStr) {
        this.payStatusStr = payStatusStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus != null){
            if (orderStatus == 0)
                return "未处理";
            if (orderStatus == 1)
                return "已处理";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null){
            return orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType != null){
            if (payType == 0){
                return "支付宝";
            }
            if (payType == 1){
                return "微信";
            }
            if (payType == 2){
                return "其他";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
