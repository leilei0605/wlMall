package com.oaec.wlMall.entity;

import java.util.Date;

public class Type {
    //种类
    private int tId;
    private String tName;
    private int isDele;
    private Date addTime;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getIsDele() {
        return isDele;
    }

    public void setIsDele(int isDele) {
        this.isDele = isDele;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Type(int tId, String tName, int isDele, Date addTime) {
        super();
        this.tId = tId;
        this.tName = tName;
        this.isDele = isDele;
        this.addTime = addTime;
    }

    public Type() {
        super();
    }
    @Override
    public String toString() {
        return "Type [tId=" + tId + ", tName=" + tName + ", isDele=" + isDele + ", addTime=" + addTime + "]";
    }

}
