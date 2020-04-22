package com.cn.dao;

import com.cn.pojo.Circle;
import com.cn.pojo.vo.CircleVo;

import java.util.List;

public interface CircleMapper {
    /**
     * 圈子小类列表
     * @from:罗世杰
     * @return
     */
    List<Circle> findAllCircle();

    /**
     * 根据圈子大类ID查询圈子小类列表
     * @from
     * @return
     */
    List<CircleVo> findById(Integer categoryId);

    /**
     * 根据小圈子ID查询小圈子
     * @from：罗世杰
     * @param circleId
     * @return
     */
    Circle findByCirclrId(Integer circleId);

    /**
     * 通过圈子ID查询圈子名称
     * @author 尤翔龙
     * @param circleId
     * @return
     */
    Circle findNameById(Integer circleId);

    /**
     * 统计圈子被关注数量
     * @author 尤翔龙
     * @param circleId
     * @return
     */
    Integer countFollow(Integer circleId);
}
