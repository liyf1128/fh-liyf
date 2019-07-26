package com.fh.common;

public enum ResponseEnum {
    ERROR(-1,"失败"),
    USER_ERROR(1000,"用户名或密码为空!"),
    USER_ERROR_NAME(1001,"用户名错误!"),
    USER_NAME(1003,"用户名已存在!"),
    USER_ERROR_PWD(1002,"密码错误!"),
    SING_IS_MISS(1004,"请求头获取失败"),
    SECRET_IS_ERROR(1005,"验签失败"),
    KEY_MISS(1006,"数据消失"),
    MEMBER_ERROR(1007,"账户已停用"),
    SMS_PHONE_IS_EMPTY(2000,"手机号不能为空"),
    SMS_PHONE_LENGTH_ERROR(2001,"手机号长度不合法"),
    SMS_ERROR(2002,"调用网易云信接口异常"),
    SMS_REPEAT_SEND(2003,"不允许重复发送"),
    SMS_CODE_TIME_OUT(2004,"验证码超时，请再次发送"),
    SMS_CODE_IS_ERROR(2005,"验证码错误"),
    MEMBER_NAME_IS_EMPTY(4000 , "会员名不能为空"),
    MEMBER_REALNAME_IS_EMPTY(4001 , "真实姓名不能为空"),
    MEMBER_PASSWD_IS_EMPTY(4002 , "密码不能为空"),
    MEMBER_BIRTHDAY_IS_EMPTY(4003 , "生日不能为空"),
    MEMBER_PHONE_IS_EMPTY(4004 , "手机号不能为空"),
    MEMBER_CODE_IS_EMPTY(4005 , "验证码不能为空"),
    MEMBER_EMILY_IS_EMPTY(4006 , "邮箱不能为空"),
    MEMBER_A1_IS_EMPTY(4007 , "省不能为空"),
    MEMBER_A2_IS_EMPTY(4008 , "市不能为空"),
    MEMBER_A3_IS_EMPTY(4009 , "县不能为空"),
    MEMBER_ARRAY_IS_EMPTY(4011 , "省市县不能为空"),
    MEMBER_REALNAME_ISCHINESE(4010 , "真实姓名必须为中文"),
    SMS_PHONE_ERROR(3002 , "手机号以13、15、18开头"),

    SUCCESS(200,"成功");

    private Integer code;
    private String msg;

    private ResponseEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
