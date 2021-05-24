package com.reverie.domain;

/**
* @Description: 车辆附件表
* @Date:
* @Author:
*/
public class Caraccessory {

  private String accessoryNumber;     //附件编号
  private String accessoryName;       //附件名称
  private String accessoryFileName;   //附件文件名
  private String carAccessorycol;     //
  private String plateNumber;          //车牌号码


  public String getAccessoryNumber() {
    return accessoryNumber;
  }

  public void setAccessoryNumber(String accessoryNumber) {
    this.accessoryNumber = accessoryNumber;
  }


  public String getAccessoryName() {
    return accessoryName;
  }

  public void setAccessoryName(String accessoryName) {
    this.accessoryName = accessoryName;
  }


  public String getAccessoryFileName() {
    return accessoryFileName;
  }

  public void setAccessoryFileName(String accessoryFileName) {
    this.accessoryFileName = accessoryFileName;
  }


  public String getCarAccessorycol() {
    return carAccessorycol;
  }

  public void setCarAccessorycol(String carAccessorycol) {
    this.carAccessorycol = carAccessorycol;
  }


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  @Override
  public String toString() {
    return "Caraccessory{" +
            "accessoryNumber='" + accessoryNumber + '\'' +
            ", accessoryName='" + accessoryName + '\'' +
            ", accessoryFileName='" + accessoryFileName + '\'' +
            ", carAccessorycol='" + carAccessorycol + '\'' +
            ", plateNumber='" + plateNumber + '\'' +
            '}';
  }
}
