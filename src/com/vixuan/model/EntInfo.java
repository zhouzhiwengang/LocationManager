package com.vixuan.model;

public class EntInfo {
    private String entCode;

    private String entName;

    private Integer entState;

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public Integer getEntState() {
        return entState;
    }

    public void setEntState(Integer entState) {
        this.entState = entState;
    }
}