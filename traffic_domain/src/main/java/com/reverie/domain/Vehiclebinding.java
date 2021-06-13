package com.reverie.domain;


import java.util.Date;

/**
* @Description: 车辆绑定实体类
* @Date:
* @Author:
*/
public class Vehiclebinding {

  private String vbNumber;              //绑定编号
  private String username;              //用户名
  private String plateNumber;           //号牌号码
  private java.util.Date bindingate;    //绑定日期
  private String auditResult;           //审核结果
  private String status;                //状态
  private String vaild;                 //有效性

  public String getVbNumber() {
    return vbNumber;
  }

  public void setVbNumber(String vbNumber) {
    this.vbNumber = vbNumber;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  public Date getBindingate() {
    return bindingate;
  }

  public void setBindingate(Date bindingate) {
    this.bindingate = bindingate;
  }

  public String getAuditResult() {
    return auditResult;
  }

  public void setAuditResult(String auditResult) {
    this.auditResult = auditResult;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getVaild() {
    return vaild;
  }

  public void setVaild(String vaild) {
    this.vaild = vaild;
  }
}
