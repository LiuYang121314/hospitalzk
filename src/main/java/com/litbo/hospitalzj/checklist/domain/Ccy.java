package com.litbo.hospitalzj.checklist.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Ccy {
    private Integer ccyId;

    private Integer jcyqId;

    private Integer eqId;

    private String tester;

    private String auditor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date testTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String shrJcjl;

    private Date shsjTime;

    private String jcjl;

    private String jcsm;

    private String sfnlYxwc;

    private String sfnlTest1;

    private String sfnlValue1;

    private String sfnlWc1;

    private String sfnlTest2;

    private String sfnlValue2;

    private String sfnlWc2;

    private String sfnlTest3;

    private String sfnlValue3;

    private String sfnlWc3;

    private String sfnlTest4;

    private String sfnlValue4;

    private String sfnlWc4;

    private String sfnlTest5;

    private String sfnlValue5;

    private String sfnlWc5;

    private String sfnlTest6;

    private String sfnlValue6;

    private String sfnlWc6;

    private String sfnlTest7;

    private String sfnlValue71;

    private String sfnlValue72;

    private String sfnlValue73;

    private String sfnlWc7;

    private String sfnlTest8;

    private String sfnlValue81;

    private String sfnlValue82;

    private String sfnlValue83;

    private String sfnlWc8;

    private String sfnlResult;

    private String cdsjTest;

    private String cdsjValue;

    private String cdsjResult;

    private String nbfdResult;

    private String tbmsCfresult;

    private String tbmsYcsj;

    private String tbmsSj;

    private String tbmsResult;

    private String xlszTest1;

    private String xlszValue1;

    private String xlszTest2;

    private String xlszValue2;

    private String xlszTest3;

    private String xlszValue3;

    private String xlszTest4;

    private String xlszValue4;

    private String xlszTest5;

    private String xlszValue5;

    private String xlszResult;

    private String sgbjResult;

    private String bjxResult;

    private String jyResult;

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getJcyqId() {
        return jcyqId;
    }

    public void setJcyqId(Integer jcyqId) {
        this.jcyqId = jcyqId;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester == null ? null : tester.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getShrJcjl() {
        return shrJcjl;
    }

    public void setShrJcjl(String shrJcjl) {
        this.shrJcjl = shrJcjl == null ? null : shrJcjl.trim();
    }

    public Date getShsjTime() {
        return shsjTime;
    }

    public void setShsjTime(Date shsjTime) {
        this.shsjTime = shsjTime;
    }

    public String getJcjl() {
        return jcjl;
    }

    public void setJcjl(String jcjl) {
        this.jcjl = jcjl == null ? null : jcjl.trim();
    }

    public String getJcsm() {
        return jcsm;
    }

    public void setJcsm(String jcsm) {
        this.jcsm = jcsm == null ? null : jcsm.trim();
    }

    public String getSfnlYxwc() {
        return sfnlYxwc;
    }

    public void setSfnlYxwc(String sfnlYxwc) {
        this.sfnlYxwc = sfnlYxwc == null ? null : sfnlYxwc.trim();
    }

    public String getSfnlTest1() {
        return sfnlTest1;
    }

    public void setSfnlTest1(String sfnlTest1) {
        this.sfnlTest1 = sfnlTest1 == null ? null : sfnlTest1.trim();
    }

    public String getSfnlValue1() {
        return sfnlValue1;
    }

    public void setSfnlValue1(String sfnlValue1) {
        this.sfnlValue1 = sfnlValue1 == null ? null : sfnlValue1.trim();
    }

    public String getSfnlWc1() {
        return sfnlWc1;
    }

    public void setSfnlWc1(String sfnlWc1) {
        this.sfnlWc1 = sfnlWc1 == null ? null : sfnlWc1.trim();
    }

    public String getSfnlTest2() {
        return sfnlTest2;
    }

    public void setSfnlTest2(String sfnlTest2) {
        this.sfnlTest2 = sfnlTest2 == null ? null : sfnlTest2.trim();
    }

    public String getSfnlValue2() {
        return sfnlValue2;
    }

    public void setSfnlValue2(String sfnlValue2) {
        this.sfnlValue2 = sfnlValue2 == null ? null : sfnlValue2.trim();
    }

    public String getSfnlWc2() {
        return sfnlWc2;
    }

    public void setSfnlWc2(String sfnlWc2) {
        this.sfnlWc2 = sfnlWc2 == null ? null : sfnlWc2.trim();
    }

    public String getSfnlTest3() {
        return sfnlTest3;
    }

    public void setSfnlTest3(String sfnlTest3) {
        this.sfnlTest3 = sfnlTest3 == null ? null : sfnlTest3.trim();
    }

    public String getSfnlValue3() {
        return sfnlValue3;
    }

    public void setSfnlValue3(String sfnlValue3) {
        this.sfnlValue3 = sfnlValue3 == null ? null : sfnlValue3.trim();
    }

    public String getSfnlWc3() {
        return sfnlWc3;
    }

    public void setSfnlWc3(String sfnlWc3) {
        this.sfnlWc3 = sfnlWc3 == null ? null : sfnlWc3.trim();
    }

    public String getSfnlTest4() {
        return sfnlTest4;
    }

    public void setSfnlTest4(String sfnlTest4) {
        this.sfnlTest4 = sfnlTest4 == null ? null : sfnlTest4.trim();
    }

    public String getSfnlValue4() {
        return sfnlValue4;
    }

    public void setSfnlValue4(String sfnlValue4) {
        this.sfnlValue4 = sfnlValue4 == null ? null : sfnlValue4.trim();
    }

    public String getSfnlWc4() {
        return sfnlWc4;
    }

    public void setSfnlWc4(String sfnlWc4) {
        this.sfnlWc4 = sfnlWc4 == null ? null : sfnlWc4.trim();
    }

    public String getSfnlTest5() {
        return sfnlTest5;
    }

    public void setSfnlTest5(String sfnlTest5) {
        this.sfnlTest5 = sfnlTest5 == null ? null : sfnlTest5.trim();
    }

    public String getSfnlValue5() {
        return sfnlValue5;
    }

    public void setSfnlValue5(String sfnlValue5) {
        this.sfnlValue5 = sfnlValue5 == null ? null : sfnlValue5.trim();
    }

    public String getSfnlWc5() {
        return sfnlWc5;
    }

    public void setSfnlWc5(String sfnlWc5) {
        this.sfnlWc5 = sfnlWc5 == null ? null : sfnlWc5.trim();
    }

    public String getSfnlTest6() {
        return sfnlTest6;
    }

    public void setSfnlTest6(String sfnlTest6) {
        this.sfnlTest6 = sfnlTest6 == null ? null : sfnlTest6.trim();
    }

    public String getSfnlValue6() {
        return sfnlValue6;
    }

    public void setSfnlValue6(String sfnlValue6) {
        this.sfnlValue6 = sfnlValue6 == null ? null : sfnlValue6.trim();
    }

    public String getSfnlWc6() {
        return sfnlWc6;
    }

    public void setSfnlWc6(String sfnlWc6) {
        this.sfnlWc6 = sfnlWc6 == null ? null : sfnlWc6.trim();
    }

    public String getSfnlTest7() {
        return sfnlTest7;
    }

    public void setSfnlTest7(String sfnlTest7) {
        this.sfnlTest7 = sfnlTest7 == null ? null : sfnlTest7.trim();
    }

    public String getSfnlValue71() {
        return sfnlValue71;
    }

    public void setSfnlValue71(String sfnlValue71) {
        this.sfnlValue71 = sfnlValue71 == null ? null : sfnlValue71.trim();
    }

    public String getSfnlValue72() {
        return sfnlValue72;
    }

    public void setSfnlValue72(String sfnlValue72) {
        this.sfnlValue72 = sfnlValue72 == null ? null : sfnlValue72.trim();
    }

    public String getSfnlValue73() {
        return sfnlValue73;
    }

    public void setSfnlValue73(String sfnlValue73) {
        this.sfnlValue73 = sfnlValue73 == null ? null : sfnlValue73.trim();
    }

    public String getSfnlWc7() {
        return sfnlWc7;
    }

    public void setSfnlWc7(String sfnlWc7) {
        this.sfnlWc7 = sfnlWc7 == null ? null : sfnlWc7.trim();
    }

    public String getSfnlTest8() {
        return sfnlTest8;
    }

    public void setSfnlTest8(String sfnlTest8) {
        this.sfnlTest8 = sfnlTest8 == null ? null : sfnlTest8.trim();
    }

    public String getSfnlValue81() {
        return sfnlValue81;
    }

    public void setSfnlValue81(String sfnlValue81) {
        this.sfnlValue81 = sfnlValue81 == null ? null : sfnlValue81.trim();
    }

    public String getSfnlValue82() {
        return sfnlValue82;
    }

    public void setSfnlValue82(String sfnlValue82) {
        this.sfnlValue82 = sfnlValue82 == null ? null : sfnlValue82.trim();
    }

    public String getSfnlValue83() {
        return sfnlValue83;
    }

    public void setSfnlValue83(String sfnlValue83) {
        this.sfnlValue83 = sfnlValue83 == null ? null : sfnlValue83.trim();
    }

    public String getSfnlWc8() {
        return sfnlWc8;
    }

    public void setSfnlWc8(String sfnlWc8) {
        this.sfnlWc8 = sfnlWc8 == null ? null : sfnlWc8.trim();
    }

    public String getSfnlResult() {
        return sfnlResult;
    }

    public void setSfnlResult(String sfnlResult) {
        this.sfnlResult = sfnlResult == null ? null : sfnlResult.trim();
    }

    public String getCdsjTest() {
        return cdsjTest;
    }

    public void setCdsjTest(String cdsjTest) {
        this.cdsjTest = cdsjTest == null ? null : cdsjTest.trim();
    }

    public String getCdsjValue() {
        return cdsjValue;
    }

    public void setCdsjValue(String cdsjValue) {
        this.cdsjValue = cdsjValue == null ? null : cdsjValue.trim();
    }

    public String getCdsjResult() {
        return cdsjResult;
    }

    public void setCdsjResult(String cdsjResult) {
        this.cdsjResult = cdsjResult == null ? null : cdsjResult.trim();
    }

    public String getNbfdResult() {
        return nbfdResult;
    }

    public void setNbfdResult(String nbfdResult) {
        this.nbfdResult = nbfdResult == null ? null : nbfdResult.trim();
    }

    public String getTbmsCfresult() {
        return tbmsCfresult;
    }

    public void setTbmsCfresult(String tbmsCfresult) {
        this.tbmsCfresult = tbmsCfresult == null ? null : tbmsCfresult.trim();
    }

    public String getTbmsYcsj() {
        return tbmsYcsj;
    }

    public void setTbmsYcsj(String tbmsYcsj) {
        this.tbmsYcsj = tbmsYcsj == null ? null : tbmsYcsj.trim();
    }

    public String getTbmsSj() {
        return tbmsSj;
    }

    public void setTbmsSj(String tbmsSj) {
        this.tbmsSj = tbmsSj == null ? null : tbmsSj.trim();
    }

    public String getTbmsResult() {
        return tbmsResult;
    }

    public void setTbmsResult(String tbmsResult) {
        this.tbmsResult = tbmsResult == null ? null : tbmsResult.trim();
    }

    public String getXlszTest1() {
        return xlszTest1;
    }

    public void setXlszTest1(String xlszTest1) {
        this.xlszTest1 = xlszTest1 == null ? null : xlszTest1.trim();
    }

    public String getXlszValue1() {
        return xlszValue1;
    }

    public void setXlszValue1(String xlszValue1) {
        this.xlszValue1 = xlszValue1 == null ? null : xlszValue1.trim();
    }

    public String getXlszTest2() {
        return xlszTest2;
    }

    public void setXlszTest2(String xlszTest2) {
        this.xlszTest2 = xlszTest2 == null ? null : xlszTest2.trim();
    }

    public String getXlszValue2() {
        return xlszValue2;
    }

    public void setXlszValue2(String xlszValue2) {
        this.xlszValue2 = xlszValue2 == null ? null : xlszValue2.trim();
    }

    public String getXlszTest3() {
        return xlszTest3;
    }

    public void setXlszTest3(String xlszTest3) {
        this.xlszTest3 = xlszTest3 == null ? null : xlszTest3.trim();
    }

    public String getXlszValue3() {
        return xlszValue3;
    }

    public void setXlszValue3(String xlszValue3) {
        this.xlszValue3 = xlszValue3 == null ? null : xlszValue3.trim();
    }

    public String getXlszTest4() {
        return xlszTest4;
    }

    public void setXlszTest4(String xlszTest4) {
        this.xlszTest4 = xlszTest4 == null ? null : xlszTest4.trim();
    }

    public String getXlszValue4() {
        return xlszValue4;
    }

    public void setXlszValue4(String xlszValue4) {
        this.xlszValue4 = xlszValue4 == null ? null : xlszValue4.trim();
    }

    public String getXlszTest5() {
        return xlszTest5;
    }

    public void setXlszTest5(String xlszTest5) {
        this.xlszTest5 = xlszTest5 == null ? null : xlszTest5.trim();
    }

    public String getXlszValue5() {
        return xlszValue5;
    }

    public void setXlszValue5(String xlszValue5) {
        this.xlszValue5 = xlszValue5 == null ? null : xlszValue5.trim();
    }

    public String getXlszResult() {
        return xlszResult;
    }

    public void setXlszResult(String xlszResult) {
        this.xlszResult = xlszResult == null ? null : xlszResult.trim();
    }

    public String getSgbjResult() {
        return sgbjResult;
    }

    public void setSgbjResult(String sgbjResult) {
        this.sgbjResult = sgbjResult == null ? null : sgbjResult.trim();
    }

    public String getBjxResult() {
        return bjxResult;
    }

    public void setBjxResult(String bjxResult) {
        this.bjxResult = bjxResult == null ? null : bjxResult.trim();
    }

    public String getJyResult() {
        return jyResult;
    }

    public void setJyResult(String jyResult) {
        this.jyResult = jyResult == null ? null : jyResult.trim();
    }
}