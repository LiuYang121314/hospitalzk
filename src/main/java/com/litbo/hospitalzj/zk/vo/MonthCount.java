package com.litbo.hospitalzj.zk.vo;

/**
 * 月份数量
 */
public class MonthCount {
    private String month;
    private Integer count;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MonthCount{" +
                "month='" + month + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
