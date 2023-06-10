package com.liuyi.demo1.exception;

public enum ErrorEnum {
    UNKOWN_ERROR("未知异常!"),
    BRAND_NULL("品牌为空!"),
    MAPPED_NULL("映射值为空!"),
    SERIES_EXIST("系列标签已存在!"),
    LAST_NULL("最终品牌为空!");

    private String errMessage;

    private ErrorEnum(String messagae){
        this.errMessage = messagae;
    }

    public String getErrMessage(){
        return errMessage;
    }
}
