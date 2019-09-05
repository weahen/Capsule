package com.dtxw.entity;


import com.dtxw.model.AddRoomInfo;

public class room {
    private int ID;
    private String NAME;
    private String PATH;
    private String FIELD;
    private String START_TIME;
    private  String END_TIME;
    private String LOCATION;
    private int RESERVE;

    public room(AddRoomInfo addRoomInfo) {
        this.NAME = addRoomInfo.getName();
        this.FIELD = addRoomInfo.getField();
        this.START_TIME = addRoomInfo.getS_time();
        this.END_TIME = addRoomInfo.getE_time();
        int a = NAME.hashCode();
        this.PATH = "/"+a;
        this.LOCATION = addRoomInfo.getLocation();
        this.RESERVE = addRoomInfo.getRESERVE();
    }
    public room()
    {

    }

    public room(String NAME, String START_TIME) {
        this.NAME = NAME;
        this.START_TIME = START_TIME;
        this.LOCATION = NAME+"_unit";
        this.PATH = "/";
    }

    public int getRESERVE() {
        return RESERVE;
    }

    public void setRESERVE(int RESERVE) {
        this.RESERVE = RESERVE;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }
    public String getFIELD() {
        return FIELD;
    }

    public void setFIELD(String FIELD) {
        this.FIELD = FIELD;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

}
