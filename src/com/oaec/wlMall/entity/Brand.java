package com.oaec.wlMall.entity;

import java.util.Date;

public class Brand {
    //品牌
    private int bId;
    private String bName;
    private int isDele;
    private Date addTime;
    public int getbId() {
        return bId;
    }
    public void setbId(int bId) {
        this.bId = bId;
    }
    public String getbName() {
        return bName;
    }
    public void setbName(String bName) {
        this.bName = bName;
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
    public Brand(int bId, String bName, int isDele, Date addTime) {
        super();
        this.bId = bId;
        this.bName = bName;
        this.isDele = isDele;
        this.addTime = addTime;
    }
    public Brand() {
        super();}
    @Override
    public String toString() {
        return "Brand [bId=" + bId + ", bName=" + bName + ", isDele=" + isDele + ", addTime=" + addTime + "]";
    }

}
