package com.example.menu.item;

public class HourlyItem {
    public String hour;
    public String temp;
    public String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HourlyItem(String hour, String temp,String text) {
        this.hour = hour;
        this.temp = temp;
        this.text = text;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
