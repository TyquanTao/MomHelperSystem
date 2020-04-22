package com.cn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserState implements Serializable {
  private Integer userStateId;
  private Integer stateId;
  private Integer userId;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
  private Timestamp stateStarttime;

  private Integer menstrualExtent;
  private Integer menstrualCycle;
  private String babyName;

  public UserState() {
  }

  @Override
  public String toString() {
    return "UserState{" +
            "userStateId=" + userStateId +
            ", stateId=" + stateId +
            ", userId=" + userId +
            ", stateStarttime=" + stateStarttime +
            ", menstrualExtent=" + menstrualExtent +
            ", menstrualCycle=" + menstrualCycle +
            ", babyName='" + babyName + '\'' +
            '}';
  }

  public Integer getMenstrualExtent() {
    return menstrualExtent;
  }

  public void setMenstrualExtent(Integer menstrualExtent) {
    this.menstrualExtent = menstrualExtent;
  }

  public Integer getMenstrualCycle() {
    return menstrualCycle;
  }

  public void setMenstrualCycle(Integer menstrualCycle) {
    this.menstrualCycle = menstrualCycle;
  }

  public String getBabyName() {
    return babyName;
  }

  public void setBabyName(String babyName) {
    this.babyName = babyName;
  }

  public Integer getUserStateId() {
    return userStateId;
  }

  public void setUserStateId(Integer userStateId) {
    this.userStateId = userStateId;
  }

  public Integer getStateId() {
    return stateId;
  }

  public void setStateId(Integer stateId) {
    this.stateId = stateId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Timestamp getStateStarttime() {
    return stateStarttime;
  }

  public void setStateStarttime(Timestamp stateStarttime) {
    this.stateStarttime = stateStarttime;
  }
}
