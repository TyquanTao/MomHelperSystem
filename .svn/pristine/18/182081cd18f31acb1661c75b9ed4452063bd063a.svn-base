package com.cn.dao;

import com.cn.pojo.Circle;
import com.cn.pojo.UserCircle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 罗世杰
 * @date 2019/11/28 21:22
 */
public interface UserCircleMapper {
    /**
     * 用户关注的圈子列表
     * @from:罗世杰
     * @param userId
     * @return
     */
    List<UserCircle> findByUserId(Integer userId);

    /**
     * 用户关注圈子的方法
     * @FROM:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    Integer addCircle(@Param(value="userId") Integer userId,@Param(value="circleId") Integer circleId);

    /**
     * 取消用户关注圈子的方法
     * @from:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    Integer delectCirclr(@Param(value="userId") Integer userId,@Param(value="circleId") Integer circleId);

    /**
     * 用户是否关注了这个圈子
     * @param userId
     * @param circleId
     * @return
     */
    UserCircle selectByUserId(@Param(value="userId") Integer userId,@Param(value="circleId") Integer circleId);
}

