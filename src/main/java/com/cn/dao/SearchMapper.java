package com.cn.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/29 14:51
 * Description:
 */
public interface SearchMapper {

    /**
     * 添加用户搜索过的内容
     * @param userId
     * @param searchMessage
     * @return
     */
    Integer addSearch(@Param("userId") Integer userId, @Param("searchMessage") String searchMessage);

    /**
     * 添加用户搜索过的内容(问答)
     *
     * @param userId
     * @param searchMessage
     * @return
     */
    Integer addSearchForQuestion(@Param("userId") Integer userId, @Param("searchMessage") String searchMessage);

    /**
     * 删除历史记录（问答）
     *
     * @param userId
     * @param searchMessage
     * @return
     */
    Integer delSearchForQuestion(@Param("userId") Integer userId, @Param("searchMessage") String searchMessage);
    /**
     * 查询用户所有搜索记录
     * @param userId
     * @return
     */
    List<String> findByUserId(Integer userId);

    /**
     * 删除单个历史记录
     * @param searchMessage
     * @param userId
     * @return
     */
    Integer deleteHistoryBySearchId(
            @Param("searchMessage") String searchMessage,
            @Param("userId") Integer userId);

    /**
     * 删除该用户的历史记录
     * @param userId
     * @return
     */
    Integer deleteAllHistory(Integer userId);

    /**
     * 查询搜索榜前10
     * @return
     */
    List<String> findTop10HistorySearchMessage();


}
