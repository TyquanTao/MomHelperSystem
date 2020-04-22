package com.cn.service.impl;

import com.cn.dao.PostImgPostMapper;
import com.cn.dao.PostMapper;
import com.cn.dao.UserMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.PostImg;
import com.cn.pojo.vo.PostVo;
import com.cn.service.PostSerivce;
import com.cn.utils.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
@Service
//回滚数据
//@Transactional(rollbackFor = Throwable.class)
public class PostSerivceImpl implements PostSerivce {

    @Autowired
    private PostImgPostMapper postImgPostMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    private static String str = "黄色|暴力";

    /**
     * 增加帖子
     *
     * @param post
     * @FROM:罗世杰
     */
    public JsonResult addPost(Post post) {
        if(post==null){
            return new JsonResult(400,"参数错误！");
        }
        //设置系统当前时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        post.setPostTime(time);
        //获取List<PostImg>对象
        List<PostImg> postImgs = post.getPostImgs();
        //关系添加
        System.out.println(post.getPostTitle() + post.getPostContent() + post.getPostTime() + "加" + post.getCircleId());
        //过滤
        String comtent = post.getPostContent();
        String[] strArr = str.split("\\|");
        for (int i = 0; i < strArr.length; ++i) {
            String newString = "";
            if (comtent.contains(strArr[i])) {
                for (int j = 0; j < strArr[i].length(); ++j) {
                    newString += "*";
                }
                comtent = comtent.replace(strArr[i], newString);
            }
        }
        System.out.println(comtent);
        post.setPostContent(comtent);

        Integer number = postMapper.addPost(post);
        System.out.println("postId"+number);
        if (number == 0) {
            return new JsonResult(422, "发帖失败!");
        }
        for (PostImg postImg : postImgs) {
            //测试
            System.out.println(post.getPostId() + "qqqqq" + postImg.getPiId());
            if (postImgPostMapper.addPostImgPost(post.getPostId(), postImg.getPiId()) == 0) {
                return new JsonResult(422, "发帖失败!");
            }
        }
        return new JsonResult(200, "success!",post.getPostId());
    }

    /**
     * 通过帖子ID删除帖子（软删）
     * @author 尤翔龙
     * @param postId
     * @return
     */
    @Override
    public JsonResult deleteByPostId(Integer postId) {
        if (postId == null || postId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            Boolean temp = postMapper.deleteByPostId(postId);
            if (temp) {
                return new JsonResult(200, "删除成功");
            }
            return new JsonResult(422, "删除失败");
        }
    }

    /**
     * 修改帖子
     * @author 尤翔龙
     * @param post
     * @return
     */
    @Override
    public JsonResult updatePost(Post post) {
        if (post == null) {
            return new JsonResult(400, "参数错误");
        } else {
            Integer nums = postMapper.updatePost(post);
            if (nums > 0) {
                return new JsonResult(200, "success");
            }
        }
        return new JsonResult(422, "修改失败");
    }

    /**
     * 收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    @Override
    public JsonResult collectPost(Integer userId, Integer postId) {
        if (postId == null || userId == null || postId == 0 || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            Boolean temp = postMapper.collectPost(userId, postId);
            if (temp) {
                return new JsonResult(200, "success");
            }
        }
        return new JsonResult(422, "收藏失败");
    }

    /**
     * 取消收藏帖子
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    @Override
    public JsonResult notCollectPost(Integer userId, Integer postId) {
        if (postId == null || userId == null || postId == 0 || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            Boolean temp = postMapper.notCollectPost(userId, postId);
            if (temp) {
                return new JsonResult(200, "success");
            }
        }
        return new JsonResult(422, "取消收藏失败");
    }

//    /**
//     * 判断是否已收藏
//     * @author 尤翔龙
//     * @param userId
//     * @param postId
//     * @return
//     */
//    @Override
//    public JsonResult isCollectPost(Integer userId, Integer postId) {
//        if (postId == null || userId == null || postId == 0 || userId == 0) {
//            return new JsonResult(4001, "参数错误");
//        } else {
//            Integer nums = postMapper.isCollectPost(userId, postId);
//            if (nums > 0) {
//                return new JsonResult(200, "已收藏");
//            }
//        }
//        return new JsonResult(4013, "未收藏");
//    }

