package com.cn.service.impl;

import com.cn.dao.MessagePushMapper;
import com.cn.dao.UserMapper;
import com.cn.pojo.MessagePush;
import com.cn.pojo.UserState;
import com.cn.service.MessagePushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/12/01 22:49
 * Description:
 */
@SuppressWarnings("all")
@Transactional(rollbackFor = Throwable.class)
@Service
public class MessagePushServiceImp implements MessagePushService {

    @Autowired
    private MessagePushMapper messagePushMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public MessagePush findNowDay(Integer userId,Date date) {
        MessagePush messagePush = null;
        UserState userState = userMapper.findUserStateStateId(userId);
        String dayString = new SimpleDateFormat("d").format(date.getTime() - userState.getStateStarttime().getTime());
        Integer day = Integer.parseInt(dayString);
        if(userState.getStateId() == 2){
            System.out.println("--------------------");
            Integer a = day % userState.getMenstrualCycle();
                if(a >= 1 && a <= userState.getMenstrualExtent()){
                     messagePush = messagePushMapper.findNowDay(2, 2);
                }else if(a >= 10 && a <= 19){
                     messagePush = messagePushMapper.findNowDay(2, 1);
                }else {
                    System.out.println("-------++--------");
                     messagePush = messagePushMapper.findNowDay(2, 3);
                }
        }else if(userState.getStateId() == 3){
            if (day <= 280){
                messagePush = messagePushMapper.findNowDay(3, day);
            }else {
                messagePush = messagePushMapper.findNowDay(3, 281);
            }
        }else if(userState.getStateId() == 4){
            if (day <= 6){
                messagePush = messagePushMapper.findNowDay(4, day);
            }else {
                messagePush = messagePushMapper.findNowDay(4, 7);
            }

        }

        return messagePush;
    }
}
