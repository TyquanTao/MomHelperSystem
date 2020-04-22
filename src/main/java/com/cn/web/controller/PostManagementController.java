package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.vo.PostVo;
import com.cn.service.PostSerivce;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周鑫
 * 帖子后台管理控制
 */
@Controller
@RestController
@Api(tags = "周鑫-文章管理API", value = "")
public class PostManagementController {

    @Autowired
    private PostSerivce postSerivce;
    /**
     * 分页查询所有未推荐文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    @GetMapping("/posterior/postmanagement/notRecommend")
    @ResponseBody
    @ApiOperation(value = "分页查询所有未推荐文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostNotRecommend(@RequestParam Integer page,@RequestParam Integer pagesize) {
        Integer recommendState = 0;
        return postSerivce.findAllByRecommendState(page,pagesize,recommendState);
    }

    /**
     * 分页查询所有推荐文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    @GetMapping("/posterior/postmanagement/recommend")
    @ResponseBody
    @ApiOperation(value = "分页查询所有推荐文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostRecommend(@RequestParam Integer page, @RequestParam Integer pagesize) {
        Integer recommendState = 2;
        return postSerivce.findAllByRecommendState(page,pagesize,recommendState);
    }

    /**
     * 分页查询所有等待推荐审核文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    @GetMapping("/posterior/postmanagement/auditRecommend")
    @ResponseBody
    @ApiOperation(value = "分页查询等待推荐审核的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostAuditRecommend(@RequestParam Integer page,@RequestParam  Integer pagesize) {
        Integer recommendState = 1;
        return postSerivce.findAllByRecommendState(page,pagesize,recommendState);
    }

    /**
     * 分页查询所有回收站的文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    @GetMapping("/posterior/postmanagement/recyclePost")
    @ResponseBody
    @ApiOperation(value = "分页查询所有回收站的文章文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakRecyclePost(@RequestParam Integer page,@RequestParam  Integer pagesize) {

        return postSerivce.findAllByDelPost(page,pagesize);
    }


    /**
     * 条件+分页查询未推荐文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo     条件查询实体
     * @return
     */
    @PostMapping("/posterior/postmanagement/notRecommendByWhere")
    @ResponseBody
    @ApiOperation(value = "条件+分页查询所有未推荐文章", notes = "通过json注入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "postVo", value = "查询条件实体", required = true, dataType = "PostVo")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostNotRecommendByWhere(@RequestParam Integer page,@RequestParam Integer pagesize, @RequestBody PostVo postVo) {
        Integer recommendState = 0;
        return postSerivce.findAllByRecommendStateWhere(page,pagesize,recommendState,postVo);
    }

    /**
     * 条件+分页查询推荐文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo     查询条件实体
     * @return
     */
    @PostMapping("/posterior/postmanagement/recommendByWhere")
    @ResponseBody
    @ApiOperation(value = "条件+分页查询推荐文章", notes = "通过json注入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "postVo", value = "查询条件实体", required = true, dataType = "PostVo")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostRecommendByWhere(@RequestParam Integer page,@RequestParam Integer pagesize, @RequestBody PostVo postVo) {
        Integer recommendState = 2;
        return postSerivce.findAllByRecommendStateWhere(page,pagesize,recommendState,postVo);
    }

