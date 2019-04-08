package com.litbo.hospitalzj.zk.domian;

import java.util.Date;

public class UserEq {
    private Integer Id;

    private String userId;

    private String jcEqid;

    private String shEqid;

    private String state;

    private String shrId;

    private String ndjhId;

    private Date date;

    private String shrJcjl;

    public String getShrJcjl() {
        return shrJcjl;
    }

    public void setShrJcjl(String shrJcjl) {
        this.shrJcjl = shrJcjl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNdjhId() {
        return ndjhId;
    }

    public void setNdjhId(String ndjhId) {
        this.ndjhId = ndjhId;
    }

    public String getShrId() {
        return shrId;
    }

    public void setShrId(String shrId) {
        this.shrId = shrId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getJcEqid() {
        return jcEqid;
    }

    public void setJcEqid(String jcEqid) {
        this.jcEqid = jcEqid == null ? null : jcEqid.trim();
    }

    public String getShEqid() {
        return shEqid;
    }

    public void setShEqid(String shEqid) {
        this.shEqid = shEqid == null ? null : shEqid.trim();
    }
}