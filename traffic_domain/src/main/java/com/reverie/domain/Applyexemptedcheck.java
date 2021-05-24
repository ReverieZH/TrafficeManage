package com.reverie.domain;


import javax.persistence.Id;
import javax.persistence.Table;

/**
* @Description: 申请免检
* @Date:  
* @Author:
*/
@Table(name = "applyexemptedcheck")
public class Applyexemptedcheck {
  @Id
  private String acNumber;                 //申领编号
  private String plateNumber;              //号牌号码
  private String insurancePhoto;           //交强险凭证照片
  private String taxPhoto;                 //车船税凭证照片
  private java.util.Date endDate;           //检验有效期止
  private String isNeedPaper;              //是否需要纸质凭证
  private String accessMethod;                //获取方式
  private String receiverName;             //收件人姓名
  private String phoneNumber;              //联系电话
  private String address;                  //收件地址
  private String postCode;                 //邮寄费
  private String paystatus;                //支付状态
  private String username;                 //用户名
  private java.util.Date applyDate;         //申请日期
  private String status;                   //用户名
  private String area;

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getAcNumber() {
    return acNumber;
  }

  public void setAcNumber(String acNumber) {
    this.acNumber = acNumber;
  }


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  public String getInsurancePhoto() {
    return insurancePhoto;
  }

  public void setInsurancePhoto(String insurancePhoto) {
    this.insurancePhoto = insurancePhoto;
  }

  public String getTaxPhoto() {
    return taxPhoto;
  }

  public void setTaxPhoto(String taxPhoto) {
    this.taxPhoto = taxPhoto;
  }


  public java.util.Date getEndDate() {
    return endDate;
  }

  public void setEndDate(java.util.Date endDate) {
    this.endDate = endDate;
  }


  public String getIsNeedPaper() {
    return isNeedPaper;
  }

  public void setIsNeedPaper(String isNeedPaper) {
    this.isNeedPaper = isNeedPaper;
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

  public String getPaystatus() {
    return paystatus;
  }

  public void setPaystatus(String paystatus) {
    this.paystatus = paystatus;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public java.util.Date getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(java.util.Date applyDate) {
    this.applyDate = applyDate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Applycheck{" +
            "acNumber='" + acNumber + '\'' +
            ", plateNumber='" + plateNumber + '\'' +
            ", insurancePhoto='" + insurancePhoto + '\'' +
            ", taxPhoto='" + taxPhoto + '\'' +
            ", endDate=" + endDate +
            ", isNeedPaper='" + isNeedPaper + '\'' +
            ", accessMethod='" + accessMethod + '\'' +
            ", receiverName='" + receiverName + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", address='" + address + '\'' +
            ", postCode=" + postCode +
            ", paystatus='" + paystatus + '\'' +
            ", username='" + username + '\'' +
            ", applyDate=" + applyDate +
            ", status='" + status + '\'' +
            '}';
  }
}
