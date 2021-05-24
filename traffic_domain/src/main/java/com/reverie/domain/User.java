package com.reverie.domain;

import javax.persistence.Id;

/**
* @Description: 用户实体类
* @Date:
* @Author:
*/
public class User {
  @Id
  private String username;             //用户名
  private String password;             //密码
  private String certificatetype;      //驾驶证类型
  private String certificatenumber;    //驾驶证号码
  private String phonenumber;           //电话号码
  private String valid;                 //有效性
  private String type;                  //类型

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getCertificatetype() {
    return certificatetype;
  }

  public void setCertificatetype(String certificatetype) {
    this.certificatetype = certificatetype;
  }


  public String getCertificatenumber() {
    return certificatenumber;
  }

  public void setCertificatenumber(String certificatenumber) {
    this.certificatenumber = certificatenumber;
  }


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


  public String getValid() {
    return valid;
  }

  public void setValid(String valid) {
    this.valid = valid;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", certificatetype='" + certificatetype + '\'' +
            ", certificatenumber='" + certificatenumber + '\'' +
            ", phonenumber='" + phonenumber + '\'' +
            ", valid='" + valid + '\'' +
            '}';
  }
}
