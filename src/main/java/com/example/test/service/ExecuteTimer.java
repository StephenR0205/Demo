package com.example.test.service;

import com.alibaba.fastjson.*;
import com.example.test.bean.Weatherinfo;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.lang.String;


@Service
public class ExecuteTimer {

    String msg1 ="";
    String pre = "";
    public void executeTimer1(){
        System.out.println("执行前："+msg1);
        String str = cx();
        String msg = jg(str);
        String token = GetToken.token();
        System.out.println("~~~~~~~~~~msg:"+msg);
        try{
            if("".equals(msg)){
                if(msg.equals(msg1)){
                    return;
                }else {
                    String msg2 = getjcmsg(pre);
                    fsJC(msg2,token);
                    msg1=msg;
                    pre="";
                }
            }else {
                if(msg.equals(msg1)){
                    return;
                }else {
                    fs(msg,token);
                    msg1 =msg;
                    pre=str;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       finally {
            System.out.println("执行完毕msg1："+msg1+
                    "\npre："+pre);
        }


    }


    public String jg(String msg){
        String[] arr1 = msg.split("=");
        System.out.println("arr1:" + Arrays.toString(arr1));

        String[] arr2 = arr1[2].split(";");
        System.out.println("arr2:" + Arrays.toString(arr2));
        String v = arr2[0];
        String str = getmsg(v);
        return str;
    }

    public void fs(String text, String token) {
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s", token); //wechat  address
        //  String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=EcTcC1_dr_A4fE5utawfjSTDc5E37Pryd3EekcMyt0WrekEGhLx8UbyYQCnruz1cU9q07poVOVNK6ivaaFmZ7AL-oh7foV1LqqNhrlWUN-xztHPVAxLZSy0R5_jzLmu68hOFApuWYDxLL6YcSL-vIQWmcwN-d3uOHD-mlZJv1smu8Bu2kE_CgWvsAuXyiB59uOyw_C7DGS3BB-fMizh9ng";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();// create http  object

        System.out.println("String url :" + url);
        HttpPost httpPost = new HttpPost(url); // create Post request
        httpPost.setHeader("Content-Type", "text/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapson = new HashMap<>();
        mapson.put("content", text);
        map.put("text", mapson);
        map.put("msgtype", "text");
        map.put("touser", "RongHaoNan");
        map.put("agentid", "1000036");
        JSONObject jsonMap = new JSONObject(map);
        System.out.println("jsonMap:" + jsonMap);

        StringEntity entity = new StringEntity(String.valueOf(jsonMap), Charset.forName("UTF-8"));
        httpPost.setEntity(entity);


        //
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void fsJC(String text, String token) {
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s", token); //wechat  address
        //  String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=EcTcC1_dr_A4fE5utawfjSTDc5E37Pryd3EekcMyt0WrekEGhLx8UbyYQCnruz1cU9q07poVOVNK6ivaaFmZ7AL-oh7foV1LqqNhrlWUN-xztHPVAxLZSy0R5_jzLmu68hOFApuWYDxLL6YcSL-vIQWmcwN-d3uOHD-mlZJv1smu8Bu2kE_CgWvsAuXyiB59uOyw_C7DGS3BB-fMizh9ng";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();// create http  object

        System.out.println("String url :" + url);
        HttpPost httpPost = new HttpPost(url); // create Post request
        httpPost.setHeader("Content-Type", "text/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapson = new HashMap<>();
        mapson.put("content", text);
        map.put("text", mapson);
        map.put("msgtype", "text");
        map.put("touser", "RongHaoNan");
        map.put("agentid", "1000036");
        JSONObject jsonMap = new JSONObject(map);
        System.out.println("jsonMap:" + jsonMap);

        StringEntity entity = new StringEntity(String.valueOf(jsonMap), Charset.forName("UTF-8"));
        httpPost.setEntity(entity);


        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String cx() {
        String tq = null;
        String url = "http://d1.weather.com.cn/dingzhi/101180801.html";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Referer", "d1.weather.com.cn");
        httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
        ;
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String msg = EntityUtils.toString(responseEntity);
                System.out.println("--------------------------------------");

                String str = new String(msg.getBytes("ISO-8859-1"), "UTF-8");

                System.out.println("str:" + str);
                tq = str;

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tq;
    }

    private String getmsg(String msg) {
        JSONObject jsonObject = JSONObject.parseObject(msg.trim());

        JSONArray arr = JSON.parseObject(String.valueOf(jsonObject)).getJSONArray("w");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            JSONObject k = arr.getJSONObject(i);

            String val = k.getString("w9");

            list.add(val);
        }
        Weatherinfo weatherinfo = new Weatherinfo();
        if (list.size() > 1) {
            String w9 = String.join("", list.get(0));
            weatherinfo.setW9("w9", w9);
        } else {
            String w9 = String.join("", list);
            weatherinfo.setW9("w9", w9);
        }
        System.out.println("========================");
        System.out.println(weatherinfo);
        return weatherinfo.toString();
    }

    private String getjcmsg(String msg) {


        String jc = null;
        JSONObject result = new JSONObject();

        System.out.println("--------------------------------------");

        String str = null;

        System.out.println("str:" + str);
        String[] arr1 = msg.split("=");
        System.out.println("arr1:" + Arrays.toString(arr1));

        String[] arr2 = arr1[2].split(";");
        System.out.println("arr2:" + Arrays.toString(arr2));
        String v = arr2[0];
        System.out.println("v:" + v);
        JSONObject jsonObject = JSONObject.parseObject(v);
        JSONArray arr = JSON.parseObject(String.valueOf(jsonObject)).getJSONArray("w");

        for (int i = 0; i < arr.size(); i++) {
            JSONObject k = arr.getJSONObject(i);
            result.put("xhjb", k.get("w7"));
            result.put("xhlx", k.get("w5"));
        }
        Calendar cal = Calendar.getInstance();
        String date = cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DATE)+"日"+cal.get(Calendar.HOUR_OF_DAY)+"时"
                +cal.get(Calendar.MINUTE)+"分";
        jc = "【解除"+result.get("xhlx")+result.get("xhjb")+"预警信号】目前，市气象台"+date+
                "解除"+result.get("xhlx")+result.get("xhjb")+"预警信号。";

        return jc;
    }
}
