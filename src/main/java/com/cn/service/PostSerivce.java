package com.cn.service;

import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.vo.PostVo;
import io.swagger.models.auth.In;

import java.util.List;

public interface PostSerivce {
    /**
     * @author:罗世杰
     * 添加帖子
     * @param post
     * @return
     */
    JsonResult addPost(Post post);

    /**
     * 通过帖子ID删除帖子（软删）
     * @author 尤翔龙
     * @param postId
     * @return
     */
    JsonResult deleteByPostId(Integer postId);

    /**
     * 修改帖子
     * @author 尤翔龙
     * @param post
     * @return
     */
    JsonResult updatePost(Post post);

    /**
     * 收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    JsonResult collectPost(Integer userId,Integer postId);

    /**
     * 取消收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    JsonResult notCollectPost(Integer userId,Integer postId);

//    /**
//     * 判断是否已收藏
//     * @author 尤翔龙
//     * @param userId
//     * @param postId
//     * @return
//     */
//    JsonResult isCollectPost(Integer userId,Integer postId);

    /**
     * 帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    JsonResult giveLikePost(Integer userId,Integer postId);

    /**
     * 取消帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    JsonResult notLikePost(Integer userId,Integer postId);

//    /**
//     * 判断是否已点赞
//     * @author 尤翔龙
//     * @param userId
//     * @param postId
//     * @return
//     */
//    JsonResult isLikePost(Integer userId,Integer postId);

    /**
     * 通过帖子ID查询单个帖子所有内容
     * @author 尤翔龙
     * @param postId
     * @return
     */
    JsonResult findByPostId(Integer postId,Integer userId);

    /**
     * 所有帖子查询（热门推荐）
     * @author 尤翔龙
     * @return
     */
    JsonResult findAllPost(Integer userId);

    /**
     * 通过用户ID查询所关注用户的所有帖子
     * @param userId
     * @return
     */
    JsonResult findFollowUserPost(Integer userId);

    /**
     * 通过圈子ID查询所有帖子
     * @author 尤翔龙
     * @param circleId
     * @param userId
     * @return
     */
    JsonResult findByCircleId(Integer circleId,Integer userId);

/************************************************************************************/
    /**
     * 通过推荐状态查找所有帖子
     * 周鑫
     * @param page     当前页
     * @param pagesize 显示条数
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @return
     */
    JsonResult<PostVo> findAllByRecommendState(Integer page,Integer pagesize,Integer recommendState);

    /**
     * 通过推荐状态，条件查找帖子
     * 周鑫
     *  @param page     当前页
     * @param pagesize 显示条数
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @param postVo 条件参数
     * @return
     */
    JsonResult findAllByRecommendStateWhere(Integer page, Integer pagesize, Integer recommendState, PostVo postVo);
    /**
     * 分页查询所有回收站的文章
     *周鑫
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    JsonResult findAllByDelPost(Integer page, Integer pagesize);

    /**
     * 条件+分页查询回收站文章
     *周鑫
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo     条件查询实体
     * @return
     */
    JsonResult findAllByDelPostWhere(Integer page, Integer pagesize, PostVo postVo);

    /**
     *修改文章的推荐状态
     * 周鑫
     * @param recommendState 修改后的状态
     * @param postId 修改文章ID
     * @return
     */
    JsonResult updateRecommend(Integer recommendState,Integer postId);

    /**
     *批量修改文章的推荐状态
     * 周鑫
     * @param recommendState 修改后的状态
     * @param postIds 修改文章ID
     * @return
     */
    JsonResult updateRecommend(Integer recommendState,String postIds);

    /**
     * 假删单个帖子
     * 周鑫
     * @param postId 修改文章Id
     * @return
     */
    JsonResult removePost(Integer postId);

    /**
     * 假删单个帖子
     * 周鑫
     * @param postIds 修改文章Id
     * @return
     */
    JsonResult removePost(String postIds);
    /**
     * 恢复单个帖子
     * 周鑫
     * @param postId 修改文章Id
     * @return
     */
    JsonResult recoveryPost(Integer postId);

    /**
     * 批量恢复帖子
     * 周鑫
     * @param postIds 修改文章Id
     * @return
     */
    JsonResult recoveryPost(String postIds);

    /**
     * 彻底删除帖子
     * 周鑫
     * @param postId 彻底删除文章Id
     * @return
     */
    JsonResult deletePost(Integer postId);

    /**
     * 批量彻底删除帖子
     * 周鑫
     * @param postIds 彻底删除文章Ids
     * @return
     */
    JsonResult deletePost(String postIds);
}
