package com.litbo.hospitalzj.quality.entity;

public class UserPm {
    private Integer id;

    private String userId;

    private String eqPmId;

    private String state;

    private String shrId;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShrId() {
        return shrId;
    }

    public void setShrId(String shrId) {
        this.shrId = shrId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getEqPmId() {
        return eqPmId;
    }

    public void setEqPmId(String eqPmId) {
        this.eqPmId = eqPmId;
    }
}