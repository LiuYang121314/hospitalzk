package com.litbo.hospitalzj.zk.domian;

import java.util.Date;
/**
 * 仪器推送流水
 */
public class YqTsls {
    private Integer id;

    private String yqName;

    private Date yqExpireDate;

    private String pushRole;

    private String pushMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYqName() {
        return yqName;
    }

    public void setYqName(String yqName) {
        this.yqName = yqName == null ? null : yqName.trim();
    }

    public Date getYqExpireDate() {
        return yqExpireDate;
    }

    public void setYqExpireDate(Date yqExpireDate) {
        this.yqExpireDate = yqExpireDate;
    }

    public String getPushRole() {
        return pushRole;
    }

    public void setPushRole(String pushRole) {
        this.pushRole = pushRole == null ? null : pushRole.trim();
    }

    public String getPushMsg() {
        return pushMsg;
    }

    public void setPushMsg(String pushMsg) {
        this.pushMsg = pushMsg == null ? null : pushMsg.trim();
    }
}