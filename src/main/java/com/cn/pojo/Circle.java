package com.cn.pojo;


import java.io.Serializable;

public class Circle implements Serializable {

  private Integer circleId;
  private String circleName;
  private Integer categoryId;
  private String circleUrl;

  public Circle() {
  }

  @Override
  public String toString() {
    return "Circle{" +
            "circleId=" + circleId +
            ", circleName='" + circleName + '\'' +
            ", categoryId=" + categoryId +
            ", circleUrl='" + circleUrl + '\'' +
            '}';
  }

  public Integer getCircleId() {
    return circleId;
  }

  public void setCircleId(Integer circleId) {
    this.circleId = circleId;
  }


  public String getCircleName() {
    return circleName;
  }

  public void setCircleName(String circleName) {
    this.circleName = circleName;
  }


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }


  public String getCircleUrl() {
    return circleUrl;
  }

  public void setCircleUrl(String circleUrl) {
    this.circleUrl = circleUrl;
  }

}
