package com.cn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
  private Integer userId;
  private String userName;
  private String userPhone;
  private String userPassword;
  private String userImgUrl;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
  private Timestamp userStartTime;
  private Integer userPostCount;
  private Integer userCollectCount;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
  private Timestamp userBirthday;
  private Integer userDel;
  // 用户：状态=1:1
  private State state;

  public User() {
  }
  public User(String userPhone,String userPassword,Timestamp userStartTime) {
    this.userPhone = userPhone;
    this.userPassword = userPassword;
    this.userStartTime=userStartTime;
  }

  public User(Integer userId, String userName, String userPassword) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userImgUrl='" + userImgUrl + '\'' +
            ", userStartTime=" + userStartTime +
            ", userPostCount=" + userPostCount +
            ", userCollectCount=" + userCollectCount +
            ", userBirthday=" + userBirthday +
            ", userDel=" + userDel +
            ", state=" + state +
            '}';
  }

  public Timestamp getUserStartTime() {
    return userStartTime;
  }

  public void setUserStartTime(Timestamp userStartTime) {
    this.userStartTime = userStartTime;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserImgUrl() {
    return userImgUrl;
  }

  public void setUserImgUrl(String userImgUrl) {
    this.userImgUrl = userImgUrl;
  }

  public Integer getUserPostCount() {
    return userPostCount;
  }

  public void setUserPostCount(Integer userPostCount) {
    this.userPostCount = userPostCount;
  }

  public Integer getUserCollectCount() {
    return userCollectCount;
  }

  public void setUserCollectCount(Integer userCollectCount) {
    this.userCollectCount = userCollectCount;
  }

  public Timestamp getUserBirthday() {
    return userBirthday;
  }

  public void setUserBirthday(Timestamp userBirthday) {
    this.userBirthday = userBirthday;
  }

  public Integer getUserDel() {
    return userDel;
  }

  public void setUserDel(Integer userDel) {
    this.userDel = userDel;
  }
}
