package com.example.menu.dto;

public class HourlyItem {
    public String time;
    public String temp;

    public HourlyItem(String time, String temp) {
        this.time = time;
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
