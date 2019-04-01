package com.litbo.hospitalzj.quality.entity;

public class EqXeq {
    private Integer id;

    private String eqName;

    private String eqCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName == null ? null : eqName.trim();
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode == null ? null : eqCode.trim();
    }
}