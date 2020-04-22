package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.User;
import com.cn.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/29 11:27
 * Description:
 */
@RestController
@Api(tags = "文茂宇—搜索API",value = "搜索入口")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "搜索帖子")
    @GetMapping("/search/searchPost")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "searchMessage", value = "需要查询的帖子题目", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "搜索的用户Id", required = true, dataType = "int")
    })
    public JsonResult<Post> searchPost(
            @RequestParam String searchMessage,
            @RequestParam Integer userId){
        return searchService.searchPost(searchMessage,userId);
    }

    @ApiOperation(value = "搜索用户")
    @GetMapping("/search/searchUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "searchMessage", value = "需要查询的用户呢称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "搜索的用户Id", required = true, dataType = "int")
    })
    public JsonResult<User> searchUser(
            @RequestParam(value = "searchMessage") String searchMessage,
            @RequestParam(value = "userId") Integer userId){
        return searchService.searchUser(searchMessage,userId);
    }

    @GetMapping("search/searchHistory")
    @ApiOperation(value = "搜索历史")
    @ApiImplicitParam(paramType = "query", name = "userId", value = "当前登录的用户Id", required = true, dataType = "int")
    public JsonResult searchHistory(@RequestParam(value = "userId") Integer userId){
        return searchService.findAllSearchByUserId(userId);
    }

    @GetMapping("search/deleteHistoryBySearchMessage")
    @ApiOperation(value = "删除单条历史记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "searchMessage", value = "当前历史记录信息", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "当前用户Id", required = true, dataType = "int")
    })
    public JsonResult deleteHistoryBySearch(
            @RequestParam(value = "searchMessage") String searchMessage,
            @RequestParam(value = "userId") Integer userId){
        System.out.println("-----------");
        boolean flag = searchService.deleteHistoryBySearchId(searchMessage,userId);
        if (flag){
            return new JsonResult(200,"单条历史记录删除成功");
        }
        return new JsonResult(4020,"单条历史记录删除失败");
    }


    @GetMapping("search/deleteAllHistory")
    @ApiOperation(value = "删除该用户所有历史记录")
    @ApiImplicitParam(paramType = "query", name = "userId", value = "当前用户Id", required = true, dataType = "int")
    public JsonResult deleteAllHistory(@RequestParam(value = "userId") Integer userId){
        System.out.println("删除");
        boolean flag = searchService.deleteAllHistory(userId);
        System.out.println(flag);
        if (flag){
            return new JsonResult(200,"所有历史记录删除成功");
        }
        return new JsonResult(4020,"所有历史记录删除失败");
    }

    @GetMapping("search/searchTop10")
    @ApiOperation(value = "查询热门搜索前10")
    public JsonResult findTop10HistorySearch(){
        return searchService.findTop10HistorySearchMessage();
    }

}
