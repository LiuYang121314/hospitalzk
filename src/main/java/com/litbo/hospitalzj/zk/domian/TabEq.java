package com.litbo.hospitalzj.zk.domian;

public class TabEq {
    private Integer id;

    private Integer eqId;

    private Integer jcyqId;

    private String tableName;

    private  Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(Integer jcyqId) {
        this.jcyqId = jcyqId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

}