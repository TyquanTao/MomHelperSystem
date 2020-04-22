package com.cn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Question implements Serializable {

  private Integer questionId;
  private String questionTitle;
  private String questionContent;
  private Integer userId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
  private Timestamp questionTime;
  private Integer questionDel;
  private Integer questionPoints;
  private Integer questionCollections;
  private Integer questionReply;
  private Integer praiseState;
  private Integer collectState;

  private User user;
  /*问题和回答是一对多*/
  private List<Answer> answers;

  private List<QuestionFabulous> questionFabulousList;

  private List<QuestionCollection> questionCollectionList;

  public Question() {
  }
  public Question(String questionTitle, String questionContent, Integer userId, Timestamp questionTime) {
    this.questionTitle = questionTitle;
    this.questionContent = questionContent;
    this.userId = userId;
    this.questionTime = questionTime;
  }
  public Integer getQuestionId() {
    return questionId;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public List<QuestionFabulous> getQuestionFabulousList() {
    return questionFabulousList;
  }

  public void setQuestionFabulousList(List<QuestionFabulous> questionFabulousList) {
    this.questionFabulousList = questionFabulousList;
  }

  public List<QuestionCollection> getQuestionCollectionList() {
    return questionCollectionList;
  }

  public void setQuestionCollectionList(List<QuestionCollection> questionCollectionList) {
    this.questionCollectionList = questionCollectionList;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }


  public String getQuestionTitle() {
    return questionTitle;
  }

  public void setQuestionTitle(String questionTitle) {
    this.questionTitle = questionTitle;
  }


  public String getQuestionContent() {
    return questionContent;
  }

  public void setQuestionContent(String questionContent) {
    this.questionContent = questionContent;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getQuestionTime() {
    return questionTime;
  }

  public void setQuestionTime(java.sql.Timestamp questionTime) {
    this.questionTime = questionTime;
  }


  public Integer getQuestionDel() {
    return questionDel;
  }

  public void setQuestionDel(Integer questionDel) {
    this.questionDel = questionDel;
  }


  public Integer getQuestionPoints() {
    return questionPoints;
  }

  public void setQuestionPoints(Integer questionPoints) {
    this.questionPoints = questionPoints;
  }


  public Integer getQuestionCollections() {
    return questionCollections;
  }

  public void setQuestionCollections(Integer questionCollections) {
    this.questionCollections = questionCollections;
  }


  public Integer getQuestionReply() {
    return questionReply;
  }

  public void setQuestionReply(Integer questionReply) {
    this.questionReply = questionReply;
  }


  public Integer getPraiseState() {
    return praiseState;
  }

  public void setPraiseState(Integer praiseState) {
    this.praiseState = praiseState;
  }


  public Integer getCollectState() {
    return collectState;
  }

  public void setCollectState(Integer collectState) {
    this.collectState = collectState;
  }

}
