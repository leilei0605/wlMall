package com.oaec.wlMall.entity;

import java.util.Date;

public class Address {
    private int addId;
    private String Recipient;//收件人
    private String reNumber;
    private String address;
    private int userId;
    private int isDefault;
    private Date addTime;
    public int getAddId() {
        return addId;
    }
    public void setAddId(int addId) {
        this.addId = addId;
    }
    public String getRecipient() {
        return Recipient;
    }
    public void setRecipient(String recipient) {
        Recipient = recipient;
    }
    public String getReNumber() {
        return reNumber;
    }
    public void setReNumber(String reNumber) {
        this.reNumber = reNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getIsDefault() {
        return isDefault;
    }
    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
    public Date getAddTime() {
        return addTime;
    }
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    public Address(int addId, String recipient, String reNumber, String address, int userId, int isDefault,
                   Date addTime) {
        super();
        this.addId = addId;
        Recipient = recipient;
        this.reNumber = reNumber;
        this.address = address;
        this.userId = userId;
        this.isDefault = isDefault;
        this.addTime = addTime;
    }
    public Address() {
        super();
    }
    @Override
    public String toString() {
        return "Address [addId=" + addId + ", Recipient=" + Recipient + ", reNumber=" + reNumber + ", address="
                + address + ", userId=" + userId + ", isDefault=" + isDefault + ", addTime=" + addTime + "]";
    }
}
