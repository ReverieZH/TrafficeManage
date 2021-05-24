package com.reverie.domain;

/** 
* @Description: 违法附件实体类 
* @Date:  
* @Author:
*/ 
public class Offenceaccessory {

  private String accessoryNumber;
  private String accessoryName;
  private String accessoryFileName;
  private String trafficoffenceNumber;


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


  public String getTrafficoffenceNumber() {
    return trafficoffenceNumber;
  }

  public void setTrafficoffenceNumber(String trafficoffenceNumber) {
    this.trafficoffenceNumber = trafficoffenceNumber;
  }


  @Override
  public String toString() {
    return "Offenceaccessory{" +
            "accessoryNumber='" + accessoryNumber + '\'' +
            ", accessoryName='" + accessoryName + '\'' +
            ", accessoryFileName='" + accessoryFileName + '\'' +
            ", trafficoffenceNumber='" + trafficoffenceNumber + '\'' +
            '}';
  }
}
