package com.wx.domain;

import com.wx.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//产品
public class Product {

    private String id;                      //主键
    private String productNum;              //编号 唯一
    private String productName;             //名称
//    private String cityName;                //出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date DepartureTime;             //出发时间
    private String DepartureTimeStr;
    private Double productPrice;            //产品价格
    private String productDesc;             //产品描述
    private Integer productStatus;          //状态 0 关闭  1 开启
    private String productStatusStr;

    private City startCity;                  //起始地
    private City endCity;                       //目的地

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (DepartureTime != null){
            return DateUtils.date2String(DepartureTime, "yyyy-MM-dd HH:mm");
        }
        return DepartureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        DepartureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null){
            if (productStatus == 1){
                productStatusStr = "开启";
            }
            if (productStatus == 0){
                productStatusStr = "关闭";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }



}
