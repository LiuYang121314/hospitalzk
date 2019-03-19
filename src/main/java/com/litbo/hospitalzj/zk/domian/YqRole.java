package com.litbo.hospitalzj.zk.domian;

public class YqRole {
    private Integer id;

    private String userId;

    private Integer roleStatus;

    private String yqId;

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

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

	public String getYqId() {
		return yqId;
	}

	public void setYqId(String yqId) {
		this.yqId = yqId;
	}

	@Override
	public String toString() {
		return "YqRole [id=" + id + ", userId=" + userId + ", roleStatus=" + roleStatus + ", yqId=" + yqId + "]";
	}

    
}