package com.reverie.domain;

import javax.persistence.Id;
import java.sql.Date;

/**
* @Description: 交通违章实体类
* @Date:
* @Author:
*/
public class Trafficoffence {
  @Id
  private String trafficOffenceNumber;              //违法编号
  private java.util.Date trafficOffenceDate;         //违法时间
  private String trafficOffencePlace;               //违法地点
  private String trafficOffenceAct;                 //违法行为
  private Integer score;                            //记分值
  private Integer money;                            //罚金金额
  private java.util.Date payDate;                    //缴纳罚款日期
  private String dlNumber;                           //驾驶证号
  private String plateNumber;                        //车牌号码
  private String punishOffice;                        //处罚机关
  private String status;                             //状态
  private String needWindow;                         //是否需要窗口办理

  public String getTrafficOffenceNumber() {
    return trafficOffenceNumber;
  }

  public void setTrafficOffenceNumber(String trafficOffenceNumber) {
    this.trafficOffenceNumber = trafficOffenceNumber;
  }

  public  java.util.Date getTrafficOffenceDate() {
    return trafficOffenceDate;
  }

  public void setTrafficOffenceDate( java.util.Date trafficOffenceDate) {
    this.trafficOffenceDate = trafficOffenceDate;
  }

  public String getTrafficOffencePlace() {
    return trafficOffencePlace;
  }

  public void setTrafficOffencePlace(String trafficOffencePlace) {
    this.trafficOffencePlace = trafficOffencePlace;
  }

  public String getTrafficOffenceAct() {
    return trafficOffenceAct;
  }

  public void setTrafficOffenceAct(String trafficOffenceAct) {
    this.trafficOffenceAct = trafficOffenceAct;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }


  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }


  public java.util.Date getPayDate() {
    return payDate;
  }

  public void setPayDate(java.util.Date payDate) {
    this.payDate = payDate;
  }


  public String getDlNumber() {
    return dlNumber;
  }

  public void setDlNumber(String dlNumber) {
    this.dlNumber = dlNumber;
  }


  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPunishOffice() {
    return punishOffice;
  }

  public void setPunishOffice(String punishOffice) {
    this.punishOffice = punishOffice;
  }

  public String getNeedWindow() {
    return needWindow;
  }

  public void setNeedWindow(String needWindow) {
    this.needWindow = needWindow;
  }

  @Override
  public String toString() {
    return "Trafficoffence{" +
            "trafficOffenceNumber='" + trafficOffenceNumber + '\'' +
            ", trafficOffenceDate=" + trafficOffenceDate +
            ", trafficOffencePlace='" + trafficOffencePlace + '\'' +
            ", trafficOffenceAct='" + trafficOffenceAct + '\'' +
            ", score=" + score +
            ", money=" + money +
            ", payDate=" + payDate +
            ", dlNumber='" + dlNumber + '\'' +
            ", plateNumber='" + plateNumber + '\'' +
            ", needWindow='" + needWindow + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
