package com.dtxw.entity;


public class Reserve {

  private String NAME;
  private long CURRENT_No;
  private long TOTAL_No;
  private int TYPE;
  private String PATH;

  @Override
  public String toString() {
    return "Reserve{" +
            "NAME='" + NAME + '\'' +
            ", CURRENT_No=" + CURRENT_No +
            ", TOTAL_No=" + TOTAL_No +
            ", TYPE=" + TYPE +
            ", PATH='" + PATH + '\'' +
            '}';
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  public long getCURRENT_No() {
    return CURRENT_No;
  }

  public void setCURRENT_No(long CURRENT_No) {
    this.CURRENT_No = CURRENT_No;
  }

  public long getTOTAL_No() {
    return TOTAL_No;
  }

  public void setTOTAL_No(long TOTAL_No) {
    this.TOTAL_No = TOTAL_No;
  }

  public int getTYPE() {
    return TYPE;
  }

  public void setTYPE(int TYPE) {
    this.TYPE = TYPE;
  }

  public String getPATH() {
    return PATH;
  }

  public void setPATH(String PATH) {
    this.PATH = PATH;
  }
}
