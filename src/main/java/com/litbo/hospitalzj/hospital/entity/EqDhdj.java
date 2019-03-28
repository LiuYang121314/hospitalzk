package com.litbo.hospitalzj.hospital.entity;

import java.util.Date;

public class EqDhdj {
    private Integer id;

    private Integer htId;

    private Integer dhdjType;

    private Integer dhdjQk;

    private Date dhdjTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHtId() {
        return htId;
    }

    public void setHtId(Integer htId) {
        this.htId = htId;
    }

    public Integer getDhdjType() {
        return dhdjType;
    }

    public void setDhdjType(Integer dhdjType) {
        this.dhdjType = dhdjType;
    }

    public Integer getDhdjQk() {
        return dhdjQk;
    }

    public void setDhdjQk(Integer dhdjQk) {
        this.dhdjQk = dhdjQk;
    }

    public Date getDhdjTime() {
        return dhdjTime;
    }

    public void setDhdjTime(Date dhdjTime) {
        this.dhdjTime = dhdjTime;
    }

    @Override
    public String toString() {
        return "EqDhdj{" +
                "id=" + id +
                ", htId=" + htId +
                ", dhdjType=" + dhdjType +
                ", dhdjQk=" + dhdjQk +
                ", dhdjTime=" + dhdjTime +
                '}';
    }
}