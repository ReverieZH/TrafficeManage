package com.reverie.domain;


import javax.persistence.Id;

public class Applyednumber {
  @Id
  private String applyednumberid;
  private String username;
  private String plateNumberHead;
  private String platenumber;
  private String locationName;
  private String applyNumber;
  public String getApplyednumberid() {
    return applyednumberid;
  }

  public void setApplyednumberid(String applyednumberid) {
    this.applyednumberid = applyednumberid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPlateNumberHead() {
    return plateNumberHead;
  }

  public void setPlateNumberHead(String plateNumberHead) {
    this.plateNumberHead = plateNumberHead;
  }


  public String getPlatenumber() {
    return platenumber;
  }

  public void setPlatenumber(String platenumber) {
    this.platenumber = platenumber;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getApplyNumber() {
    return applyNumber;
  }

  public void setApplyNumber(String applyNumber) {
    this.applyNumber = applyNumber;
  }

  @Override
  public String toString() {
    return "Applyednumber{" +
            "applyednumberid='" + applyednumberid + '\'' +
            ", username='" + username + '\'' +
            ", plateNumberHead='" + plateNumberHead + '\'' +
            ", platenumber='" + platenumber + '\'' +
            '}';
  }
}
