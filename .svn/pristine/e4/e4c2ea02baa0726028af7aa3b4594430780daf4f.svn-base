package com.cn.pojo.vo;

import com.cn.pojo.Banner;
import com.cn.pojo.Post;
import com.cn.pojo.Question;

/**
 * Bannner的包装类：添加了Post和Question的关联关系及对应Banner图片的url
 * @author lj
 * @date 2019/12/1 10:58
 */
public class BannerVo extends Banner {
    // Banner的Img的存放地址
    private String imgUrl;
    // 1 : 1 Question
    private Question question;
    // 1 : 1 Post
    private Post post;

    public BannerVo() {
    }

    public BannerVo(String bannerName, Integer bannerType, String imgUrl, Post post) {
        super(bannerName, bannerType);
        this.imgUrl = imgUrl;
        this.post = post;
    }

    public BannerVo(String bannerName, Integer bannerType, String imgUrl, Question question) {
        super(bannerName, bannerType);
        this.imgUrl = imgUrl;
        this.question = question;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "BannerVo{" +
                "bannerName=" + super.getBannerName() +
                ",imgUrl='" + imgUrl + '\'' +
                ", question=" + question +
                ", post=" + post +
                '}';
    }
}
