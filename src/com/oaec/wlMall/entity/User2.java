package com.oaec.wlMall.entity;

public class User2 {
    private int userId;
    private String userName;
    private String passWord;
    private String payword;
    private String userPhoneNumber;
    private double balance=500;
    private boolean admin;
    private int isvip;
    private int achi;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getPayword() {
        return payword;
    }
    public void setPayword(String payword) {
        this.payword = payword;
    }
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public int getIsvip() {
        return isvip;
    }
    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }
    public int getAchi() {
        return achi;
    }
    public void setAchi(int achi) {
        this.achi = achi;
    }
    public User2(int userId, String userName, String passWord, String payword, String userPhoneNumber, double balance,
                 boolean admin, int isvip, int achi) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.payword = payword;
        this.userPhoneNumber = userPhoneNumber;
        this.balance = balance;
        this.admin = admin;
        this.isvip = isvip;
        this.achi = achi;
    }
    public User2() {
        super();
    }
}
