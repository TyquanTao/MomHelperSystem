package com.cn.dao;

import com.cn.pojo.Question;
import com.cn.pojo.QuestionCollection;
import com.cn.pojo.QuestionFabulous;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tyquan
 * @date 2019/11/28 10:08
 */
public interface QuestionMapper {

    /**
     * 提交问题（新建问题）
     *
     * @param question 新增问题的内容
     * @return 受影响的行数
     */
    Integer addQuestion(Question question);

    /**
     * 查询问题id
     * @param question
     * @return
     */
    Integer selectQuestionId(Question question);
    /**
     *通过问题id查看问题详情以及该问题的所有回答
     *
     * @param questionId
     * @return
     */
    Question findQuestionById(Integer questionId);

    /**
     * 热门问题（点赞数加收藏数排序）
     *
     * @return
     */
    List<Question> findAllByHot();

    /**
     * 待解决问题
     * @return
     */
    List<Question> findAllByUnsolvedQuestion();
    /**
     * 通过问题标题模糊查询问题
     * 搜索问题
     *
     * @return
     */
    List<Question> findQuestionLikeTitle(@Param("questionTitle") String questionTitle);

    /**
     * 查询历史搜索
     *
     * @param userId
     * @return
     */
    List<String> findHistorySearch(Integer userId);

    /**
     *删除历史记录
     *
     * @param userId
     * @return
     */
    Integer delHistorySearchByUserId(Integer userId);

    /**
     * 查询热门搜索
     *
     * @return
     */
    List<String> findHotSearch();

    /**
     * 收藏问题，在question_collections表中添加一条数据
     *
     * @param userId 用户id
     * @param questionId 问题id
     * @return
     */
    Integer addCollectQuestion(@Param("userId") Integer userId,@Param("questionId") Integer questionId);

    /**
     * 取消收藏问题
     *
     * @param userId
     * @param questionId
     * @return
     */
    Integer delCollectQuestion(@Param("userId") Integer userId,@Param("questionId") Integer questionId);
    /**
     * 每收藏一次问题，问题表的收藏次数加1
     *
     * @return
     */
    Integer updateQuestionCollections(Integer questionId);

    /**
     * 查询用户是否已经收藏此问题
     *
     * @param userId
     * @param questionId
     * @return
     */
    QuestionCollection selectQuestionCollection(@Param("userId") Integer userId,@Param("questionId") Integer questionId);
    /**
     * 通过用户id和问题点赞id查询
     * 是否已经点赞
     *
     * @param questionFabulous
     * @return
     */
    QuestionFabulous selectByQuestionFabulous(QuestionFabulous questionFabulous);

    /**
     * 添加一条问题点赞记录
     *
     * @param questionFabulous
     * @return
     */
    Integer addQuestionFabulous(QuestionFabulous questionFabulous);

    /**
     * 更新问题表的点赞次数
     *
     * @param questionId
     * @return
     */
    Integer updateQuestionPoints(Integer questionId);

    /**
     * 记数 正在提问的人数，去掉重复在未解决的问题中查
     *
     * @return
     */
    Integer countUserForQuestion();

    /**
     * 取消点赞
     *
     * @param questionFabulous 问题点赞对象
     * @return
     */
    Integer delQuestionFabulous(QuestionFabulous questionFabulous);
}
