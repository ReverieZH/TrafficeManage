package com.reverie.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
* @Description: 选好申请实体类
* @Date:
* @Author:
*/
public class Platenumberapply {

  @Id
  private String applyNumber;                //申请编号
  private String carType;                    //车辆类型
  private String vehicleProof;               //机动车凭证
  private String certificateNumber;          //合格证号
  private String brandModel;                 //品牌型号
  private String vin;                        //VIN
  private String optionalPlateHead;          //可选号牌头
  private String phoneNumber;                //电话号码
  private String username;                   //用户名
  private String owner;                      //拥有者
  private String status;                     //状态


  public String getApplyNumber() {
    return applyNumber;
  }

  public void setApplyNumber(String applyNumber) {
    this.applyNumber = applyNumber;
  }


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }




  public String getVehicleProof() {
    return vehicleProof;
  }

  public void setVehicleProof(String vehicleProof) {
    this.vehicleProof = vehicleProof;
  }


  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber;
  }


  public String getBrandModel() {
    return brandModel;
  }

  public void setBrandModel(String brandModel) {
    this.brandModel = brandModel;
  }


  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }


  public String getOptionalPlateHead() {
    return optionalPlateHead;
  }

  public void setOptionalPlateHead(String optionalPlateHead) {
    this.optionalPlateHead = optionalPlateHead;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Platenumberapply{" +
            "applyNumber='" + applyNumber + '\'' +
            ", carType='" + carType + '\'' +
            ", vehicleProof='" + vehicleProof + '\'' +
            ", certificateNumber='" + certificateNumber + '\'' +
            ", brandModel='" + brandModel + '\'' +
            ", vin='" + vin + '\'' +
            ", optionalPlateHead='" + optionalPlateHead + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", username='" + username + '\'' +
            ", owner='" + owner + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
