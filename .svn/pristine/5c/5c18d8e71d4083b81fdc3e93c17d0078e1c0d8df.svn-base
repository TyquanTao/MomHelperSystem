package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Comment;

public interface CommentService {

    /**
     * 添加评论
     * @author 尤翔龙
     * @param comment
     * @return
     */
    JsonResult addComment(Comment comment);

    /**
     * 删除评论（软删）
     * @author 尤翔龙
     * @param commentId
     * @return
     */
    JsonResult deleteComment(Integer commentId);

    /**
     * 评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    JsonResult giveLikeComment(Integer userId,Integer commentId);

    /**
     * 取消评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    JsonResult notLikeComment(Integer userId,Integer commentId);

//    /**
//     * 判断是否已点赞
//     * @author 尤翔龙
//     * @param userId
//     * @param commentId
//     * @return
//     */
//    JsonResult isLikeComment(Integer userId,Integer commentId);

    /**
     * 通过帖子ID查询所有一级评论
     * @author 尤翔龙
     * @param postId
     * @return
     */
    JsonResult findAllComment(Integer postId,Integer userId);

    /**
     * 通过父级ID查询所有子评论
     * @author 尤翔龙
     * @param parentId
     * @return
     */
    JsonResult findAllCommentre(Integer parentId,Integer userId);
}
