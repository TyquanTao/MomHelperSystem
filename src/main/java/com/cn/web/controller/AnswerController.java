package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.pojo.Answer;
import com.cn.service.AnswerService;
import com.cn.utils.SensitivewordFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * @author Tyquan
 * @date 2019/11/28 9:14
 */
@Controller
@ResponseBody
@Api(tags = "陶仟-回答问题接口API", value = "AnswerAPI")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    private SensitivewordFilter filter = new SensitivewordFilter();

    /**
     * 回答问题
     *
     * @param questionId
     * @param answerContent
     * @return
     */
    @PostMapping("/answer/answerToQuestion")
    @ApiOperation(value = "回答问题接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "questionId",value = "被回答的问题id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "answerContent",value = "回答的内容",required = true,dataType = "string")
    })
    public JsonResult answerToQuestion(@RequestParam("userId") Integer userId,@RequestParam("questionId") Integer questionId,@RequestParam("answerContent") String answerContent){
        //过滤敏感词
        answerContent = filter.replaceSensitiveWord(answerContent,1,"*");
        //得到当前系统时间
        Timestamp answerTime = new Timestamp(System.currentTimeMillis());
        Answer answer = new Answer(questionId, answerContent, userId, answerTime);
        JsonResult result = answerService.addAnswer(answer);
        return result;
    }

    /**
     * 给回答点赞
     *
     * @param answerId
     * @return
     */
    @GetMapping("/answer/praiseAnswer")
    @ApiOperation(value = "回答点赞接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "answerId",value = "要被点赞的回答id",required = true,dataType = "int")
    })
    public JsonResult praiseAnswer(@RequestParam("userId") Integer userId, @RequestParam("answerId") Integer answerId){
        return answerService.praiseAnswer(userId, answerId);
    }
    @GetMapping("/answer/cancelPraiseAnswer")
    @ApiOperation(value = "取消回答点赞接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "answerId",value = "要取消点赞的回答id",required = true,dataType = "int")
    })
    public JsonResult cancelPraiseAnswer(@RequestParam("userId") Integer userId,@RequestParam("answerId") Integer answerId){
        return answerService.cancelPraiseAnswer(userId, answerId);
    }
}
