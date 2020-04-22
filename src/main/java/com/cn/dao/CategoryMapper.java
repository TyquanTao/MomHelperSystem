package com.cn.dao;

import com.cn.pojo.Category;

import java.util.List;

/**
 * @author 罗世杰
 * @date 2019/11/28 14:59
 */
public interface CategoryMapper {
    /**
     * @from:罗世杰
     * 圈子大类列表
     * @return
     */
    List<Category> findAllCategory();
}
