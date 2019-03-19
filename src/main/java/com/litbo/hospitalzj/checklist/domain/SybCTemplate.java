package com.litbo.hospitalzj.checklist.domain;

public class SybCTemplate {
    private Long tempId;

    private Integer llcsd1;

    private Integer llcsd2;

    private Integer wc;

    private Integer zsbjllz;

    private Integer zsbjWc1;

    private Integer zsbjWc2;

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

    public Integer getLlcsd1() {
        return llcsd1;
    }

    public void setLlcsd1(Integer llcsd1) {
        this.llcsd1 = llcsd1;
    }

    public Integer getLlcsd2() {
        return llcsd2;
    }

    public void setLlcsd2(Integer llcsd2) {
        this.llcsd2 = llcsd2;
    }

    public Integer getWc() {
        return wc;
    }

    public void setWc(Integer wc) {
        this.wc = wc;
    }

    public Integer getZsbjllz() {
        return zsbjllz;
    }

    public void setZsbjllz(Integer zsbjllz) {
        this.zsbjllz = zsbjllz;
    }

    public Integer getZsbjWc1() {
        return zsbjWc1;
    }

    public void setZsbjWc1(Integer zsbjWc1) {
        this.zsbjWc1 = zsbjWc1;
    }

    public Integer getZsbjWc2() {
        return zsbjWc2;
    }

    public void setZsbjWc2(Integer zsbjWc2) {
        this.zsbjWc2 = zsbjWc2;
    }

    @Override
    public String toString() {
        return "SybCTemplate{" +
                "tempId=" + tempId +
                ", llcsd1=" + llcsd1 +
                ", llcsd2=" + llcsd2 +
                ", wc=" + wc +
                ", zsbjllz=" + zsbjllz +
                ", zsbjWc1=" + zsbjWc1 +
                ", zsbjWc2=" + zsbjWc2 +
                '}';
    }
}