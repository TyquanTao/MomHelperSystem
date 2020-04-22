package com.cn.pojo;

import java.io.Serializable;

public class Search implements Serializable {

  private long searchId;
  private long userId;
  private String searchMessage;
  private long searchType;
  private long searchDel;


  public long getSearchId() {
    return searchId;
  }

  public void setSearchId(long searchId) {
    this.searchId = searchId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getSearchMessage() {
    return searchMessage;
  }

  public void setSearchMessage(String searchMessage) {
    this.searchMessage = searchMessage;
  }


  public long getSearchType() {
    return searchType;
  }

  public void setSearchType(long searchType) {
    this.searchType = searchType;
  }


  public long getSearchDel() {
    return searchDel;
  }

  public void setSearchDel(long searchDel) {
    this.searchDel = searchDel;
  }

  @Override
  public String toString() {
    return "Search{" +
            "searchId=" + searchId +
            ", userId=" + userId +
            ", searchMessage='" + searchMessage + '\'' +
            ", searchType=" + searchType +
            ", searchDel=" + searchDel +
            '}';
  }
}
