package com.litbo.hospitalzj.zk.domian;

import java.util.Date;

public class YqJxjl {
    private Integer id;

    private Integer yqId;

    private Date yqJxtime;

    private String yqJxr;

    private String yqJxbg;
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYqId() {
        return yqId;
    }

    public void setYqId(Integer yqId) {
        this.yqId = yqId;
    }

    public Date getYqJxtime() {
        return yqJxtime;
    }

    public void setYqJxtime(Date yqJxtime) {
        this.yqJxtime = yqJxtime;
    }

    public String getYqJxr() {
        return yqJxr;
    }

    public void setYqJxr(String yqJxr) {
        this.yqJxr = yqJxr == null ? null : yqJxr.trim();
    }

    public String getYqJxbg() {
        return yqJxbg;
    }

    public void setYqJxbg(String yqJxbg) {
        this.yqJxbg = yqJxbg == null ? null : yqJxbg.trim();
    }
}