package com.cn.service.impl;

import com.cn.dao.MessageMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Message;
import com.cn.service.MessageService;
import com.cn.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * 消息服务类
 *
 * @author 周鑫
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 创建消息
     * 周鑫
     *
     * @param messageEntity 消息信息
     * @return
     */
    @Override
    @Rollback
    public JsonResult creatMessage(Integer userId, Message messageEntity) {
        if (cheakParam(userId) && cheakParam(messageEntity)) {
            messageEntity.setMessageTime(new Timestamp(new Date().getTime()));
            messageEntity.setUserId(userId);
            if (messageMapper.creatMessage(messageEntity) > 0) {
                List<Integer> receiveUserIds = StringUtil.conversionIds(messageEntity.getReceiveUserIds());
                if (messageMapper.creatMessageToUser(messageEntity.getMessageId(), receiveUserIds) > 0) {
                    return new JsonResult(200, "发送成功");
                } else {
                    return new JsonResult(204, "消息创建成功，发送失败");
                }
            }
            return new JsonResult(204, "消息创建失败");
        }
        return new JsonResult(400, "请求数据错误");
    }

    /**
     * 用户点击消息阅读后消息状态改变
     * 周鑫
     *
     * @param messageId 用户—消息关系Id
     * @return
     */
    @Override
    public JsonResult updateMessageState(Integer messageId) {
        if (cheakParam(messageId)) {
            if (messageMapper.updateMessageState(messageId) > 0) {
                return new JsonResult(200, "状态修改成功");
            }
            return new JsonResult(204, "状态修改失败");
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 用户删除消自己接收的消息
     * 周鑫
     *
     * @param messageId 用户-消息关系Id
     * @return
     */
    @Override
    public JsonResult removeMessage(Integer messageId) {
        if (cheakParam(messageId)) {
            if (messageMapper.removeMessage(messageId) > 0) {
                return new JsonResult(200, "删除成功");
            }
            return new JsonResult(204, "删除失败");
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 用户获取自己接收的消息列表
     * 周鑫
     *
     * @param userId 当前用户Id
     * @return
     */
    @Override
    public JsonResult cheackMessageByRecipient(Integer userId) {
        if (cheakParam(userId)) {
            List<Message> list = messageMapper.cheakMessageByRecipient(userId);
            if (list.size() > 0) {
                return new JsonResult(200, "查询成功", list);
            } else if (list.size() == 0) {
                return new JsonResult(204, "查询成功,无对应数据");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 检查Integer参数是否符合要求
     *
     * @param param
     * @return
     */
    private static boolean cheakParam(Integer param) {
        if (param == null) {
            return false;
        }
        if (param <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 检查message参数是否符合要求
     *
     * @param param
     * @return
     */
    private static boolean cheakParam(Message param) {
        if (param == null) {
            return false;
        }
        if (param.getMessageTitle() == null) {
            return false;
        }
        if (param.getMessageTitle().equals("")) {
            return false;
        }
        if (param.getMessageText() == null) {
            return false;
        }
        if (param.getMessageText().equals("")) {
            return false;
        }
        if(param.getReceiveUserIds()==null){
            return false;
        }
        if(param.getReceiveUserIds().equals("")){
            return false;
        }
        return true;
    }
}
