package com.cn.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Post implements Serializable {

  private Integer postId;
  private String postTitle;
  private String postContent;
  private Integer circleId;
  private Integer postDel;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
  private Timestamp postTime;
  private Integer userId;
  private Integer isRecommend;

  private User user;
  private Circle circle;
  private List<PostImg> postImgs;

  public Post() {
  }

  public Post(Integer postId, String postTitle, String postContent, Integer circleId, Integer postDel, Timestamp postTime, Integer userId, Integer isRecommend) {
    this.postId = postId;
    this.postTitle = postTitle;
    this.postContent = postContent;
    this.circleId = circleId;
    this.postDel = postDel;
    this.postTime = postTime;
    this.userId = userId;
    this.isRecommend = isRecommend;
  }

  @Override
  public String toString() {
    return "Post{" +
            "postId=" + postId +
            ", postTitle='" + postTitle + '\'' +
            ", postContent='" + postContent + '\'' +
            ", circleId=" + circleId +
            ", postDel=" + postDel +
            ", postTime=" + postTime +
            ", userId=" + userId +
            ", isRecommend=" + isRecommend +
            '}';
  }

  public Integer getPostId() {
    return postId;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }


  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }

  public Integer getCircleId() {
    return circleId;
  }

  public void setCircleId(Integer circleId) {
    this.circleId = circleId;
  }

  public Integer getPostDel() {
    return postDel;
  }

  public void setPostDel(Integer postDel) {
    this.postDel = postDel;
  }

  public Timestamp getPostTime() {
    return postTime;
  }

  public void setPostTime(Timestamp postTime) {
    this.postTime = postTime;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getIsRecommend() {
    return isRecommend;
  }

  public void setIsRecommend(Integer isRecommend) {
    this.isRecommend = isRecommend;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<PostImg> getPostImgs() {
    return postImgs;
  }

  public void setPostImgs(List<PostImg> postImgs) {
    this.postImgs = postImgs;
  }

  public Circle getCircle() {
    return circle;
  }

  public void setCircle(Circle circle) {
    this.circle = circle;
  }
}
