package com.cn.dao;

import com.cn.pojo.PostImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostImgPostMapper {

    /**
     * 通过帖子ID查询图片
     * @author 尤翔龙
     * @param postId
     * @return
     */
    List<PostImg> findPostImgByPostId(Integer postId);

    /**
     * 帖子与图片路径关系增加
     * @author:罗世杰
     * @param postId
     * @param piId
     * @return
     */
    Integer addPostImgPost(@Param("postId") Integer postId, @Param("piId") Integer piId);
}
