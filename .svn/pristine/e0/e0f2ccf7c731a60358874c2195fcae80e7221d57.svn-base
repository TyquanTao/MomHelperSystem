package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 圈子大类API
 */
@RestController
@Api(tags = "罗世杰",value = "圈子大类API")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 圈子大类列表
     * @return
     */
    @GetMapping("/category/list")
    @ApiOperation(tags = "罗世杰",value = "圈子大类列表")
    public JsonResult findALLCategory(){
        return categoryService.findAllCategory();
    }
}
