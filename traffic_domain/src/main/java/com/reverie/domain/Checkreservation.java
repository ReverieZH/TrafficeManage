package com.reverie.domain;

import javax.persistence.Id;
import java.util.Date;

/**
* @Description: 检验预约实体类
* @Date:
* @Author:
*/
public class Checkreservation {
  @Id
  private String reserveNumber;           //预约号码
  private String plateNumber;             //车牌号码
  private String owner;                   //所有人
  private String carType;                 //车辆类型
  private String drivingType;              //驱动方式
  private String fuelType;                //燃油类型
  private String checkStation;            //监测站
  private java.util.Date checkDate;        //预约检测日期
  private String startTime;        //预约时段开始时间
  private String endTime;          //预约时段结束时间
  private String username;                //用户名
  private java.util.Date reserveDate;      //预约日期
  private String status;                  //状态


  public String getReserveNumber() {
    return reserveNumber;
  }

  public void setReserveNumber(String reserveNumber) {
    this.reserveNumber = reserveNumber;
  }


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }


  public String getDrivingType() {
    return drivingType;
  }

  public void setDrivingType(String drivingType) {
    this.drivingType = drivingType;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }


  public String getCheckStation() {
    return checkStation;
  }

  public void setCheckStation(String checkStation) {
    this.checkStation = checkStation;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(Date checkDate) {
    this.checkDate = checkDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Date getReserveDate() {
    return reserveDate;
  }

  public void setReserveDate(Date reserveDate) {
    this.reserveDate = reserveDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Checkreservation{" +
            "reserveNumber='" + reserveNumber + '\'' +
            ", plateNumber='" + plateNumber + '\'' +
            ", owner='" + owner + '\'' +
            ", carType='" + carType + '\'' +
            ", drivingType='" + drivingType + '\'' +
            ", fuelType='" + fuelType + '\'' +
            ", checkStation='" + checkStation + '\'' +
            ", checkDate=" + checkDate +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", username='" + username + '\'' +
            ", reserveDate=" + reserveDate +
            ", status='" + status + '\'' +
            '}';
  }
}
