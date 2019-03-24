package com.litbo.hospitalzj.supplier.entity;
/**
 * 设备来源数据
 * @author 刘洋
 *
 */
public class EqLy {
	private Integer eqlyId;
	private String eqlyName;
	private Integer isDelete;

	public Integer getEqlyId() {
		return eqlyId;
	}

	public void setEqlyId(Integer eqlyId) {
		this.eqlyId = eqlyId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getEqlyName() {
		return eqlyName;
	}
	public void setEqlyName(String eqlyName) {
		this.eqlyName = eqlyName;
	}
	@Override
	public String toString() {
		return "EqLy [eqlyId=" + eqlyId + ", eqlyName=" + eqlyName + "]";
	}
	
}
