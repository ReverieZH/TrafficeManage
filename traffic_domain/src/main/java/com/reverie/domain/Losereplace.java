package com.reverie.domain;

import javax.persistence.Id;
import java.util.Date;

/**
* @Description: 驾驶证遗失补证实体类
* @Date:
* @Author:
*/
public class Losereplace {
  @Id
  private String loseReplaceNumber;                //预约编号
  private String dlNumber;                      //驾驶证编号
  private String accessMethod;                     //领取方式
  private String receiverName;                  //收件人姓名
  private String phoneNumber;                    //联系电话
  private String address;                        //收件地址
  private String postCode;                       //邮寄费
  private String payStatus;                      //支付状态
  private String username;                       //用户名
  private java.util.Date applyDate;               //申请日期
  private String status;                         //状态
  private String area;

  public String getLoseReplaceNumber() {
    return loseReplaceNumber;
  }

  public void setLoseReplaceNumber(String loseReplaceNumber) {
    this.loseReplaceNumber = loseReplaceNumber;
  }

  public String getDlNumber() {
    return dlNumber;
  }

  public void setDlNumber(String dlNumber) {
    this.dlNumber = dlNumber;
  }

  public String getAccessMethod() {
    return accessMethod;
  }

  public void setAccessMethod(String accessMethod) {
    this.accessMethod = accessMethod;
  }

  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(String payStatus) {
    this.payStatus = payStatus;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(Date applyDate) {
    this.applyDate = applyDate;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
