package com.reverie.domain;


import javax.persistence.Id;

public class Vechileadminoffice {
@Id
  private Integer id;
  private String province;
  private String city;
  private String area;
  private String officeName;
  private String optionalPlateHead;

  public String getOptionalPlateHead() {
    return optionalPlateHead;
  }

  public void setOptionalPlateHead(String optionalPlateHead) {
    this.optionalPlateHead = optionalPlateHead;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getOfficeName() {
    return officeName;
  }

  public void setOfficeName(String officeName) {
    this.officeName = officeName;
  }

  @Override
  public String toString() {
    return "Vechileadminoffice{" +
            "id=" + id +
            ", province='" + province + '\'' +
            ", city='" + city + '\'' +
            ", area='" + area + '\'' +
            ", officeName='" + officeName + '\'' +
            ", optionalPlateHead='" + optionalPlateHead + '\'' +
            '}';
  }
}
