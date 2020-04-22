package com.cn.dao;

import com.cn.pojo.PostImg;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author 罗世杰
 * @date 2019/11/29 14:24
 */
public interface PostImgMapper {
    /**
     * 图片路径保存
     * @param fileName
     * @return
     */
    Integer addPostImg(String fileName);

    /**
     * 查询单个路径对象
     * @param fileName
     * @return
     */
    PostImg findAll(String fileName);

}
