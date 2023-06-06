package com.example.menu.item;


/**联想搜索时展示的列表，只有城市名*/
public class SearchListItem {
    private String name;
    private String id;

    public SearchListItem(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
