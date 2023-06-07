package com.example.menu.item;

public class HourlyItem {
    public String hour;
    public String temp;

    public HourlyItem(String hour, String temp) {
        this.hour = hour;
        this.temp = temp;
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
