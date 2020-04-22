package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Category;

import java.util.List;

/**
 * @author 罗世杰
 * @date 2019/11/28 14:58
 */
public interface CategoryService {
    /**
     * @from:罗世杰
     * 圈子大类列表
     * @return
     */
    JsonResult findAllCategory();
}
