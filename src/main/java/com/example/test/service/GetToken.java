package com.example.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetToken {

    public static String token(){
        String token = null;
       // String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wx9043ec03bf399a54&corpsecret=v39bZPFtzMwFqRiDc-sh0jYpJwHvMfaZAZxuNCyKPLg";

        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wx9043ec03bf399a54&corpsecret=-noGDp3M0pGdEuyy1udtHsal8Srra9jTM6b8GMF6rC8";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type","text/json;charset=UTF-8");
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpGet);
            HttpEntity resEntity = response.getEntity();

            if(resEntity != null){
                String msg = EntityUtils.toString(resEntity);
                JSONObject jsonObject  = JSONObject.parseObject(msg);
                token  =jsonObject.get("access_token").toString();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(httpClient!=null){
                    httpClient.close();
                }
                if (response!=null){
                    response.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return token;

    }


}
