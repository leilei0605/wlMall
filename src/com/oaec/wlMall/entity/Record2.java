package com.oaec.wlMall.entity;

import java.util.Date;

public class Record2 {
    private Integer recordId;
    private Integer userId;
    private String username;// 用户名
    private Integer comId;//货物编号
    private String cName;// 货物名
    private Double pay;//货物花费
    private String address;
    private String comment;
    private Date buyTime;//购买时间
    private Date returnTime;//退货日期
    public Integer getRecordId() {
        return recordId;
    }
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getComId() {
        return comId;
    }
    public void setComId(Integer comId) {
        this.comId = comId;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public Double getPay() {
        return pay;
    }
    public void setPay(Double pay) {
        this.pay = pay;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getBuyTime() {
        return buyTime;
    }
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }
    public Date getReturnTime() {
        return returnTime;
    }
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
    public Record2(Integer recordId, Integer userId, String username, Integer comId, String cName, Double pay,
                   String address, String comment, Date buyTime, Date returnTime) {
        super();
        this.recordId = recordId;
        this.userId = userId;
        this.username = username;
        this.comId = comId;
        this.cName = cName;
        this.pay = pay;
        this.address = address;
        this.comment = comment;
        this.buyTime = buyTime;
        this.returnTime = returnTime;
    }
    public Record2() {
        super();
    }
    @Override
    public String toString() {
        return "Record2 [recordId=" + recordId + ", userId=" + userId + ", username=" + username + ", comId=" + comId
                + ", cName=" + cName + ", pay=" + pay + ", address=" + address + ", comment=" + comment + ", buyTime="
                + buyTime + ", returnTime=" + returnTime + "]";
    }

}
