package com.fh.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SMSUtil {


    private static String url;

    private static String templateId;

    private static String appKey;

    private static String appSecret;

    @Value("${sms.url}")
    public void setUrl(String url) {
        SMSUtil.url = url;
    }
    @Value("${sms.templateid}")
    public void setTemplateId(String templateId) {
        SMSUtil.templateId = templateId;
    }
    @Value("${sms.appkey}")
    public void setAppKey(String appKey) {
        SMSUtil.appKey = appKey;
    }
    @Value("${sms.appsecret}")
    public void setAppSecret(String appSecret) {
        SMSUtil.appSecret = appSecret;
    }

    public static String SMSUtil(String phone){
        Map<String, String> params = buildParams(phone);
        Map<String, String> header = buildHeaders();
        String result = HttpClientSMS.httpClientSMS(url, params, header);
        return result;
    }

    private static Map<String, String> buildHeaders() {
        Map<String,String> header = new HashMap<>();
        header.put("AppKey",appKey);
        String uuid = UUID.randomUUID().toString();
        header.put("Nonce",uuid);
        String curStr = new Date().getTime()+"";
        header.put("CurTime",curStr);
        String sign = CheckSumBuilder.getCheckSum(appSecret, uuid, curStr);
        header.put("CheckSum",sign);
        return header;
    }

    private static Map<String, String> buildParams(String phone) {
        Map<String,String> params = new HashMap<>();
        params.put("mobile",phone);
        params.put("templateid",templateId);
        return params;
    }
}
