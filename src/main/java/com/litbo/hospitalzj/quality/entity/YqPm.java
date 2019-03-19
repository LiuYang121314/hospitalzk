package com.litbo.hospitalzj.quality.entity;

/**
 * 仪器和设备关联
 */
public class YqPm {
    private Integer id;
    private String yqId;
    private String eqPmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYqId() {
        return yqId;
    }

    public void setYqId(String yqId) {
        this.yqId = yqId;
    }

    public String getEqPmId() {
        return eqPmId;
    }

    public void setEqPmId(String eqPmId) {
        this.eqPmId = eqPmId;
    }
}
