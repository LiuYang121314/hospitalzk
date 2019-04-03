package com.litbo.hospitalzj.supplier.entity;

public class QyLx {
    private Integer qyLxid;

    private String qyLxcm;

    private String qyLxCode;

    public Integer getQyLxid() {
        return qyLxid;
    }

    public void setQyLxid(Integer qyLxid) {
        this.qyLxid = qyLxid;
    }

    public String getQyLxcm() {
        return qyLxcm;
    }

    public void setQyLxcm(String qyLxcm) {
        this.qyLxcm = qyLxcm == null ? null : qyLxcm.trim();
    }

    public String getQyLxCode() {
        return qyLxCode;
    }

    public void setQyLxCode(String qyLxCode) {
        this.qyLxCode = qyLxCode == null ? null : qyLxCode.trim();
    }
}