package com.vixuan.model;

public class UserInfo {
    private String uMobile;

    private String entCode;

    private String uPwd;

    private String uName;

    private Integer uType;

    private Integer uSort;

    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile == null ? null : uMobile.trim();
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }

    public Integer getuSort() {
        return uSort;
    }

    public void setuSort(Integer uSort) {
        this.uSort = uSort;
    }
}