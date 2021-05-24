package com.reverie.domain;


import javax.persistence.Id;

public class Drivinglicencebinding {

  private String username;
  @Id
  private String dlnumber;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getDlnumber() {
    return dlnumber;
  }

  public void setDlnumber(String dlnumber) {
    this.dlnumber = dlnumber;
  }

}
