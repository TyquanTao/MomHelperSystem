package com.cn.pojo;

import java.io.Serializable;

public class BannerQuestion implements Serializable {

  private Integer bqId;
  private Integer questionId;
  private Integer bannerId;
  private String imgUrl;

  public BannerQuestion() {
  }

  public Integer getBqId() {
    return bqId;
  }

  public void setBqId(Integer bqId) {
    this.bqId = bqId;
  }


  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }


  public Integer getBannerId() {
    return bannerId;
  }

  public void setBannerId(Integer bannerId) {
    this.bannerId = bannerId;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

}
