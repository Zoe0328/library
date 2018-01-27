package com.library.common;

/**
 * Created by zoe on 2018/1/27.
 */
public enum  ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN");

    int code;
    String desc;

    ResponseCode(int code, String desc){
        this.code=code;
        this.desc=desc;
    }


    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
