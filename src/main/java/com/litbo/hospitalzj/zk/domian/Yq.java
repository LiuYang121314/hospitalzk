package com.litbo.hospitalzj.zk.domian;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Yq {
    private String jcyqId;

    private String jcyqName;

    private String jcyqXh;

    private String jcyqXzzqTime;

    private String jcyqDah;

    private String jcyqBh;

    private Integer jcyqCjId;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    private Date jcyqQyTime;

    private Integer jcyqKsId;

    private String jcyqCf;

    private String jcyqUrl;
    
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    private Date jcyqJzTime;

    private Integer mbId;
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(String jcyqId) {
        this.jcyqId = jcyqId == null ? null : jcyqId.trim();
    }

    public String getJcyqName() {
        return jcyqName;
    }

    public void setJcyqName(String jcyqName) {
        this.jcyqName = jcyqName == null ? null : jcyqName.trim();
    }

    public String getJcyqXh() {
        return jcyqXh;
    }

    public void setJcyqXh(String jcyqXh) {
        this.jcyqXh = jcyqXh == null ? null : jcyqXh.trim();
    }

    public String getJcyqXzzqTime() {
        return jcyqXzzqTime;
    }

    public void setJcyqXzzqTime(String jcyqXzzqTime) {
        this.jcyqXzzqTime = jcyqXzzqTime == null ? null : jcyqXzzqTime.trim();
    }

    public String getJcyqDah() {
        return jcyqDah;
    }

    public void setJcyqDah(String jcyqDah) {
        this.jcyqDah = jcyqDah == null ? null : jcyqDah.trim();
    }

    public String getJcyqBh() {
        return jcyqBh;
    }

    public void setJcyqBh(String jcyqBh) {
        this.jcyqBh = jcyqBh == null ? null : jcyqBh.trim();
    }

    public Integer getJcyqCjId() {
        return jcyqCjId;
    }

    public void setJcyqCjId(Integer jcyqCjId) {
        this.jcyqCjId = jcyqCjId;
    }

    public Date getJcyqQyTime() {
        return jcyqQyTime;
    }

    public void setJcyqQyTime(Date jcyqQyTime) {
        this.jcyqQyTime = jcyqQyTime;
    }

    public Integer getJcyqKsId() {
        return jcyqKsId;
    }

    public void setJcyqKsId(Integer jcyqKsId) {
        this.jcyqKsId = jcyqKsId;
    }

    public String getJcyqCf() {
        return jcyqCf;
    }

    public void setJcyqCf(String jcyqCf) {
        this.jcyqCf = jcyqCf == null ? null : jcyqCf.trim();
    }

    public String getJcyqUrl() {
        return jcyqUrl;
    }

    public void setJcyqUrl(String jcyqUrl) {
        this.jcyqUrl = jcyqUrl == null ? null : jcyqUrl.trim();
    }

    public Date getJcyqJzTime() {
        return jcyqJzTime;
    }

    public void setJcyqJzTime(Date jcyqJzTime) {
        this.jcyqJzTime = jcyqJzTime;
    }

    public Integer getMbId() {
        return mbId;
    }

    public void setMbId(Integer mbId) {
        this.mbId = mbId;
    }
}