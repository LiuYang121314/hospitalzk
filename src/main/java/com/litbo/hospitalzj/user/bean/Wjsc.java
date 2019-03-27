package com.litbo.hospitalzj.user.bean;

import java.util.Date;
//文件上传
public class Wjsc {
    private Integer id;

    private Integer sourceType;

    private Integer sourceId;

    private Integer type;

    private String path;

    private Date scTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getScTime() {
        return scTime;
    }

    public void setScTime(Date scTime) {
        this.scTime = scTime;
    }
}