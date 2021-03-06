package com.cn.dao;

import com.cn.pojo.Answer;
import com.cn.pojo.AnswerFabulous;
import org.apache.ibatis.annotations.Param;

/**
 * @author Tyquan
 * @date 2019/11/28 16:22
 */
public interface AnswerMapper {
    /**
     * 通过问题id查询answer
     *
     * @param questionId
     * @return
     */
    Answer findAnswerByQuestionId(Integer questionId);

    /**
     * 回答问题
     *
     * @param answer
     * @return
     */
    Integer addAnswer(Answer answer);

    /**
     * 回答问题
     * 问题表中的回复数量加1
     *
     * @param answer
     * @return
     */
    Integer updateQuestionReply(Answer answer);
    /**
     * 通过用户id和回答点赞id查询
     * 是否已经点赞
     *
     * @param answerFabulous
     * @return
     */
    AnswerFabulous selectByAnswerFabulous(AnswerFabulous answerFabulous);

    /**
     * 添加一条回答点赞记录
     *
     * @param answerFabulous
     * @return
     */
    Integer addAnswerFabulous(AnswerFabulous answerFabulous);

    /**
     * 删除一条回答点赞记录（取消点赞）
     *
     * @param userId
     * @param answerId
     * @return
     */
    Integer delAnswerFabulous(@Param("userId") Integer userId, @Param("answerId") Integer answerId);
    /**
     * 更新回答表的点赞次数
     *
     * @param answerId
     * @return
     */
    Integer updateAnswerPoints(Integer answerId);
}
