package com.cn.pojo;

import java.io.Serializable;

public class QuestionCollection implements Serializable {

  private Integer id;
  private Integer userId;
  private Integer questionCollectionId;

  public QuestionCollection() {
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


  public Integer getQuestionCollectionId() {
    return questionCollectionId;
  }

  public void setQuestionCollectionId(Integer questionCollectionId) {
    this.questionCollectionId = questionCollectionId;
  }

}
