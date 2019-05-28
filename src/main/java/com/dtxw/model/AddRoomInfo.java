package com.dtxw.model;

public class AddRoomInfo {
    private String name;
    private String field;
    private String s_time;
    private String e_time;
    private String location;
    private int RESERVE;

    public int getRESERVE() {
        return RESERVE;
    }

    public void setRESERVE(int RESERVE) {
        this.RESERVE = RESERVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
