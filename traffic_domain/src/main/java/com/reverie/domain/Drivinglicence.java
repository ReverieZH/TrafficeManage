package com.reverie.domain;

import javax.persistence.Id;
import java.util.Date;

/**
* @Description: 驾驶证实体类
* @Date:
* @Author:
*/
public class Drivinglicence {
  @Id
  private String dlnumber;          //驾驶证号
  private String name;              //姓名
  private String sex;               //性别
  private String nationality;       //国籍
  private String address;           //住址
  private java.util.Date birth;      //出生日期
  private java.util.Date firstDate;  //初次领证日期
  private String vehicleType;       //准驾车型
  private java.util.Date startDate;   //有效期开始日期
  private java.util.Date endDate;    //有效期结束日期
  private String authority;         //发证机关
  private Integer score;            //记分
  private String username;          //用户名
  private String status;            //状态

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDlnumber() {
    return dlnumber;
  }

  public void setDlnumber(String dlnumber) {
    this.dlnumber = dlnumber;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public java.util.Date getBirth() {
    return birth;
  }

  public void setBirth(java.util.Date birth) {
    this.birth = birth;
  }


  public java.util.Date getFirstDate() {
    return firstDate;
  }

  public void setFirstDate(java.util.Date firstDate) {
    this.firstDate = firstDate;
  }


  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }


  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public java.util.Date getEndDate() {
    return endDate;
  }

  public void setEndDate(java.util.Date endDate) {
    this.endDate = endDate;
  }


  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }


  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Drivinglicence{" +
            "dlnumber='" + dlnumber + '\'' +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", nationality='" + nationality + '\'' +
            ", address='" + address + '\'' +
            ", birth=" + birth +
            ", firstDate=" + firstDate +
            ", vehicleType='" + vehicleType + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", authority='" + authority + '\'' +
            ", score=" + score +
            ", username='" + username + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
