package com.fh.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientSMS {

    public static String httpClientSMS(String url, Map<String,String> params,Map<String,String> header){
        CloseableHttpClient build = null;
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            build = HttpClientBuilder.create().build();
            httpPost = new HttpPost(url);
            if (params != null && params.size() >0){
                Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
                List<NameValuePair> pairs = new ArrayList<>();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    pairs.add(new BasicNameValuePair(key,value));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs, "utf-8");
                httpPost.setEntity(urlEncodedFormEntity);
            }
            if (header != null && header.size() >0){
                Iterator<Map.Entry<String, String>> iterator = header.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    httpPost.addHeader(key,value);
                }
            }
            response = build.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null){
                try {
                    response.close();
                    response = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpPost != null){
                httpPost.releaseConnection();
            }
            if (build != null){
                try {
                    build.close();
                    build = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            return result;
    }
}
