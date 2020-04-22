package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Answer;

/**
 * @author Tyquan
 * @date 2019/11/30 11:42
 */
public interface AnswerService {
    /**
     * 回答问题
     *
     * @param answer
     * @return
     */
    JsonResult addAnswer(Answer answer);

    /**
     * 给回答点赞
     *
     * @param userId
     * @param answerId
     * @return
     */
    JsonResult praiseAnswer(Integer userId,Integer answerId);

    /**
     *
     * @param userId
     * @param answerId
     * @return
     */
    JsonResult cancelPraiseAnswer(Integer userId,Integer answerId);
}
