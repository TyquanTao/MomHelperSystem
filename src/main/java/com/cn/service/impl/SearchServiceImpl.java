package com.cn.service.impl;

import com.cn.dao.PostMapper;
import com.cn.dao.SearchMapper;
import com.cn.dao.UserMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.Search;
import com.cn.pojo.User;
import com.cn.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/29 14:13
 * Description:
 */

@SuppressWarnings("all")
@Service
@Transactional(rollbackFor = Throwable.class)
public class SearchServiceImpl implements SearchService{
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private SearchMapper searchMapper;

    @Override
    public JsonResult searchPost(String searchMessage, Integer userId) {

        Integer addSearch = searchMapper.addSearch(userId, searchMessage);
        List<Post> posts = postMapper.findByPostTitle(searchMessage);

        return new JsonResult(200,"帖子搜索成功",posts);
    }

    @Override
    public JsonResult<User> searchUser(String searchMessage, Integer userId) {
        Integer addSearch = searchMapper.addSearch(userId, searchMessage);
        List<User> users = userMapper.findByUserName(searchMessage);
        return new JsonResult(200,"用户查询成功",users);
    }

    @Override
    public boolean addSearch(String searchMessage, Integer userId) {
        Integer flag = searchMapper.addSearch(userId, searchMessage);
        return flag > 0 ? true : false;
    }

    @Override
    public JsonResult<String> findAllSearchByUserId(Integer userId) {
        List<String> searches = searchMapper.findByUserId(userId);
        return new JsonResult(200,"历史记录查询成功",searches);
    }

    @Override
    public boolean deleteHistoryBySearchId(String searchMessage,Integer userId) {
        Integer row = searchMapper.deleteHistoryBySearchId(searchMessage,userId);

        return row > 0 ? true : false;
    }

    @Override
    public boolean deleteAllHistory(Integer userId) {
        Integer rows = searchMapper.deleteAllHistory(userId);

        return rows > 0 ? true : false;
    }

    @Override
    public JsonResult<String> findTop10HistorySearchMessage() {
        List<String> messageTop10 = searchMapper.findTop10HistorySearchMessage();

        return new JsonResult(200,"热门搜索查询成功",messageTop10);
    }


}
