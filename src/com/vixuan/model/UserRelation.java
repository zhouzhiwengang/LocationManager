package com.vixuan.model;

public class UserRelation {
    private Integer tId;

    private String uMobile;

    private String cUMobile;

    private String cUName;

    private Integer cUSort;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile == null ? null : uMobile.trim();
    }

    public String getcUMobile() {
        return cUMobile;
    }

    public void setcUMobile(String cUMobile) {
        this.cUMobile = cUMobile == null ? null : cUMobile.trim();
    }

    public String getcUName() {
        return cUName;
    }

    public void setcUName(String cUName) {
        this.cUName = cUName == null ? null : cUName.trim();
    }

    public Integer getcUSort() {
        return cUSort;
    }

    public void setcUSort(Integer cUSort) {
        this.cUSort = cUSort;
    }
}