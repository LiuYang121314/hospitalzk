package com.litbo.hospitalzj.supplier.entity;
/**
 * 设备采购方式
 * @author 刘洋
 *
 */
public class EqCgfs {
	private Integer eqcgId;
	private String eqcgName;
	private Integer isDelete;
	public Integer getEqcgId() {
		return eqcgId;
	}
	public void setEqcgId(Integer eqcgId) {
		this.eqcgId = eqcgId;
	}
	public String getEqcgName() {
		return eqcgName;
	}
	public void setEqcgName(String eqcgName) {
		this.eqcgName = eqcgName;
	}
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "EqCgfs [eqcgId=" + eqcgId + ", eqcgName=" + eqcgName + "]";
	}
	
}