    /**
     * 帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    @Override
    public JsonResult giveLikePost(Integer userId, Integer postId) {
        if (postId == null || userId == null || postId == 0 || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            Boolean temp = postMapper.giveLikePost(userId, postId);
            if (temp) {
                return new JsonResult(200, "success");
            }
        }
        return new JsonResult(422, "点赞失败");
    }

    /**
     * 取消帖子点赞
     * @author 尤翔龙
     * @param userId
     * @param postId
     * @return
     */
    @Override
    public JsonResult notLikePost(Integer userId, Integer postId) {
        if (postId == null || userId == null || postId == 0 || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            Boolean temp = postMapper.notCollectPost(userId, postId);
            if (temp) {
                return new JsonResult(200, "success");
            }
        }
        return new JsonResult(422, "取消点赞失败");
    }

//    /**
//     * 判断是否已点赞
//     * @author 尤翔龙
//     * @param userId
//     * @param postId
//     * @return
//     */
//    @Override
//    public JsonResult isLikePost(Integer userId, Integer postId) {
//        if (postId == null || userId == null || postId == 0 || userId == 0) {
//            return new JsonResult(4001, "参数错误");
//        } else {
//            Integer nums = postMapper.isLikePost(userId, postId);
//            if (nums > 0) {
//                return new JsonResult(200, "已点赞");
//            }
//        }
//        return new JsonResult(4012, "未点赞");
//    }

    /**
     * 通过帖子ID查询单个帖子所有内容
     * @author 尤翔龙
     * @param postId
     * @return
     */
    @Override
    public JsonResult findByPostId(Integer postId,Integer userId) {
        if (postId == null || postId == 0 || userId == null || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            PostVo post = postMapper.findByPostId(postId);
            if (post != null) {
                Integer num1 = postMapper.isLikePost(userId, postId);
                if (num1==null) {
                    post.setIsLike(0);
                }else{
                    post.setIsLike(1);
                }
                Integer num2 = postMapper.isCollectPost(userId, postId);
                if (num2==null) {
                    post.setIsCollect(0);
                }else{
                    post.setIsCollect(1);
                }
                Integer num3=userMapper.isFollow(userId,post.getUserId());
                if(num3==null){
                    //未关注
                    post.setIsFollow(0);
                }else{
                    //已关注
                    post.setIsFollow(1);
                }
                return new JsonResult(200, "success", post);
            }
        }
        return new JsonResult(204, "查询失败");
    }

    /**
     * 所有帖子查询（热门推荐）
     * @author 尤翔龙
     * @param userId
     * @return
     */
    @Override
    public JsonResult findAllPost(Integer userId) {
        if (userId==null || userId==0) {
            return new JsonResult(400, "参数错误");
        }
        List<PostVo> posts = postMapper.findAllPost();
        if (posts == null || posts.size() == 0) {
            return new JsonResult(204, "查询失败");
        }else{
            for (PostVo post : posts) {
                Integer postId = post.getPostId();
                Integer num1 = postMapper.isLikePost(userId, postId);
                if (num1==null) {
                    //未点赞
                    post.setIsLike(0);
                }else {
                    //已点赞
                    post.setIsLike(1);
                }
                Integer num2 = postMapper.isCollectPost(userId, postId);
                if (num2==null) {
                    //未收藏
                    post.setIsCollect(0);
                }else{
                    //已收藏
                    post.setIsCollect(1);
                }
                Integer num3=userMapper.isFollow(userId,post.getUserId());
                if(num3==null){
                    //未关注
                    post.setIsFollow(0);
                }else{
                    //已关注
                    post.setIsFollow(1);
                }
            }
            return new JsonResult(200, "查询成功", posts);
        }
    }

    /**
     * 通过用户ID查询所关注用户的所有帖子
     * @author 尤翔龙
     * @param userId
     * @return
     */
    @Override
    public JsonResult findFollowUserPost(Integer userId) {
        if (userId == null || userId == 0) {
            return new JsonResult(400, "参数错误");
        } else {
            List<Integer> followUserIds = postMapper.findFollowUserId(userId);
            if (followUserIds != null && followUserIds.size() > 0) {
                List<PostVo> posts = postMapper.findPostByFollowUserId(followUserIds);
                if (posts != null && posts.size() > 0) {
                    for (PostVo post : posts) {
                        Integer postId = post.getPostId();
                        Integer num1 = postMapper.isLikePost(userId, postId);
                        if (num1==null) {
                            //未点赞
                            post.setIsLike(0);
                        }else {
                            //已点赞
                            post.setIsLike(1);
                        }
                        Integer num2 = postMapper.isCollectPost(userId, postId);
                        if (num2==null) {
                            post.setIsCollect(0);
                        }else{
                            post.setIsCollect(1);
                        }
                    }
                    return new JsonResult(200, "success", posts);
                }
            }
        }
        return new JsonResult(204, "查询失败");
    }

