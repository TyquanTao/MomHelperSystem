package com.cn.web.controller;

import com.cn.dto.JsonResult;
import com.cn.pojo.Comment;
import com.cn.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@Api(tags = "尤翔龙",value = "评论API")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/comm/add")
    @ApiOperation(tags = "尤翔龙",value = "添加评论")
    @ApiImplicitParam(paramType = "body",name = "comment",value = "评论对象",required = true,dataType = "Comment")
    public JsonResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    /**
     * 删除评论（软删）
     * @param commentId 评论ID
     * @return
     */
    @PostMapping("/comm/del")
    @ApiOperation(tags = "尤翔龙",value = "删除评论")
    @ApiImplicitParam(paramType = "query",name = "commentId",value = "评论ID",required = true,dataType = "int")
    public JsonResult deleteComment(@RequestParam(value = "commentId") Integer commentId){
        return commentService.deleteComment(commentId);
    }

    /**
     * 评论点赞
     * @param commentId 评论ID
     * @return
     */
    @PostMapping("/comm/like")
    @ApiOperation(tags = "尤翔龙",value = "评论点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "commentId",value = "评论ID",required = true,dataType = "int")
    })
    public JsonResult giveLikeComment(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "commentId")Integer commentId){
        return commentService.giveLikeComment(userId,commentId);
    }

    /**
     * 取消评论点赞
     * @param commentId 评论ID
     * @return
     */
    @DeleteMapping("/comm/notLike")
    @ApiOperation(tags = "尤翔龙",value = "取消评论点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "commentId",value = "评论ID",required = true,dataType = "int")
    })
    public JsonResult notLikeComment(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "commentId")Integer commentId){
        return commentService.notLikeComment(userId,commentId);
    }

//    /**
//     * 判断是否已点赞
//     * @param userId
//     * @param commentId
//     * @return
//     */
//    @GetMapping("/comm/isLike")
//    @ApiOperation(tags = "尤翔龙",value = "判断是否已点赞")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
//            @ApiImplicitParam(paramType = "query",name = "commentId",value = "评论ID",required = true,dataType = "int")
//    })
//    public JsonResult isLikeComment(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "commentId")Integer commentId){
//        return commentService.isLikeComment(userId,commentId);
//    }

    /**
     * 查询帖子所有一级评论
     * @param postId
     * @param userId
     * @return
     */
    @GetMapping("/comm/list")
    @ApiOperation(tags = "尤翔龙",value = "查询帖子所有一级评论")
    @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    public JsonResult findAllComment(@RequestParam(value = "postId") Integer postId,@RequestParam(value = "userId") Integer userId){
        return commentService.findAllComment(postId,userId);
    }

    /**
     * 查询评论的所有子评论
     * @param parentId
     * @return
     */
    @GetMapping("/comre/list")
    @ApiOperation(tags = "尤翔龙",value = "查询评论的所有子评论")
    @ApiImplicitParam(paramType = "query",name = "parentId",value = "父级ID",required = true,dataType = "int")
    public JsonResult findAllCommentre(@RequestParam(value = "parentId") Integer parentId,@RequestParam(value = "userId") Integer userId){
        return commentService.findAllCommentre(parentId,userId);
    }

}
