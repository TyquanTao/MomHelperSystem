package com.cn.pojo;


public class MessagePush {

  private Integer id;
  private String pushTitle;
  private String badyMessage;
  private String motherMessage;
  private String heightMessage;
  private String weightMessage;
  private Integer stateId;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getPushTitle() {
    return pushTitle;
  }

  public void setPushTitle(String pushTitle) {
    this.pushTitle = pushTitle;
  }


  public String getBadyMessage() {
    return badyMessage;
  }

  public void setBadyMessage(String badyMessage) {
    this.badyMessage = badyMessage;
  }


  public String getMotherMessage() {
    return motherMessage;
  }

  public void setMotherMessage(String motherMessage) {
    this.motherMessage = motherMessage;
  }


  public String getHeightMessage() {
    return heightMessage;
  }

  public void setHeightMessage(String heightMessage) {
    this.heightMessage = heightMessage;
  }


  public String getWeightMessage() {
    return weightMessage;
  }

  public void setWeightMessage(String weightMessage) {
    this.weightMessage = weightMessage;
  }


  public Integer getStateId() {
    return stateId;
  }

  public void setStateId(Integer stateId) {
    this.stateId = stateId;
  }

  @Override
  public String toString() {
    return "MessagePush{" +
            "id=" + id +
            ", pushTitle='" + pushTitle + '\'' +
            ", badyMessage='" + badyMessage + '\'' +
            ", motherMessage='" + motherMessage + '\'' +
            ", heightMessage='" + heightMessage + '\'' +
            ", weightMessage='" + weightMessage + '\'' +
            ", stateId=" + stateId +
            '}';
  }
}
