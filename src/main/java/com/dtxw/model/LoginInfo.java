package com.dtxw.model;


public class LoginInfo {

    private String ID;
    private String PSW;
    private String FIELD;

    public String getFIELD() {
        return FIELD;
    }

    public void setFIELD(String FIELD) {
        this.FIELD = FIELD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPSW() {
        return PSW;
    }

    public void setPSW(String PSW) {
        this.PSW = PSW;
    }

    public LoginInfo() {
    }
}
