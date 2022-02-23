package com.example.test.bean;

import java.util.Date;

public class Weatherinfo {

    private String id;
    private String city_name;
    private String weather_code;
    private String temp_high;
    private String temp_low;
    private String temp_high_low;
    private String temp;
    private String WD;
    private String WS;
    private java.util.Date get_weather_time;
    private String city_id;
    private String parent_city_id;
    private String parent_weather_code;
    private String data_sources;
    private String extend_info;
    private String extend1;
    private java.util.Date extend2;
    private java.util.Date extend3;
    private Integer extend4;
    private Long extend5;
    private String extend6;
    private String YC;
    private String w9;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }

    public String getTemp_high() {
        return temp_high;
    }

    public void setTemp_high(String temp_high) {
        this.temp_high = temp_high;
    }

    public String getTemp_low() {
        return temp_low;
    }

    public void setTemp_low(String temp_low) {
        this.temp_low = temp_low;
    }

    public String getTemp_high_low() {
        return temp_high_low;
    }

    public void setTemp_high_low(String temp_high_low) {
        this.temp_high_low = temp_high_low;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public Date getGet_weather_time() {
        return get_weather_time;
    }

    public void setGet_weather_time(Date get_weather_time) {
        this.get_weather_time = get_weather_time;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getW9() {
        return w9;
    }

    public void setW9(String s, String w9) {
        this.w9 = w9;
    }

    @Override
    public String toString() {
        return  w9 ;
    }
}
