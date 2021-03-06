package com.litbo.hospitalzj.supplier.entity;

import java.util.Date;

/**
 * 合同表
 * @author 刘洋
 *
 */
public class HtInfo {
	private Integer htId;
	private String htGhsn;
	private String htGhsdh;
	private String htGhslxr;
	private String email;
	private String htHthao;
	private String htGzspd;
	private String htZhbhao;
	private String htBz;
	private String htQytime;
	private String htDhtime;
	private String htBxtime;
	private String htSyks;
	private String htAzdd;
	private String htLy;
	private String htCgfs;
	private String htSglb;
	private String htSbyt;
	private String htJfly;
	private String htZje;
	private String htYsyDh;
	private String htFile3;
	private String htFile4;
	private String htFile5;
	private String htState;
	private String htYzm;
	private String htYssj;
	private String htYsbz;
	
	public String getHtFile5() {
		return htFile5;
	}
	public void setHtFile5(String htFile5) {
		this.htFile5 = htFile5;
	}
	public String getHtYssj() {
		return htYssj;
	}
	public void setHtYssj(String htYssj) {
		this.htYssj = htYssj;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHtYsbz() {
		return htYsbz;
	}
	public void setHtYsbz(String htYsbz) {
		this.htYsbz = htYsbz;
	}
	public String getHtGzspd() {
		return htGzspd;
	}
	public void setHtGzspd(String htGzspd) {
		this.htGzspd = htGzspd;
	}
	private Integer sbcsId;
	
	public Integer getSbcsId() {
		return sbcsId;
	}
	public void setSbcsId(Integer sbcsId) {
		this.sbcsId = sbcsId;
	}

	public String getHtState() {
		return htState;
	}

	public void setHtState(String htState) {
		this.htState = htState;
	}

	public String getHtYzm() {
		return htYzm;
	}
	public void setHtYzm(String htYzm) {
		this.htYzm = htYzm;
	}
	public Integer getHtId() {
		return htId;
	}
	public void setHtId(Integer htId) {
		this.htId = htId;
	}
	public String getHtGhsn() {
		return htGhsn;
	}
	public void setHtGhsn(String htGhsn) {
		this.htGhsn = htGhsn;
	}
	public String getHtGhsdh() {
		return htGhsdh;
	}
	public void setHtGhsdh(String htGhsdh) {
		this.htGhsdh = htGhsdh;
	}
	public String getHtGhslxr() {
		return htGhslxr;
	}
	public void setHtGhslxr(String htGhslxr) {
		this.htGhslxr = htGhslxr;
	}
	public String getHtHthao() {
		return htHthao;
	}
	public void setHtHthao(String htHthao) {
		this.htHthao = htHthao;
	}
	public String getHtZhbhao() {
		return htZhbhao;
	}
	public void setHtZhbhao(String htZhbhao) {
		this.htZhbhao = htZhbhao;
	}
	public String getHtBz() {
		return htBz;
	}
	public void setHtBz(String htBz) {
		this.htBz = htBz;
	}
	
	public String getHtQytime() {
		return htQytime;
	}
	public void setHtQytime(String htQytime) {
		this.htQytime = htQytime;
	}
	public String getHtDhtime() {
		return htDhtime;
	}
	public void setHtDhtime(String htDhtime) {
		this.htDhtime = htDhtime;
	}
	public String getHtBxtime() {
		return htBxtime;
	}
	public void setHtBxtime(String htBxtime) {
		this.htBxtime = htBxtime;
	}
	public String getHtSyks() {
		return htSyks;
	}
	public void setHtSyks(String htSyks) {
		this.htSyks = htSyks;
	}
	public String getHtAzdd() {
		return htAzdd;
	}
	public void setHtAzdd(String htAzdd) {
		this.htAzdd = htAzdd;
	}
	public String getHtLy() {
		return htLy;
	}
	public void setHtLy(String htLy) {
		this.htLy = htLy;
	}
	public String getHtCgfs() {
		return htCgfs;
	}
	public void setHtCgfs(String htCgfs) {
		this.htCgfs = htCgfs;
	}
	public String getHtSglb() {
		return htSglb;
	}
	public void setHtSglb(String htSglb) {
		this.htSglb = htSglb;
	}
	public String getHtSbyt() {
		return htSbyt;
	}
	public void setHtSbyt(String htSbyt) {
		this.htSbyt = htSbyt;
	}
	public String getHtJfly() {
		return htJfly;
	}
	public void setHtJfly(String htJfly) {
		this.htJfly = htJfly;
	}

	public String getHtZje() {
		return htZje;
	}

	public void setHtZje(String htZje) {
		this.htZje = htZje;
	}

	public String getHtYsyDh() {
		return htYsyDh;
	}

	public void setHtYsyDh(String htYsyDh) {
		this.htYsyDh = htYsyDh;
	}

	public String getHtFile3() {
		return htFile3;
	}
	public void setHtFile3(String htFile3) {
		this.htFile3 = htFile3;
	}
	public String getHtFile4() {
		return htFile4;
	}
	public void setHtFile4(String htFile4) {
		this.htFile4 = htFile4;
	}

	@Override
	public String toString() {
		return "HtInfo{" +
				"htId=" + htId +
				", htGhsn='" + htGhsn + '\'' +
				", htGhsdh='" + htGhsdh + '\'' +
				", htGhslxr='" + htGhslxr + '\'' +
				", email='" + email + '\'' +
				", htHthao='" + htHthao + '\'' +
				", htGzspd='" + htGzspd + '\'' +
				", htZhbhao='" + htZhbhao + '\'' +
				", htBz='" + htBz + '\'' +
				", htQytime='" + htQytime + '\'' +
				", htDhtime='" + htDhtime + '\'' +
				", htBxtime='" + htBxtime + '\'' +
				", htSyks='" + htSyks + '\'' +
				", htAzdd='" + htAzdd + '\'' +
				", htLy='" + htLy + '\'' +
				", htCgfs='" + htCgfs + '\'' +
				", htSglb='" + htSglb + '\'' +
				", htSbyt='" + htSbyt + '\'' +
				", htJfly='" + htJfly + '\'' +
				", htZje='" + htZje + '\'' +
				", htYsyDh='" + htYsyDh + '\'' +
				", htFile3='" + htFile3 + '\'' +
				", htFile4='" + htFile4 + '\'' +
				", htFile5='" + htFile5 + '\'' +
				", htState='" + htState + '\'' +
				", htYzm='" + htYzm + '\'' +
				", htYssj='" + htYssj + '\'' +
				", htYsbz='" + htYsbz + '\'' +
				", sbcsId=" + sbcsId +
				'}';
	}
}
