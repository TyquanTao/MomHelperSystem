package com.cn.service;


import com.cn.dto.JsonResult;
import com.cn.pojo.Message;

public interface MessageService {

    /**
     * 创建消息
     * 周鑫
     * @param messageEntity 消息信息
     * @return
     */
    JsonResult creatMessage(Integer userId, Message messageEntity);

    /**
     * 用户点击消息阅读后消息状态改变
     * 周鑫
     * @param  messageId 用户—消息关系Id
     * @return
     */
    JsonResult updateMessageState(Integer messageId);

    /**
     * 用户删除消自己接收的消息
     * 周鑫
     * @param  messageId  用户-消息关系Id
     * @return
     */
    JsonResult removeMessage(Integer messageId);

    /**
     * 用户获取自己接收的消息列表
     * 周鑫
     * @param  userId 当前用户Id
     * @return
     */
    JsonResult cheackMessageByRecipient(Integer userId);
}
