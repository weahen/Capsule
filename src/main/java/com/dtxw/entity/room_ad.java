package com.dtxw.entity;

public class room_ad {
    private String path;
    private String title;
    private String pic_name;
    private String describe;

    public room_ad(String path, String title, String pic_name, String describe) {
        this.path = path;
        this.title = title;
        this.pic_name = pic_name;
        this.describe = describe;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
