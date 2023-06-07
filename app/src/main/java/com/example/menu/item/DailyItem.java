package com.example.menu.item;

public class DailyItem {
    String date;
    String tempMax;
    String tempMin;
    String textDay;

    public DailyItem(String date, String tempMax, String tempMin, String textDay) {
        this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }
}
