package com.reverie.domain;


import javax.persistence.Id;

public class Uservehcile {

  @Id
  private String plateNumber;
  private String username;


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
