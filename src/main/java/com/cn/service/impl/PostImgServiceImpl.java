package com.cn.service.impl;

import com.cn.dao.PostImgMapper;
import com.cn.pojo.PostImg;
import com.cn.service.PostImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 罗世杰
 * @date 2019/11/29 14:46
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class PostImgServiceImpl implements PostImgService{
    @Autowired
    private PostImgMapper postImgMapper;

    /**
     * 保存图片路径的方法
     * @from:罗世杰
     * @param fileName
     * @return
     */
    @Override
    public Boolean addPostImg(String fileName) {
        if(postImgMapper.addPostImg(fileName)>0){
            return true;
        }
        return false;
    }

    @Override
    public PostImg findAll(String fileName) {
        return postImgMapper.findAll(fileName);
    }
}
