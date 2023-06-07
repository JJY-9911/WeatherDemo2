package com.example.menu.holder;

import com.example.menu.item.HourlyItem;

import java.util.List;

public class HourlyHolder {
    private static List<HourlyItem> hourlyList;

    public static void setHourlyList(List<HourlyItem> hourlyList){
        HourlyHolder.hourlyList = hourlyList;
    }

    public static List<HourlyItem> getHourlyList(){
        return hourlyList;
    }
}
