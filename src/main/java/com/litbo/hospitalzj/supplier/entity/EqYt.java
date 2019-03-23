package com.litbo.hospitalzj.supplier.entity;
/**
 * 设备用途
 * @author 刘洋
 *
 */
public class EqYt {
	private Integer eqytId;
	private String eqytName;
	private Integer isDelete;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getEqytId() {
		return eqytId;
	}

	public void setEqytId(Integer eqytId) {
		this.eqytId = eqytId;
	}

	public String getEqytName() {
		return eqytName;
	}
	public void setEqytName(String eqytName) {
		this.eqytName = eqytName;
	}
	@Override
	public String toString() {
		return "EqYt [eqytId=" + eqytId + ", eqytName=" + eqytName + "]";
	}
	
}
