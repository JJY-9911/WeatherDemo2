package com.example.menu.item;



/**城市管理方块，有城市名和天气*/
public class CityManagerItem {
    private String cityName;
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**这个构造方法后续要添加天气*/

    public CityManagerItem(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
