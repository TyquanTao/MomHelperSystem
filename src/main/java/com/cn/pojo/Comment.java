package com.cn.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

  private Integer commentId;
  private String commentContent;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
  private Timestamp commentTime;
  private Integer commentDel;
  private Integer parentId;
  private Integer postId;
  private Integer userId;

  public Comment() {
  }

  @Override
  public String toString() {
    return "Comment{" +
            "commentId=" + commentId +
            ", commentContent='" + commentContent + '\'' +
            ", commentTime=" + commentTime +
            ", commentDel=" + commentDel +
            ", parentId=" + parentId +
            ", postId=" + postId +
            ", userId=" + userId +
            '}';
  }

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }

  public Timestamp getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(Timestamp commentTime) {
    this.commentTime = commentTime;
  }

  public Integer getCommentDel() {
    return commentDel;
  }

  public void setCommentDel(Integer commentDel) {
    this.commentDel = commentDel;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Integer getPostId() {
    return postId;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
