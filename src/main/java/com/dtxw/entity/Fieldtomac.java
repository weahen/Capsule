package com.dtxw.entity;


public class Fieldtomac {

  private String mac;
  private int field;

public Fieldtomac(String Mac,int Field)
{
  this.mac=Mac;
  this.field = Field;
}

  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }


  public int getField() {
    return field;
  }

  public void setField(int field) {
    this.field = field;
  }

}


