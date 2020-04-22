package com.cn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Answer implements Serializable {

  private Integer answerId;
  private Integer questionId;
  private String answerContent;
  private Integer userId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
  private Timestamp answerTime;
  private Integer answerDel;
  private Integer answerPoints;
  private Integer praiseState;

  private  User user;
  private List<AnswerFabulous> answerFabulousList;

  public Answer() {
  }
  public Answer(Integer questionId, String answerContent, Integer userId, Timestamp answerTime) {
    this.questionId = questionId;
    this.answerContent = answerContent;
    this.userId = userId;
    this.answerTime = answerTime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<AnswerFabulous> getAnswerFabulousList() {
    return answerFabulousList;
  }

  public void setAnswerFabulousList(List<AnswerFabulous> answerFabulousList) {
    this.answerFabulousList = answerFabulousList;
  }

  public Integer getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Integer answerId) {
    this.answerId = answerId;
  }


  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }


  public String getAnswerContent() {
    return answerContent;
  }

  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getAnswerTime() {
    return answerTime;
  }

  public void setAnswerTime(java.sql.Timestamp answerTime) {
    this.answerTime = answerTime;
  }


  public Integer getAnswerDel() {
    return answerDel;
  }

  public void setAnswerDel(Integer answerDel) {
    this.answerDel = answerDel;
  }


  public Integer getAnswerPoints() {
    return answerPoints;
  }

  public void setAnswerPoints(Integer answerPoints) {
    this.answerPoints = answerPoints;
  }


  public Integer getPraiseState() {
    return praiseState;
  }

  public void setPraiseState(Integer praiseState) {
    this.praiseState = praiseState;
  }

}
