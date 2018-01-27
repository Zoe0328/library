package com.library.common;

import java.io.Serializable;

/**
 * Created by zoe on 2018/1/27.
 */
public class ServerResponse<T> implements Serializable{
    public int status;
    public String msg;
    public T data;


    private ServerResponse(int status){
        this.status=status;
    }

    private ServerResponse(String msg){
        this.msg=msg;

    }

    private ServerResponse(int status,String msg){
        this.status=status;
        this.msg=msg;

    }
    private ServerResponse(int status,T data){
        this.status=status;
        this.data=data;

    }

    private ServerResponse(int status,String msg,T data){
        this.status=status;

        this.msg=msg;

        this.data=data;

    }

    //server的status等于success的code 登录成功
    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }


    public int getStatus(){
        return status;
    }
    public String getMsg(){
        return msg;
    }

    public T getData(){
        return data;
    }

    //对外开放的登录成功时的方法
    public static<T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }


    public static<T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }


    public static<T> ServerResponse<T> createBySuccess(T data){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static<T> ServerResponse<T> createBySuccess(String msg,T data){
        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static<T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static<T> ServerResponse<T> createByErrorMessage(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }


//    public static<T> ServerResponse<T> createByError(T data){
//        return  new ServerResponse<T>(ResponseCode.ERROR.getCode(),data);
//    }
//    public static<T> ServerResponse<T> createByError(String msg,T data){
//        return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
//    }
}