    /**
     * 条件+分页查询等待推荐审核文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo     条件查询实体
     * @return
     */
    @PostMapping("/posterior/postmanagement/auditRecommendBywhere")
    @ResponseBody
    @ApiOperation(value = "条件+分页查询等待推荐审核文章", notes = "通过json注入数据")

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "postVo", value = "查询条件实体", required = true, dataType = "PostVo")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakPostAuditRecommendByWhere(@RequestParam Integer page,@RequestParam Integer pagesize, @RequestBody PostVo postVo) {
        Integer recommendState = 1;
        return postSerivce.findAllByRecommendStateWhere(page,pagesize,recommendState,postVo);
    }

    /**
     * 条件+分页查询回收站文章
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo     条件查询实体
     * @return
     */
    @PostMapping("/posterior/postmanagement/recyclePostByWhere")
    @ResponseBody
    @ApiOperation(value = "条件+分页查询回收站文章", notes = "通过json注入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pagesize", value = "显示条数", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "body", name = "postVo", value = "查询条件实体", required = true, dataType = "PostVo")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 204, message = "查询成功，无对应数据"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult cheakRecyclePostByWhere(@RequestParam Integer page,@RequestParam Integer pagesize, @RequestBody PostVo postVo) {

        return postSerivce.findAllByDelPostWhere(page,pagesize,postVo);
    }

    /**
     * 后台管理员主动设置/通过审批 将文章设置为推荐
     *
     * @param postId 文章ID
     * @return
     */
    @PostMapping("/posterior/postmanagement/updatePostRecommendById")
    @ResponseBody
    @ApiOperation(value = "后台管理员主动设置/通过审批 将文章设置为推荐")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID", required = true, dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "推荐状态设置成功"),
            @ApiResponse(code = 204, message = "设置失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult updatePostRecommendById(@RequestParam Integer postId) {
        Integer recommendState = 2;
        return postSerivce.updateRecommend(recommendState,postId);
    }

    /**
     * 后台管理员主动设置/通过审批 将批量文章设置为推荐
     *
     * @param postIds 文章ID数组
     * @return
     */
    @PostMapping("/posterior/postmanagement/updatePostRecommendByIds")
    @ResponseBody
    @ApiOperation(value = "后台管理员主动设置/通过审批 将批量文章设置为推荐")
    @ApiImplicitParam(paramType = "query", name = "postIds", value = "文章ID数组", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "推荐状态设置成功"),
            @ApiResponse(code = 204, message = "设置失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult updatePostRecommendByIds(@RequestParam String postIds) {

        Integer recommendState = 2;
        return postSerivce.updateRecommend(recommendState,postIds);
    }

    /**
     * 后台管理员主动设置/通过审批 将文章设置为普通
     */
    @PostMapping("/posterior/postmanagement/updatePostNotRecommendById")
    @ResponseBody
    @ApiOperation(value = "后台管理员主动设置/通过审批 将文章设置为普通")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID", required = true, dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "推荐状态设置成功"),
            @ApiResponse(code = 204, message = "设置失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult updatePostNotRecommendById(@RequestParam Integer postId) {
        Integer recommendState = 0;
        return postSerivce.updateRecommend(recommendState,postId);
    }

    /**
     * 后台管理员主动设置/通过审批 将多个文章设置为普通
     *
     * @param postIds 文章ID数组
     * @return
     */
    @PostMapping("/posterior/postmanagement/updatePostNotRecommendByIds")
    @ResponseBody
    @ApiOperation(value = "后台管理员主动设置/通过审批 将多个文章设置为普通")
    @ApiImplicitParam(paramType = "query", name = "postIds", value = "文章ID数组", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "推荐状态设置成功"),
            @ApiResponse(code = 204, message = "设置失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult updatePostNotRecommendByIds(@RequestParam String postIds) {
        Integer recommendState = 0;
        return postSerivce.updateRecommend(recommendState,postIds);
    }

    /**
     * 单个将文章放入回收站
     *
     * @param postId 文章ID
     * @return
     */
    @PostMapping("/posterior/postmanagement/removePostById")
    @ResponseBody
    @ApiOperation(value = "单个将文章放入回收站")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID", required = true, dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 204, message = "删除失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult removePostById(@RequestParam Integer postId) {
        return postSerivce.removePost(postId);
    }

    /**
     * 批量将文章放入回收站
     *
     * @param postIds 文章ID数组
     * @return
     */
    @PostMapping("/posterior/postmanagement/removePostByIds")
    @ResponseBody
    @ApiOperation(value = "批量将文章放入回收站")
    @ApiImplicitParam(paramType = "query", name = "postIds", value = "文章ID数组", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 204, message = "删除失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult removePostByIds(@RequestParam String postIds) {

        return postSerivce.removePost(postIds);
    }

    /**
     * 单个将回收站文章恢复为普通
     *
     * @param postId 文章ID
     * @return
     */
    @PostMapping("/posterior/postmanagement/recoveryPostById")
    @ResponseBody
    @ApiOperation(value = "单个将回收站文章恢复为普通")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID", required = true, dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "文件恢复成功"),
            @ApiResponse(code = 204, message = "操作失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult recoveryPostById(@RequestParam Integer postId) {
            return postSerivce.recoveryPost(postId);
    }

    /**
     * 批量将回收站文章恢复为普通
     *
     * @param postIds 文章ID数组
     * @return
     */
    @PostMapping("/posterior/postmanagement/recoveryPostByIds")
    @ResponseBody
    @ApiOperation(value = "批量将回收站文章恢复为普通")
    @ApiImplicitParam(paramType = "query", name = "postIds", value = "文章ID数组", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "文件恢复成功"),
            @ApiResponse(code = 204, message = "操作失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult recoveryPostByIds(@RequestParam String postIds) {
        return postSerivce.recoveryPost(postIds);
    }

    /**
     * 单个将文章彻底删除
     *
     * @param postId 文章ID
     * @return
     */
    @DeleteMapping("/posterior/postmanagement/delPostById")
    @ResponseBody
    @ApiOperation(value = "单个将文章彻底删除")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID", required = true, dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "彻底删除成功"),
            @ApiResponse(code = 204, message = "操作失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult delPostById(@RequestParam Integer postId) {
        return postSerivce.deletePost(postId);
    }

    /**
     * 批量将文章彻底删除
     *
     * @param postIds 文章ID数组
     * @return
     */
    @DeleteMapping("/posterior/postmanagement/delPostByIds")
    @ResponseBody
    @ApiOperation(value = "批量将文章彻底删除")
    @ApiImplicitParam(paramType = "query", name = "postId", value = "文章ID数组", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "彻底删除成功"),
            @ApiResponse(code = 204, message = "操作失败"),
            @ApiResponse(code = 400, message = "请求参数错误", response = Exception.class)
    })
    public JsonResult delPostByIds(@RequestParam String postIds) {
        return postSerivce.deletePost(postIds);
    }


//    @PostMapping("/receiveString")
//    @ResponseBody
//    @ApiOperation(value = "测试接收Strng")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "queryStr", value = "paramType为String", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType = "body", name = "bodyStr", value = "paramType为body", required = true, dataType = "String")
//    })
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "获取数据成功"),
//            @ApiResponse(code = 400, message = "获取数据失败", response = Exception.class)
//    })
//    public JsonResult testString(@RequestParam String queryStr,@RequestParam String bodyStr) {
//        ;
//        System.out.println(queryStr);
//        System.out.println("**********************************************");
//        System.out.println(bodyStr);
//        return null;
//    }

}
