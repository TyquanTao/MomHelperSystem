package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Circle;

import java.util.List;

public interface CircleService {
    /**
     * 查询所有小圈子
     * @from：罗世杰
     * @return
     */
    JsonResult findAllCircle();

    /**
     * 根据大圈子ID查询小圈子列表
     * @from：罗世杰
     * @param categoryId
     * @return
     */
    JsonResult findById(Integer categoryId,Integer userId);

    /**
     * 根据小圈子ID查询小圈子
     * @param userId
     * @return
     */
    JsonResult findByUserId(Integer userId);

    /**
     * 用户关注圈子的方法
     * @from:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    JsonResult addUserCircle(Integer userId,Integer circleId);
    /**
     * 用户取消关注圈子的方法
     * @from:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    JsonResult deleteUserCircle(Integer userId,Integer circleId);

//    /**
//     * 查询用户是否关注圈子的方法
//     * @from:罗世杰
//     * @param userId
//     * @param circleId
//     * @return
//     */
//    JsonResult selectUserCircle(Integer userId,Integer circleId);

}
