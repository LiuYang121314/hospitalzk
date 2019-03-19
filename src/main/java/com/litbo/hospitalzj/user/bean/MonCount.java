package com.litbo.hospitalzj.user.bean;

public class MonCount {
	private Integer months;
	private Integer count;

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "MonCount [months=" + months + ", count=" + count + "]";
	}
	
}
