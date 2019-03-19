package com.litbo.hospitalzj.quality.vo;

/**
 * 查询用户分到的设备名
 */
public class UserPmVo {
    private String userId;

    private String eqPmId;

    private String eqPmName;

    private String state;

    private String shrId;

    private String eqPmLx;

    public String getEqPmId() {
        return eqPmId;
    }

    public void setEqPmId(String eqPmId) {
        this.eqPmId = eqPmId;
    }

    public String getEqPmLx() {
        return eqPmLx;
    }

    public void setEqPmLx(String eqPmLx) {
        this.eqPmLx = eqPmLx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEqPmName() {
        return eqPmName;
    }

    public void setEqPmName(String eqPmName) {
        this.eqPmName = eqPmName;
    }

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
}
