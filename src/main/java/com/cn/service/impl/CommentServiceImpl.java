package com.cn.service.impl;

import com.cn.dao.CommentMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Comment;
import com.cn.pojo.vo.CommentVo;
import com.cn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加评论
     * @author 尤翔龙
     * @param comment
     * @return
     */
    @Override
    public JsonResult<Comment> addComment(Comment comment) {
        if (comment==null) {
           return new JsonResult(400,"参数错误");
        }else{
            Timestamp time = new Timestamp(System.currentTimeMillis());
            comment.setCommentTime(time);
            Integer nums = commentMapper.addComment(comment);
            if (nums>0) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"评论失败");
    }

    /**
     * 删除评论（软删）
     * @author 尤翔龙
     * @param commentId
     * @return
     */
    @Override
    public JsonResult<Comment> deleteComment(Integer commentId) {
        if (commentId==null || commentId==0) {
            return new JsonResult(400,"参数错误");
        }else {
            Integer nums = commentMapper.deleteComment(commentId);
            if (nums>0) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"删除失败");
    }

    /**
     * 评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    @Override
    public JsonResult<Comment> giveLikeComment(Integer userId,Integer commentId) {
        if (commentId==null || userId==null || commentId==0 || userId==0) {
            return new JsonResult(400,"参数错误");
        }else {
            Boolean temp = commentMapper.giveLikeComment(userId,commentId);
            if (temp) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"点赞失败");
    }

    /**
     * 取消评论点赞
     * @author 尤翔龙
     * @param userId
     * @param commentId
     * @return
     */
    @Override
    public JsonResult<Comment> notLikeComment(Integer userId, Integer commentId) {
        if (commentId==null || userId==null || commentId==0 || userId==0) {
            return new JsonResult(400,"参数错误");
        }else {
            Boolean temp = commentMapper.giveLikeComment(userId,commentId);
            if (temp) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"取消点赞失败");
    }

//    /**
//     * 判断是否已点赞
//     * @author 尤翔龙
//     * @param userId
//     * @param commentId
//     * @return
//     */
//    @Override
//    public JsonResult isLikeComment(Integer userId, Integer commentId) {
//        if (commentId==null || userId==null || commentId==0 || userId==0) {
//            return new JsonResult(4001,"参数错误");
//        }else {
//            Integer nums = commentMapper.isLikeComment(userId, commentId);
//            if (nums>0) {
//                return new JsonResult(200,"已点赞");
//            }
//        }
//        return new JsonResult(4012,"未点赞");
//    }

    /**
     * 通过帖子ID查询所有一级评论
     * @author 尤翔龙
     * @param postId
     * @return
     */
    @Override
    public JsonResult<Comment> findAllComment(Integer postId,Integer userId) {
        if (postId==null || postId==0) {
            return new JsonResult<>(400,"参数错误");
        }else {
            List<CommentVo> comments = commentMapper.findAllComment(postId);
            if (comments.size()>0) {
                for (CommentVo comment : comments) {
                    Integer commentId = comment.getCommentId();
                    Integer nums = commentMapper.isLikeComment(userId, commentId);
                    if (nums==null) {
                        //未关注
                        comment.setIsLike(0);
                    }else {
                        //已关注
                        comment.setIsLike(1);
                    }
                }
                return new JsonResult(200,"success",comments);
            }
        }
        return new JsonResult(204,"查询失败");
    }

    /**
     * 通过父级ID查询所有子评论
     * @author 尤翔龙
     * @param parentId
     * @return
     */
    @Override
    public JsonResult<Comment> findAllCommentre(Integer parentId,Integer userId) {
        if (parentId==null || parentId==0) {
            return new JsonResult<>(400,"参数错误");
        }else {
            List<CommentVo> comments = commentMapper.findAllCommentre(parentId);
            if (comments.size()>0) {
                for (CommentVo comment : comments) {
                    Integer commentId = comment.getCommentId();
                    Integer nums = commentMapper.isLikeComment(userId, commentId);
                    if (nums==null) {
                        //未关注
                        comment.setIsLike(0);
                    }else {
                        //已关注
                        comment.setIsLike(1);
                    }
                }
                return new JsonResult(200,"success",comments);
            }
        }
        return new JsonResult(204,"查询失败");
    }
}
