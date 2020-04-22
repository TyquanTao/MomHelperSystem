package com.cn.pojo;

import java.io.Serializable;

public class QuestionFabulous implements Serializable {

  private Integer id;
  private Integer userId;
  private Integer questionFabulousId;

  public QuestionFabulous() {
  }

  public QuestionFabulous(Integer userId, Integer questionFabulousId) {
    this.userId = userId;
    this.questionFabulousId = questionFabulousId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getQuestionFabulousId() {
    return questionFabulousId;
  }

  public void setQuestionFabulousId(Integer questionFabulousId) {
    this.questionFabulousId = questionFabulousId;
  }

  @Override
  public String toString() {
    return "QuestionFabulous{" +
            "id=" + id +
            ", userId=" + userId +
            ", questionFabulousId=" + questionFabulousId +
            '}';
  }
}
