package com.cn.service.impl;

import com.cn.dao.CircleMapper;
import com.cn.dao.UserCircleMapper;
import com.cn.dto.JsonResult;
import com.cn.pojo.Circle;
import com.cn.pojo.UserCircle;
import com.cn.pojo.vo.CircleVo;
import com.cn.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private UserCircleMapper userCircleMapper;
    @Autowired
    private CircleMapper circleMapper;

    /**
     * 查询小圈子列表
     * @return
     */
    @Override
    public JsonResult findAllCircle() {
        List<Circle> list=circleMapper.findAllCircle();
        if(list.size()>0){
            return new JsonResult(200,"success",list);
        }
        return new JsonResult(204,"查询失败！");
    }

    /**
     * 根据大圈子ID查询小圈子列表
     * @from：罗世杰
     * @param categoryId
     * @return
     */
    @Override
    public JsonResult findById(Integer categoryId,Integer userId) {
        if(categoryId==null||categoryId==0||userId==null||userId==0){
            return new JsonResult(400,"参数错误！");
        }
        List<CircleVo> circles=circleMapper.findById(categoryId);
        if(circles.size()>0){
            for (CircleVo circle : circles) {
                Integer circleId = circle.getCircleId();
                UserCircle userCircle = userCircleMapper.selectByUserId(userId, circleId);
                if(userCircle!=null){
                    //已关注
                    circle.setIsFollow(1);
                }else{
                    //未关注
                    circle.setIsFollow(0);
                }
            }
            return new JsonResult(200,"success",circles);
        }
        return new JsonResult(204,"查询失败！");
    }

    /**
     * 用户关注的圈子列表
     * @param userId
     * @return
     */
    @Override
    public JsonResult findByUserId(Integer userId) {
        if(userId==null||userId==0){
            return new JsonResult(400,"参数错误！");
        }
        List<UserCircle> circles=userCircleMapper.findByUserId(userId);
        if(circles.size()>0){
            return new JsonResult(200,"success",circles);
        }
        return  new JsonResult(204,"查询失败！");
    }

    /**
     * 用户关注圈子的方法
     * @from:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    public JsonResult addUserCircle(Integer userId,Integer circleId){
        if(circleId==null||circleId==0||userId==null||userId==0){
            return new JsonResult(400,"参数错误！");
        }
        if(userCircleMapper.addCircle(userId,circleId)>0){
            return new JsonResult(200,"success!");
        }
        return new JsonResult(422,"关注失败");
    }
    /**
     * 用户取消关注圈子的方法
     * @from:罗世杰
     * @param userId
     * @param circleId
     * @return
     */
    @Override
    public JsonResult deleteUserCircle(Integer userId, Integer circleId) {
        if(circleId==null||circleId==0||userId==null||userId==0){
            return new JsonResult(400,"参数错误！");
        }
        if(userCircleMapper.delectCirclr(userId,circleId)>0){
            return new JsonResult(200,"success!");
        }
        return new JsonResult(422,"取消关注失败");
    }

//    /**
//     * 查询用户是否关注圈子的方法
//     * @from:罗世杰
//     * @param userId
//     * @param circleId
//     * @return
//     */
//    @Override
//    public JsonResult selectUserCircle(Integer userId, Integer circleId) {
//        if(userCircleMapper.selectByUserId(userId,circleId)==null){
//            return new JsonResult(200,"success");
//        }
//        return new JsonResult(4001,"用户已关注该圈子");
//    }
}
