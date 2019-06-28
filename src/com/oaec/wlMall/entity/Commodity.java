package com.oaec.wlMall.entity;

public class Commodity {
    private int commId;
    private String commName;
    private double price;
    private int inventory;//库存
    private int sales;//销量
    private int tId;//种类编号
    private int bId;//品牌编号
    private String pAddress;//图片地址
    private int isDele;
    public int getCommId() {
        return commId;
    }
    public void setCommId(int commId) {
        this.commId = commId;
    }
    public String getCommName() {
        return commName;
    }
    public void setCommName(String commName) {
        this.commName = commName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    public int getSales() {
        return sales;
    }
    public void setSales(int sales) {
        this.sales = sales;
    }
    public int gettId() {
        return tId;
    }
    public void settId(int tId) {
        this.tId = tId;
    }
    public int getbId() {
        return bId;
    }
    public void setbId(int bId) {
        this.bId = bId;
    }
    public String getpAddress() {
        return pAddress;
    }
    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }
    public int getIsDele() {
        return isDele;
    }
    public void setIsDele(int isDele) {
        this.isDele = isDele;
    }
    public Commodity(int commId, String commName, double price, int inventory, int sales, int tId, int bId, String pAddress,
                     int isDele) {
        super();
        this.commId = commId;
        this.commName = commName;
        this.price = price;
        this.inventory = inventory;
        this.sales = sales;
        this.tId = tId;
        this.bId = bId;
        this.pAddress = pAddress;
        this.isDele = isDele;
    }
    public Commodity() {
        super();
    }
    @Override
    public String toString() {
        return "Commodity [commId=" + commId + ", commName=" + commName + ", price=" + price + ", inventory=" + inventory
                + ", sales=" + sales + ", tId=" + tId + ", bId=" + bId + ", pAddress=" + pAddress + ", isDele=" + isDele
                + "]";
    }

}