    /**
     * 通过圈子ID查询所有帖子
     * @author 尤翔龙
     * @param circleId
     * @param userId
     * @return
     */
    @Override
    public JsonResult findByCircleId(Integer circleId,Integer userId) {
        if (circleId==null || circleId==0) {
            return new JsonResult(400, "参数错误");
        }else{
            List<PostVo> postVos = postMapper.findByCircleId(circleId);
            if (postVos.size()>0) {
                for (PostVo post : postVos) {
                    Integer postId = post.getPostId();
                    Integer num1 = postMapper.isLikePost(userId, postId);
                    if (num1==null) {
                        //未点赞
                        post.setIsLike(0);
                    }else {
                        //已点赞
                        post.setIsLike(1);
                    }
                    Integer num2 = postMapper.isCollectPost(userId, postId);
                    if (num2==null) {
                        //未收藏
                        post.setIsCollect(0);
                    }else{
                        //已收藏
                        post.setIsCollect(1);
                    }
                    Integer num3=userMapper.isFollow(userId,post.getUserId());
                    if(num3==null){
                        //未关注
                        post.setIsFollow(0);
                    }else{
                        //已关注
                        post.setIsFollow(1);
                    }
                }
                return new JsonResult(200, "success", postVos);
            }
        }
        return new JsonResult(204, "查询失败");
    }


    /********************************************************************************************/
    /**
     * 通过推荐状态查找所有帖子
     * 周鑫
     *
     * @param page           当前页
     * @param pagesize       显示条数
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @return
     */
    @Override
    public JsonResult<PostVo> findAllByRecommendState(Integer page, Integer pagesize, Integer recommendState) {

        if (page == null && pagesize == null) {
            PageHelper.startPage(1, 10);
        } else if (page > 0 && pagesize > 0) {
            PageHelper.startPage(page, pagesize);
        } else {
            return new JsonResult(400, "请求参数错误");
        }
        List<PostVo> list = postMapper.findAllByRecommendState(recommendState);
        //将查询结果加入  pageInfo
        if (list.size() > 0) {
            PageInfo<PostVo> pageInfo = new PageInfo<>(list);
            return new JsonResult(200, "查询成功", pageInfo);
        }
        return new JsonResult(204, "查询成功,无对应数据");
    }

    /**
     * 通过推荐状态，条件查找帖子
     * 周鑫
     *
     * @param page           当前页
     * @param pagesize       显示条数
     * @param recommendState 推荐状态 0 未推荐，1审核，2已推荐
     * @param postVo         条件参数
     * @return
     */
    @Override
    public JsonResult findAllByRecommendStateWhere(Integer page, Integer pagesize, Integer recommendState, PostVo postVo) {
        if (page == null && pagesize == null) {
            PageHelper.startPage(1, 10);
        } else if (page > 0 && pagesize > 0) {
            PageHelper.startPage(page, pagesize);
        } else {
            return new JsonResult(400, "请求参数错误");
        }
        List<PostVo> list = postMapper.findAllByRecommendStateWhere(recommendState,postVo);
        if (list.size() > 0) {
            //将查询结果加入  pageInfo
            PageInfo<PostVo> pageInfo = new PageInfo<>(list);
            return new JsonResult(200, "查询成功", pageInfo);
        }
        return new JsonResult(204, "查询成功,无对应数据");
    }

    /**
     * 分页查询所有回收站的文章
     * 周鑫
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @return
     */
    @Override
    public JsonResult findAllByDelPost(Integer page, Integer pagesize) {
        if (page == null && pagesize == null) {
            PageHelper.startPage(1, 10);
        } else if (page > 0 && pagesize > 0) {
            PageHelper.startPage(page, pagesize);
        } else {
            return new JsonResult(400, "请求参数错误");
        }
        List<PostVo> list = postMapper.findAllByDelPost();
        if (list.size() > 0) {
            //将查询结果加入  pageInfo
            PageInfo<PostVo> pageInfo = new PageInfo<>(list);
            return new JsonResult(200, "查询成功", pageInfo);
        }
        return new JsonResult(204, "查询成功,无对应数据");
    }

