package com.reverie.domain;


import javax.persistence.Id;

public class Checkstation {

  @Id
  private Integer checkstationid;
  private String province;
  private String city;
  private String stationname;
  private String phoneNumber;


  public Integer getCheckstationid() {
    return checkstationid;
  }

  public void setCheckstationid(Integer checkstationid) {
    this.checkstationid = checkstationid;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getStationname() {
    return stationname;
  }

  public void setStationname(String stationname) {
    this.stationname = stationname;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
