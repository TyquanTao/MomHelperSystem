package com.cn.service;

import com.cn.pojo.PostImg;

/**
 * @author 罗世杰
 * @date 2019/11/29 14:40
 */
public interface PostImgService {
    /**
     * 图片路径保存
     * @param fileName
     * @return
     */
    Boolean addPostImg(String fileName);
    /**
     * 查询单个路径对象
     * @param fileName
     * @return
     */
    PostImg findAll(String fileName);
}