    /**
     * 条件+分页查询回收站文章
     * 周鑫
     *
     * @param page     当前页
     * @param pagesize 显示条数
     * @param postVo   条件查询实体
     * @return
     */
    @Override
    public JsonResult findAllByDelPostWhere(Integer page, Integer pagesize, PostVo postVo) {
        if (page == null && pagesize == null) {
            PageHelper.startPage(1, 10);
        } else if (page > 0 && pagesize > 0) {
            PageHelper.startPage(page, pagesize);
        } else {
            return new JsonResult(400, "请求参数错误");
        }
        List<PostVo> list = postMapper.findAllByDelPostWhere(postVo);
        if (list.size() > 0) {
            //将查询结果加入  pageInfo
            PageInfo<PostVo> pageInfo = new PageInfo<>(list);
            return new JsonResult(200, "查询成功", pageInfo);
        }
        return new JsonResult(204, "查询成功,无对应数据");
    }

    /**
     * 单个修改文章的推荐状态
     * 周鑫
     *
     * @param recommendState 修改后的状态
     * @param postId         修改文章ID
     * @return
     */
    @Override
    public JsonResult updateRecommend(Integer postId, Integer recommendState) {
        if (postId != null && postId > 0) {
            Integer row = postMapper.updateRecommendByID(recommendState, postId);
            if (row != null && row > 0) {
                return new JsonResult(200, "推荐状态设置成功");
            } else {
                return new JsonResult(204, "设置失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 批量修改文章的推荐状态
     * 周鑫
     *
     * @param recommendState 修改后的状态
     * @param postIds        修改文章ID
     * @return
     */
    @Override
    public JsonResult updateRecommend(Integer recommendState, String postIds) {
        if (postIds != null && postIds.equals("")) {
            Integer row = postMapper.updateRecommendByIds(recommendState, StringUtil.conversionIds(postIds));
            if (row != null && row > 0) {
                return new JsonResult(200, "推荐状态设置成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }


    /**
     * 假删单个帖子
     * 周鑫
     *
     * @param postId 修改文章Id
     * @return
     */
    @Override
    public JsonResult removePost(Integer postId) {
        if (postId != null && postId > 0) {
            Integer row = postMapper.removePostById(postId);
            if (row != null && row > 0) {
                return new JsonResult(200, "删除成功");
            } else {
                return new JsonResult(400, "设置失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 假删多个帖子
     * 周鑫
     *
     * @param postIds 修改文章Id
     * @return
     */
    @Override
    public JsonResult removePost(String postIds) {
        if (postIds != null && postIds.equals("")) {
            Integer row = postMapper.removePostByIds(StringUtil.conversionIds(postIds));
            if (row != null && row > 0) {
                return new JsonResult(200, "删除成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 恢复单个帖子
     * 周鑫
     *
     * @param postId 修改文章Id
     * @return
     */
    @Override
    public JsonResult recoveryPost(Integer postId) {
        if (postId != null && postId > 0) {
            Integer row = postMapper.recoveryPostById(postId);
            if (row != null && row > 0) {
                return new JsonResult(200, "文件恢复成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 批量恢复帖子
     * 周鑫
     *
     * @param postIds 修改文章Id
     * @return
     */
    @Override
    public JsonResult recoveryPost(String postIds) {
        if (postIds != null && postIds.equals("")) {
            Integer row = postMapper.recoveryPostByIds(StringUtil.conversionIds(postIds));
            if (row != null && row > 0) {
                return new JsonResult(200, "文件恢复成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 彻底删除帖子
     * 周鑫
     *
     * @param postId 彻底删除文章Id
     * @return
     */
    @Override
    public JsonResult deletePost(Integer postId) {
        if (postId != null && postId > 0) {
            Integer row = postMapper.deletePostById(postId);
            if (row != null && row > 0) {
                return new JsonResult(200, "彻底删除成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }

    /**
     * 批量彻底删除帖子
     * 周鑫
     *
     * @param postIds 彻底删除文章Ids
     * @return
     */
    @Override
    public JsonResult deletePost(String postIds) {
        if (postIds != null && postIds.equals("")) {
            Integer row = postMapper.deletePostByIds(StringUtil.conversionIds(postIds));
            if (row != null && row > 0) {
                return new JsonResult(200, "彻底删除成功");
            } else {
                return new JsonResult(400, "操作失败");
            }
        }
        return new JsonResult(400, "请求参数错误");
    }


}
