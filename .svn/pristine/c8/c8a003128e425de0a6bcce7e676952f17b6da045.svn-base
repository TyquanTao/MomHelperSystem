package com.cn.dao;

import com.cn.dto.JsonResult;
import com.cn.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    /**
     * 在消息表中创建消息
     * 周鑫
     * @param messageEntity 消息实体
     * @return
     */
    Integer creatMessage(Message messageEntity);

    /**
     * 在消息-用户创建关联关系，阅读状态，删除状态为默认值
     * @param messageId 最后创建消息的主键
     * @param receiveUserIds
     * @return
     */
    Integer creatMessageToUser(@Param("messageId") Integer messageId, @Param("receiveUserIds") List<Integer> receiveUserIds);

    /**
     * 用户点击消息阅读后消息状态改变
     * 周鑫
     * @param  messageId 用户—消息关系Id
     * @return
     */
    Integer updateMessageState(@Param("messageId")Integer messageId);

    /**
     * 用户删除消自己接收的消息
     * 周鑫
     * @param  messageId  用户-消息关系Id
     * @return
     */
    Integer removeMessage(@Param("messageId")Integer messageId);

    /**
     * 用户获取自己接收的消息列表
     * 周鑫
     * @param  userId 当前用户Id
     * @return
     */
    List<Message> cheakMessageByRecipient(Integer userId);
}
