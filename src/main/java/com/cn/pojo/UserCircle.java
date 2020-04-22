package com.cn.pojo;


import java.io.Serializable;

public class UserCircle implements Serializable {

  private Integer ucId;
  private Integer userId;
  private Integer circleId;
  private Circle circles;


  public Integer getUcId() {
    return ucId;
  }

  public void setUcId(Integer ucId) {
    this.ucId = ucId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getCircleId() {
    return circleId;
  }

  public void setCircleId(Integer circleId) {
    this.circleId = circleId;
  }

  public Circle getCircles() {
    return circles;
  }

  public void setCircles(Circle circles) {
    this.circles = circles;
  }
}
