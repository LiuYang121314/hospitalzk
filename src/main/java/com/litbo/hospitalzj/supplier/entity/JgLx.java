package com.litbo.hospitalzj.supplier.entity;

public class JgLx {
    private Integer jgId;

    private String jgLxmc;

    private String jgLxCode;

    public Integer getJgId() {
        return jgId;
    }

    public void setJgId(Integer jgId) {
        this.jgId = jgId;
    }

    public String getJgLxmc() {
        return jgLxmc;
    }

    public void setJgLxmc(String jgLxmc) {
        this.jgLxmc = jgLxmc == null ? null : jgLxmc.trim();
    }

    public String getJgLxCode() {
        return jgLxCode;
    }

    public void setJgLxCode(String jgLxCode) {
        this.jgLxCode = jgLxCode == null ? null : jgLxCode.trim();
    }
}