package com.litbo.hospitalzj.zk.Enum;


public enum EnumProcess2 {
    UNDER_DETECTIO(1,"待检测"),
    UNDER_REVIEW(2,"待审核"),
    AUTID_NOT(3,"审核不通过"),
    PERFECT_INFORMATION(4,"审核通过"),
    TO_AUDIT(5,"待上报"),
    SHANG_AUTID_NOT(6,"上报审核不通过"),
    SHANG_PERFECT_INFORMATION(7,"上报审核成功"),
    DETECTION_OF_AUDIT_NOT(8,"检测审核不通过"),
    DETECTION_OF_AUDIT_IS(9,"检测审核成功"),
    IN_REVIEW(9,"审核中"),
    TO_UPLOAD(10,"待上传"),
    IS_UPLOAD(11,"已上传");


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;
    private String message;
    EnumProcess2(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
