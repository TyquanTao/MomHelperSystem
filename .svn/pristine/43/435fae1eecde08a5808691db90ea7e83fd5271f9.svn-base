package com.cn.dao;

import com.cn.pojo.Comment;
import com.cn.pojo.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 添加评论
     * @author 尤翔龙
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 删除评论（软删）
     * @author 尤翔龙
     * @param commentId
     * @return
     */
    Integer deleteComment(Integer commentId);

    /**
     * 评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    Boolean giveLikeComment(@Param("userId") Integer userId,@Param("commentId") Integer commentId);

    /**
     * 取消评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    Boolean notLikeComment(@Param("userId") Integer userId,@Param("commentId") Integer commentId);

    /**
     * 判断是否已点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    Integer isLikeComment(@Param("userId") Integer userId,@Param("commentId") Integer commentId);

    /**
     * 通过帖子ID查询所有一级评论
     * @author 尤翔龙
     * @param postId
     * @return
     */
    List<CommentVo> findAllComment(Integer postId);

    /**
     * 通过父级ID查询所有子评论
     * @author 尤翔龙
     * @param parentId
     * @return
     */
    List<CommentVo> findAllCommentre(Integer parentId);

    /**
     * 统计评论点赞数量
     * @author 尤翔龙
     * @param commentId
     * @return
     */
    Integer countLike(Integer commentId);
}
