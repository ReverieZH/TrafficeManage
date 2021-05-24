package com.reverie.domain;


/**
* @Description: 驾驶证换证实体类
* @Date:
* @Author:
*/
public class Changelicence {

  private String changeNumber;         //换证编号
  private String dlnumber;            //驾驶证编号
  private java.sql.Date changeDate;    //换证日期
  private java.sql.Date startDate;     //有效期开始日期
  private java.sql.Date endDate;       //有效期结束日期
  private String remark;               //备注
  private String jobnumber;            //经办人工号


  public String getChangeNumber() {
    return changeNumber;
  }

  public void setChangeNumber(String changeNumber) {
    this.changeNumber = changeNumber;
  }


  public String getDlnumber() {
    return dlnumber;
  }

  public void setDlnumber(String dlnumber) {
    this.dlnumber = dlnumber;
  }


  public java.sql.Date getChangeDate() {
    return changeDate;
  }

  public void setChangeDate(java.sql.Date changeDate) {
    this.changeDate = changeDate;
  }


  public java.sql.Date getStartDate() {
    return startDate;
  }

  public void setStartDate(java.sql.Date startDate) {
    this.startDate = startDate;
  }


  public java.sql.Date getEndDate() {
    return endDate;
  }

  public void setEndDate(java.sql.Date endDate) {
    this.endDate = endDate;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getJobnumber() {
    return jobnumber;
  }

  public void setJobnumber(String jobnumber) {
    this.jobnumber = jobnumber;
  }

  @Override
  public String toString() {
    return "Changelicence{" +
            "changeNumber='" + changeNumber + '\'' +
            ", dlnumber='" + dlnumber + '\'' +
            ", changeDate=" + changeDate +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", remark='" + remark + '\'' +
            ", jobnumber='" + jobnumber + '\'' +
            '}';
  }
}
