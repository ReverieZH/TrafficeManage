package com.reverie.domain;

import javax.persistence.Id;

/**
* @Description: 机动车行驶实体类
* @Date:
* @Author:
*/
public class Vehiclelicense {
@Id
  private String vlnumber;                //行驶证编号
  private String plateNumber;             //号牌号码
  private String carType;                 //车辆类型
  private String owner;                   //所有人
  private String address;                 //住址
  private String brandModel;              //品牌模型
  private String vin;                     //VIN号
  private String engineNumber;            //发动机号码
  private java.util.Date registationDate;  //注册日期
  private java.util.Date issueDate;         //发证日期
  private String status;                   //状态

  public String getVlnumber() {
    return vlnumber;
  }

  public void setVlnumber(String vlnumber) {
    this.vlnumber = vlnumber;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getBrandModel() {
    return brandModel;
  }

  public void setBrandModel(String brandModel) {
    this.brandModel = brandModel;
  }


  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }


  public String getEngineNumber() {
    return engineNumber;
  }

  public void setEngineNumber(String engineNumber) {
    this.engineNumber = engineNumber;
  }


  public java.util.Date getRegistationDate() {
    return registationDate;
  }

  public void setRegistationDate(java.util.Date registationDate) {
    this.registationDate = registationDate;
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
    return "Vehiclelicense{" +
            "vlnumber='" + vlnumber + '\'' +
            ", plateNumber='" + plateNumber + '\'' +
            ", carType='" + carType + '\'' +
            ", owner='" + owner + '\'' +
            ", address='" + address + '\'' +
            ", brandModel='" + brandModel + '\'' +
            ", vin='" + vin + '\'' +
            ", engineNumber='" + engineNumber + '\'' +
            ", registationDate=" + registationDate +
            ", issueDate=" + issueDate +
            '}';
  }
}
