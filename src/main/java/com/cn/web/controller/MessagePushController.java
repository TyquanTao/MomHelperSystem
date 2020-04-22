package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.pojo.MessagePush;
import com.cn.service.MessagePushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/12/01 22:23
 * Description:
 */
@RestController
@Api(tags = "文茂宇—固定推送API",value = "固定推送")
public class MessagePushController {

    @Autowired
    private MessagePushService messagePushService;

    @GetMapping("/messagePush/findNowDay")
    @ApiOperation(value = "固定消息推送")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户Id",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "date",value = "当前需要显示的内容的日期",required = true,dataType = "Date")
    })
    public JsonResult messagePush(
            @RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        MessagePush messagePush = messagePushService.findNowDay(userId,date);
        return new JsonResult(200,"固定推送查询成功",messagePush);
    }
}
