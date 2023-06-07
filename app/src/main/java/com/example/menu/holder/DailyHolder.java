package com.example.menu.holder;

import com.example.menu.item.DailyItem;

import java.util.ArrayList;
import java.util.List;

public class DailyHolder {
    private static List<DailyItem> dailyList;

    public static void setDailyList(List<DailyItem> dailyList){
        DailyHolder.dailyList = dailyList;
    }

    public static List<DailyItem> getDailyList(){return dailyList;}
}
