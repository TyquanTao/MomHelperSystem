package com.cn.pojo;


public class UserPost {

  private Integer upId;
  private Integer postId;
  private Integer userId;

  private Post post;

  public Integer getUpId() {
    return upId;
  }

  public void setUpId(Integer upId) {
    this.upId = upId;
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

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  @Override
  public String toString() {
    return "UserPost{" +
            "upId=" + upId +
            ", postId=" + postId +
            ", userId=" + userId +
            ", post=" + post +
            '}';
  }
}
