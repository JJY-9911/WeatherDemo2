package com.example.menu.item;


/**联想搜索时展示的列表，只有城市名*/
public class SearchListItem {
    private String name;

    public SearchListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
