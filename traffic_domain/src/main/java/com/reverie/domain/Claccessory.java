package com.reverie.domain;

/** 
* @Description: 驾驶证换证附件表 
* @Date:  
* @Author:
*/ 
public class Claccessory {

  private String accessoryNumber;
  private String accessoryName;
  private String accessoryFileName;
  private String changeNumber;


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


  public String getChangeNumber() {
    return changeNumber;
  }

  public void setChangeNumber(String changeNumber) {
    this.changeNumber = changeNumber;
  }


  @Override
  public String toString() {
    return "Claccessory{" +
            "accessoryNumber='" + accessoryNumber + '\'' +
            ", accessoryName='" + accessoryName + '\'' +
            ", accessoryFileName='" + accessoryFileName + '\'' +
            ", changeNumber='" + changeNumber + '\'' +
            '}';
  }
}
