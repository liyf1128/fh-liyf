package com.fh.common;

import java.io.Serializable;

public class ServerResponse implements Serializable {

    private static final long serialVersionUID = -1344955216235118403L;
    private Integer code;
    private String msg;
    private Object data;

    private ServerResponse(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ServerResponse success(){
        return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null);

    }
    public static ServerResponse success(Object data){
        return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data);
    }
    public static ServerResponse success(Integer code,String msg){
        return new ServerResponse(code,msg,null);
    }

    public static ServerResponse error(Integer code,String msg){
        return new ServerResponse(code,msg,null);
    }

    public static ServerResponse error(ResponseEnum responseEnum){
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMsg(),null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
