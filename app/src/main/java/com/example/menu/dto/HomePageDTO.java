package com.example.menu.dto;

import java.util.ArrayList;
import java.util.List;

/**将主页内容从上自下形成一个对象*/
public class HomePageDTO {
    private List<String> headList =  new ArrayList<>();
    /**24h天气*/
    private List<WeatherHourDTO.HourlyDTO> hourlyDTOList = new ArrayList<>();
    /**七日天气*/
    private List<WeatherSevenDTO.DailyDTO> dailyDTOList = new ArrayList<>();
    /**其他模块信息*/


    /**暂时只用一个参数构造*/
    public HomePageDTO(List<String> headList) {
        this.headList = headList;
//        this.hourlyDTOList = hourlyDTOList;
//        this.dailyDTOList = dailyDTOList;
    }

    public List<String> getHeadList() {
        return headList;
    }

    public void setHeadList(List<String> headList) {
        this.headList = headList;
    }

    public List<WeatherHourDTO.HourlyDTO> getHourlyDTOList() {
        return hourlyDTOList;
    }

    public void setHourlyDTOList(List<WeatherHourDTO.HourlyDTO> hourlyDTOList) {
        this.hourlyDTOList = hourlyDTOList;
    }

    public List<WeatherSevenDTO.DailyDTO> getDailyDTOList() {
        return dailyDTOList;
    }

    public void setDailyDTOList(List<WeatherSevenDTO.DailyDTO> dailyDTOList) {
        this.dailyDTOList = dailyDTOList;
    }
}
