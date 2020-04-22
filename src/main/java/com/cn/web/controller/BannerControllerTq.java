package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tyquan
 * @date 2019/11/28 9:20
 */
@Controller
@ResponseBody
@Api(tags = "陶仟-顶部轮播图接口API", value = "BannerForQA_API")
public class BannerControllerTq {
    @Autowired
    private BannerService bannerService;

    /**
     *
     * @return
     */
    @GetMapping("/banner/BannerContent")
    @ApiOperation(value = "获取轮播图banner的信息接口")
    public JsonResult BannerContent(){
        return bannerService.BannerContent();
    }
}
