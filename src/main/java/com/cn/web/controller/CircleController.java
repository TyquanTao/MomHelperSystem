package com.cn.web.controller;
import com.cn.dto.JsonResult;
import com.cn.service.CircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 圈子API
 */
@RestController
@Api(tags = "罗世杰",value = "小圈子API")
public class CircleController {
    @Autowired
    private CircleService circleService;
    /**
     * 查询小圈子列表
     * @return
     */
    @GetMapping("/circle/list")
    @ApiOperation(tags = "罗世杰",value = "小圈子列表")
    public JsonResult findAll(){
        return circleService.findAllCircle();
    }

    /**
     * 按照圈子类别查询小圈子列表
     * @param categoryId
     * @return
     */
    @GetMapping("/circle/byId/list")
    @ApiOperation(tags = "罗世杰",value = "按照圈子大类查询小圈子列表")
    @ApiImplicitParam(paramType = "query",name = "categoryId",value = "圈子大类ID",required = true,dataType = "int")
    public JsonResult findById(@RequestParam(value = "categoryId") Integer categoryId,@RequestParam(value = "userId") Integer userId){
        return circleService.findById(categoryId,userId);
    }

    /**
     * 用户关注的圈子列表
     * @param userId
     * @return
     */
    @GetMapping("/userCircle/list")
    @ApiOperation(tags = "罗世杰",value = "用户关注的圈子列表")
    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int")
    public JsonResult findAll(@RequestParam(value = "userId") Integer userId){
        return circleService.findByUserId(userId);
    }

    /**
     * 用户关注圈子的方法
     * @param userId:用户ID
     * @param circleId：被关注的圈子ID
     * @return
     */
    @PostMapping("/user/addCircle")
    @ApiOperation(tags = "罗世杰",value = "用户关注圈子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "usreId",value = "用户id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "circleId",value = "被关注圈子id",required = true,dataType = "int")
    })
    public JsonResult addUserCiecle(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "circleId")Integer circleId){
        return circleService.addUserCircle(userId,circleId);
    }
    /**
     * 用户取消关注圈子的方法
     * @param userId:用户ID
     * @param circleId：被关注的圈子ID
     * @return
     */
    @DeleteMapping("/user/deleteCircle")
    @ApiOperation(tags = "罗世杰",value = "用户取消关注圈子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "usreId",value = "用户id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "circleId",value = "取消关注圈子id",required = true,dataType = "int")
    })
    public JsonResult delectUserCiecle(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "circleId")Integer circleId){
        return circleService.deleteUserCircle(userId,circleId);
    }

//    /**
//     * 用户是否关注圈子的方法
//     * @param userId:用户ID
//     * @param circleId：被关注的圈子ID
//     * @return
//     */
//    @GetMapping("/user/selectCircle")
//    @ApiOperation(tags = "罗世杰",value = "用户是否关注圈子")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name = "usreId",value = "用户id",required = true,dataType = "int"),
//            @ApiImplicitParam(paramType = "query",name = "circleId",value = "圈子id",required = true,dataType = "int")
//    })
//    public JsonResult selectUserCiecle(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "circleId")Integer circleId){
//        return circleService.selectUserCircle(userId,circleId);
//    }
}
