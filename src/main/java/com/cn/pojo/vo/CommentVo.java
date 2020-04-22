package com.cn.pojo.vo;

import com.cn.pojo.Comment;
import com.cn.pojo.User;

public class CommentVo extends Comment{


    //判断用户是否点赞
    private Integer isLike;
    //统计点赞数量
    private Integer countFabulous;
    // 发表评论的用户
    private User user;

    public CommentVo() {
    }

    public CommentVo(Integer isLike, Integer countFabulous,User user) {
        this.isLike = isLike;
        this.countFabulous = countFabulous;
        this.user = user;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getCountFabulous() {
        return countFabulous;
    }

    public void setCountFabulous(Integer countFabulous) {
        this.countFabulous = countFabulous;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
