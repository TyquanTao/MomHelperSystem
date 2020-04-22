package com.cn.dao;

import com.cn.pojo.QuestionFabulous;

/**
 * @author Tyquan
 * @date 2019/12/2 10:25
 */
public interface QuestionFabulousMapper {
    QuestionFabulous findUserIdByQuestionId(Integer questionId);
}
