package com.reverie.domain;

import javax.persistence.Id;

//号码实体类
public class Platenumber {
  @Id
  private String plateNumber;             //号码
  private java.util.Date issueDate;        //投放日期
  private String status;                  //状态
  private String locationName;
  private String province;
  private String city;
  private String plateHead;

  public String getPlateHead() {
    return plateHead;
  }

  public void setPlateHead(String plateHead) {
    this.plateHead = plateHead;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
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

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public java.util.Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(java.util.Date issueDate) {
    this.issueDate = issueDate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Platenumber{" +
            "plateNumber='" + plateNumber + '\'' +
            ", issueDate=" + issueDate +
            ", status='" + status + '\'' +
            '}';
  }
}
