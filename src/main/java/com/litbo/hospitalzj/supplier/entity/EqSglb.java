package com.litbo.hospitalzj.supplier.entity;
/**
 * 设备申购类别
 * @author 刘洋
 *
 */
public class EqSglb {
	private Integer eqsgId;
	private String eqsgName;
	private Integer isDelete;

	public Integer getEqsgId() {
		return eqsgId;
	}

	public void setEqsgId(Integer eqsgId) {
		this.eqsgId = eqsgId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getEqsgName() {
		return eqsgName;
	}
	public void setEqsgName(String eqsgName) {
		this.eqsgName = eqsgName;
	}
	@Override
	public String toString() {
		return "EqSglb [eqsgId=" + eqsgId + ", eqsgName=" + eqsgName + "]";
	}
	
}
