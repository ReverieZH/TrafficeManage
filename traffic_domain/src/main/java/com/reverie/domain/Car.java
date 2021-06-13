package com.reverie.domain;


import javax.persistence.Id;
import java.util.Date;

/**
* @Description: 车辆实体类
* @Date:
* @Author:
*/
public class Car {
  @Id
  private String plateNumber;   //车牌号码
  private String color;         // 颜色
  private String carType;       //车辆类型
  private String factoryPlateModel;  //
  private java.util.Date produceDate;   //生产日期
  private String producePlace;         //生产地点
  private String vin;                  //vin号码
  private String engineNumber;         //引擎号码
  private String status;              //状态
  private String registrant;          //登记人
  private String certificateNumber;          //登记人
  private java.util.Date registationDate;   //登记日期


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }


  public String getFactoryPlateModel() {
    return factoryPlateModel;
  }

  public void setFactoryPlateModel(String factoryPlateModel) {
    this.factoryPlateModel = factoryPlateModel;
  }

  public java.util.Date getProduceDate() {
    return produceDate;
  }

  public void setProduceDate(java.util.Date produceDate) {
    this.produceDate = produceDate;
  }

  public String getProducePlace() {
    return producePlace;
  }

  public void setProducePlace(String producePlace) {
    this.producePlace = producePlace;
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


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getRegistrant() {
    return registrant;
  }

  public void setRegistrant(String registrant) {
    this.registrant = registrant;
  }


  public java.util.Date getRegistationDate() {
    return registationDate;
  }

  public void setRegistationDate(java.util.Date registationDate) {
    this.registationDate = registationDate;
  }


  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
  }

  @Override
  public String toString() {
    return "Car{" +
            "plateNumber='" + plateNumber + '\'' +
            ", color='" + color + '\'' +
            ", carType='" + carType + '\'' +
            ", factoryPlateModel='" + factoryPlateModel + '\'' +
            ", produceDate=" + produceDate +
            ", producePlace='" + producePlace + '\'' +
            ", vin='" + vin + '\'' +
            ", engineNumber='" + engineNumber + '\'' +
            ", status='" + status + '\'' +
            ", registrant='" + registrant + '\'' +
            ", registationDate=" + registationDate +
            '}';
  }
}
