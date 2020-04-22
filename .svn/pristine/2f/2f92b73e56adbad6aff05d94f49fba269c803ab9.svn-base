package com.cn.dao;

import com.cn.pojo.MessagePush;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/12/01 22:54
 * Description:
 */
public interface MessagePushMapper {
    /**
     * 根据得到的状态Id,各当前应该显示第几天的Id查询当前一天应该显示的内容
     * @param stateId
     * @return
     */
    MessagePush findNowDay(@Param("stateId") Integer stateId, @Param("id") Integer id);
}
