package com.dtxw.entity;

public class Locationtofield {

  private String location;
  private int field;

public Locationtofield(String L,int F)
{
  this.field = F;
  this.location = L;
}
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public int getField() {
    return field;
  }

  public void setField(int field) {
    this.field = field;
  }

}

