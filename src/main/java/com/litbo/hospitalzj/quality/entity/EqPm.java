package com.litbo.hospitalzj.quality.entity;
/**
 * 设备品名字典表
 * @author 刘洋
 *
 */
public class EqPm {
	private Integer eqPmId;
	private String eqPmName;
	private String eqPmLx;
	private Integer isDelete;
	public Integer getEqPmId() {
		return eqPmId;
	}
	public void setEqPmId(Integer eqPmId) {
		this.eqPmId = eqPmId;
	}
	public String getEqPmName() {
		return eqPmName;
	}
	public void setEqPmName(String eqPmName) {
		this.eqPmName = eqPmName;
	}
	public String getEqPmLx() {
		return eqPmLx;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public void setEqPmLx(String eqPmLx) {
		this.eqPmLx = eqPmLx;
	}
}
