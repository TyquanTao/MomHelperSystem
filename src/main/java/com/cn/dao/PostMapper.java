package com.cn.dao;

import com.cn.pojo.Post;
import com.cn.pojo.vo.PostVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PostMapper {

    /**
     * 通过帖子题目查询所有帖子（wmy）
     * @param postTitle
     * @return
     */
    List<Post> findByPostTitle(@Param(value = "postTitle") String postTitle);

    /**
     * 发帖的方法
     * @param post:帖子的实体对象
     * @return
     */
    Integer addPost(Post post);

    /**
     * 通过推荐状态查找所有帖子
     * 周鑫
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @return
     */
    List<PostVo> findAllByRecommendState(Integer recommendState);

    /**
     * 通过推荐状态，条件查找帖子
     * 周鑫
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @param postVo 条件参数
     * @return
     */
    List<PostVo> findAllByRecommendStateWhere(
            @Param(value = "recommendState") Integer recommendState,
            @Param(value = "postVo")  PostVo postVo);

    /**
     *查找回收站的所有文件
     * 周鑫
     * @return
     */
    List<PostVo> findAllByDelPost();

    /**
     *条件查找回收站的文件
     * 周鑫
     * @return
     */
    List<PostVo> findAllByDelPostWhere( @Param(value = "postVo") PostVo postVo);

    /**
     *修改文章的推荐状态
     * 周鑫
     * @param recommendState 修改后的状态
     * @param postId 修改文章ID
     * @return
     */
    Integer updateRecommendByID(
            @Param(value = "recommendState") Integer recommendState,
            @Param(value = "postId") Integer postId);

    /**
     *批量修改文章的推荐状态
     * 周鑫
     * @param recommendState 修改后的状态
     * @param postIds 修改文章Ids
     * @return
     */
    Integer updateRecommendByIds(
            @Param(value = "recommendState")Integer recommendState,
            @Param(value = "postIds") List<Integer> postIds);

    /**
     * 假删单个帖子
     * 周鑫
     * @param postId 修改文章Id
     * @return
     */
    Integer  removePostById(Integer postId);

    /**
     * 假删多个帖子
     * 周鑫
     * @param postIds 修改文章Ids
     * @return
     */
    Integer removePostByIds( @Param(value = "postIds") List<Integer> postIds);


    /**
     * 恢复单个帖子
     * 周鑫
     * @param postId 修改文章Id
     * @return
     */
    Integer recoveryPostById(Integer postId);

    /**
     * 恢复多个帖子
     * 周鑫
     * @param postIds 修改文章Ids
     * @return
     */
    Integer recoveryPostByIds( @Param(value = "postIds") List<Integer> postIds);

    /**
     * 彻底删除帖子
     * 周鑫
     * @param postId 彻底删除文章Id
     * @return
     */
    Integer deletePostById(Integer postId);

    /**
     * 批量彻底删除帖子
     * 周鑫
     * @param postIds 彻底删除文章Ids
     * @return
     */
    Integer deletePostByIds( @Param(value = "postIds") List<Integer> postIds);

    /**
     * 统计当前文章点赞数
     * 周鑫
     * @param postId 文章ID
     * @return
     */
    Integer countPostFabulous(Integer postId);

    /**
     * 统计当前文章评论数
     * 周鑫
     * @param postId 文章ID
     * @return
     */
    Integer countPostComment(Integer postId);

    /**
     * 统计当前文章收藏数
     * 周鑫
     * @param postId 文章Id
     * @return
     */
    Integer countPostCollection(Integer postId);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 通过帖子ID删除帖子（软删）
     * @author 尤翔龙
     * @param postId
     * @return
     */
     Boolean deleteByPostId(Integer postId);

    /**
     * 修改帖子内容
     * @author 尤翔龙
     * @param post
     * @return
     */
     Integer updatePost(Post post);

    /**
     * 收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
     Boolean collectPost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 取消收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
     Boolean notCollectPost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 判断是否已收藏
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
     Integer isCollectPost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    Boolean giveLikePost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 取消帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    Boolean notLikePost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 判断是否已点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    Integer isLikePost(@Param("userId")Integer userId,@Param("postId")Integer postId);

    /**
     * 通过帖子ID查询单个帖子所有内容
     * @author 尤翔龙
     * @param postId
     * @return
     */
    PostVo findByPostId(Integer postId);

    /**
     * 所有帖子查询（热门推荐）
     * @author 尤翔龙
     * @return
     */
    List<PostVo> findAllPost();

    /**
     * 通过用户ID查询关注用户ID
     * @author 尤翔龙
     * @param userId
     * @return
     */
    List<Integer> findFollowUserId(Integer userId);

    /**
     * 通过关注用户ID查询帖子
     * @author 尤翔龙
     * @param followUserIds
     * @return
     */
    List<PostVo> findPostByFollowUserId(List<Integer> followUserIds);

    /**
     * 通过圈子ID查询所有帖子
     * @author 尤翔龙
     * @param circleId
     * @return
     */
    List<PostVo> findByCircleId(Integer circleId);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询用户发表的帖子(wmy)
     * @param userId
     * @return
     */
    List<Post> findByUserId(Integer userId);
}
