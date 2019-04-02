package com.litbo.hospitalzj.zk.domian;

/**
 * 年度计划提醒
 */
public class NdjhTx {
    private Integer id;
    private Integer userId;
    private String pushMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPushMsg() {
        return pushMsg;
    }

    public void setPushMsg(String pushMsg) {
        this.pushMsg = pushMsg;
    }

    @Override
    public String toString() {
        return "ndjhTx{" +
                "id=" + id +
                ", userId=" + userId +
                ", pushMsg='" + pushMsg + '\'' +
                '}';
    }
}
