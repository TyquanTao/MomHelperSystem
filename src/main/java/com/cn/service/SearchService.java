package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.Search;
import com.cn.pojo.User;


/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/29 14:13
 * Description:
 */
public interface SearchService {
    /**
     * 搜索框搜索帖子
     * @param searchMessage
     * @param userId
     * @return
     */
    JsonResult<Post> searchPost(String searchMessage, Integer userId);

    /**
     * 搜索框搜索用户
     * @param searchMessage
     * @param userId
     * @return
     */
    JsonResult<User> searchUser(String searchMessage, Integer userId);

    /**
     * 添加搜索历史
     * @param searchMessage
     * @param userId
     * @return
     */
    boolean addSearch(String searchMessage, Integer userId);


    /**
     * 查询搜索历史记录
     * @param userId
     * @return
     */
    JsonResult<String> findAllSearchByUserId(Integer userId);


    /**
     * 删除单条历史记录
     * @param searchMessage
     * @param userId
     * @return
     */
    boolean deleteHistoryBySearchId(String searchMessage,Integer userId);

    /**
     * 删除用户全部历史记录
     * @param userId
     * @return
     */
    boolean deleteAllHistory(Integer userId);


    /**
     * 查询搜索记录前10
     * @return
     */
    JsonResult<String> findTop10HistorySearchMessage();


}
