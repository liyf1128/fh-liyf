package com.fh.util;

public class FileKeyUtil {

    public static String KeyUtil(String name,String uuid){
        return "user:"+name+":"+uuid;
    }

    public static String buildSMSKey(String phone){
        return "user:code:"+phone;
    }
}
