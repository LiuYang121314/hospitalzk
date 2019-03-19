package com.litbo.hospitalzj.zk.domian;

public class YqEq {
    private Integer id;

    private String jcyqId;

    private String eqId;

    private String eqMc;

    private Integer state;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getEqMc() {
		return eqMc;
	}

	public void setEqMc(String eqMc) {
		this.eqMc = eqMc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJcyqId() {
		return jcyqId;
	}

	public void setJcyqId(String jcyqId) {
		this.jcyqId = jcyqId;
	}

	public String getEqId() {
		return eqId;
	}

	public void setEqId(String eqId) {
		this.eqId = eqId;
	}

	@Override
	public String toString() {
		return "YqEq [id=" + id + ", jcyqId=" + jcyqId + ", eqId=" + eqId + ", eqMc=" + eqMc + "]";
	}
   
}