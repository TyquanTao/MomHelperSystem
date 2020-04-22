package com.cn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Message {

    private Integer messageId;
    private String messageTitle;
    private String messageText;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-8")
    private Timestamp messageTime;
    private Integer userId;//发送消息人的ID
    private String userName;
    private String receiveUserIds;//消息接收者IDs
    private Integer isRead;



    public Message() {
    }


    public Message(Integer messageId, String messageTitle, String messageText, Timestamp messageTime, Integer userId, String userName, String receiveUserIds, Integer isRead) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageText = messageText;
        this.messageTime = messageTime;
        this.userId = userId;
        this.userName = userName;
        this.receiveUserIds = receiveUserIds;
        this.isRead = isRead;
    }

    public String getMessageText() {
        return messageText;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }


    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiveUserIds() {
        return receiveUserIds;
    }

    public void setReceiveUserIds(String receiveUserIds) {
        this.receiveUserIds = receiveUserIds;
    }
    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}
