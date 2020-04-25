package com.dtxw.model;

public class modify_to_room_info {
    private int ID;
    private String NAME;
    private String PATH;
    private String FIELD;
    private String START_TIME;
    private  String END_TIME;
    private String LOCATION;
    private int RESERVE;
    private String orign;
    public modify_to_room_info(ModifyRoomInfo modifyRoomInfo) {
        this.NAME = modifyRoomInfo.getName();
        this.FIELD = modifyRoomInfo.getField();
        this.START_TIME =modifyRoomInfo.getS_time();
        this.END_TIME = modifyRoomInfo.getE_time();
        int a = NAME.hashCode();
        this.PATH = "/"+a;
        this.LOCATION = modifyRoomInfo.getLocation();
        this.RESERVE = modifyRoomInfo.getRESERVE();
        this.orign = modifyRoomInfo.getOrign();
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

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public int getRESERVE() {
        return RESERVE;
    }

    public void setRESERVE(int RESERVE) {
        this.RESERVE = RESERVE;
    }

    public String getOrign() {
        return orign;
    }

    public void setOrign(String orign) {
        this.orign = orign;
    }
}
