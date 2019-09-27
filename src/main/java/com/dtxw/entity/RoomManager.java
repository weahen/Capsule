package com.dtxw.entity;


public class RoomManager {

  private long id;
  private String name;
  private String password;
  private String description;
  private String email;
  private String ACCESSFIELD;

  public String getACCESSFIELD() {
    return ACCESSFIELD;
  }

  public void setACCESSFIELD(String ACCESSFIELD) {
    this.ACCESSFIELD = ACCESSFIELD;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "RoomManager{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", description='" + description + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
