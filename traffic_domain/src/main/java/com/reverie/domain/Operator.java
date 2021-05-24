package com.reverie.domain;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
* @Description: 操作员实体类u
* @Date:
* @Author:
*/
public class Operator {
  @Id
  private String jobnumber;    //工号
  private String password;      //密码
  private Integer rid;          //角色
  @Transient
  private Role role;
  private String name;          //姓名
  private String sex;           //性别
  private String department;    //部门
  private String vaild;         //有效性


  public String getJobnumber() {
    return jobnumber;
  }

  public void setJobnumber(String jobnumber) {
    this.jobnumber = jobnumber;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
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


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  public String getVaild() {
    return vaild;
  }

  public void setVaild(String vaild) {
    this.vaild = vaild;
  }

  @Override
  public String toString() {
    return "Operator{" +
            "jobnumber='" + jobnumber + '\'' +
            ", password='" + password + '\'' +
            ", rid='" + rid + '\'' +
            ", role='" + role + '\'' +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", department='" + department + '\'' +
            ", vaild='" + vaild + '\'' +
            '}';
  }
}
