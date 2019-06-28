package com.oaec.wlMall.entity;

public class Achievement {
    private String aname;
    private int loAchi;
    private int hiAchi;
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    public int getLoAchi() {
        return loAchi;
    }
    public void setLoAchi(int loAchi) {
        this.loAchi = loAchi;
    }
    public int getHiAchi() {
        return hiAchi;
    }
    public void setHiAchi(int hiAchi) {
        this.hiAchi = hiAchi;
    }
    public Achievement(String aname, int loAchi, int hiAchi) {
        super();
        this.aname = aname;
        this.loAchi = loAchi;
        this.hiAchi = hiAchi;
    }
    public Achievement() {
        super();
    }
    @Override
    public String toString() {
        return "Achievement [aname=" + aname + ", loAchi=" + loAchi + ", hiAchi=" + hiAchi + "]";
    }

}
