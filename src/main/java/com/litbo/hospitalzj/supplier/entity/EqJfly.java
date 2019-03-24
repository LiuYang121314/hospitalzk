package com.litbo.hospitalzj.supplier.entity;
/**
 * 设备经费来源
 * @author 刘洋
 *
 */
public class EqJfly {
	private Integer eqjfId;
	private String eqjfName;
	private Integer isDelete;
	public Integer getEqjfId() {
		return eqjfId;
	}
	public void setEqjfId(Integer eqjfId) {
		this.eqjfId = eqjfId;
	}
	public String getEqjfName() {
		return eqjfName;
	}
	public void setEqjfName(String eqjfName) {
		this.eqjfName = eqjfName;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "EqJfly [eqjfId=" + eqjfId + ", eqjfName=" + eqjfName + "]";
	}
	
}
