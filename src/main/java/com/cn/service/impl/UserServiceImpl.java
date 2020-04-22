package com.cn.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cn.dao.PostMapper;
import com.cn.dao.StateMapper;
import com.cn.dao.UserMapper;
import com.cn.dto.JsonResult;
import com.cn.exception.JwtException;
import com.cn.exception.UserException;
import com.cn.pojo.*;
import com.cn.service.UserService;
import com.cn.utils.RandomNumberUtil;
import com.cn.utils.SendCodeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import java.sql.Timestamp;

@Service
@Transactional(rollbackFor = Throwable.class)
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostMapper postMapper;

    /**
     * 登录方法
     * @param userPhone：用户的手机号（登陆账号
     * @param password：密码
     *               张鹏
     * @return
     */
    @Override
    public JsonResult<User> login(User user) {
        User login = userMapper.login(user);
        return new JsonResult<>(200,"success",login);
    }


    @Override
    public String sendCode(String phone) {
        String code = RandomNumberUtil.getCode();
        try {
            SendSmsResponse sendSmsResponse = SendCodeUtil.sendSms(phone, code);
            //
            addRegister(new Register(phone,code));
            /*userMapper.addRegister(new Register(phone,code));*/
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public Boolean judegRegister(Register register) {
        Register registerAll = userMapper.findRegisterAll(register);
        if (registerAll!=null){
            return true;
        }
        return false;
    }

    /**
     * 查询临时记录表的记录
     * @param phone
     * @return
     */
    /*@Override
    public Boolean findRegister(String phone) {
        Register register = userMapper.findRegister(phone);
        if (register!=null){
            return true;
        }
        return false;
    }*/

    @Override
    public Boolean addRegister(Register register) {
        Register register1 = userMapper.findRegister(register.getRegisterPhone());
        System.out.println("++++++++++++++++"+register1);
        if (register1!=null){
            Integer integer = userMapper.updateRegister(register);
            System.out.println("++++++++11111+++++"+integer);
            return true;
        }else if(register1==null){
            Integer integer = userMapper.addRegister(register);
            System.out.println("+++++++22222++++++"+integer);
            return true;
        }
        return false;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public Boolean adduser(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setUserStartTime(timestamp);
        Integer adduser = userMapper.adduser(user);
        if (adduser>0){
            return true;
        }
        return false;
    }


    /**
     * 判断用户的 状态
     * @param id:用户的id
     * @return
     * 张鹏
     */
    @Override
    public Boolean decideState(Integer id) {
        UserState userState = userMapper.decideState(id);
        if (userState.getStateId()==1){
            return false;
        }
        return true;
    }


    @Override
    public Boolean updateState(Integer userId, Integer stateId, Timestamp starttime) {
        Integer integer = userMapper.updateState(userId, stateId,starttime);
        System.out.println(integer);
        if (integer>0){
            return true;
        }
        return false;
    }







    ////////////////////////////////////////////////////管理员操作----李静的Mapper,放在下面/////////////////////////////////

    @Autowired
    private StateMapper stateMapper;

    /**
     * 查找所有用户(含分页)
     * @author 李静
     * @param size
     * @param sizePage
     * @return
     */
    @Override
    public PageInfo findAllUser(Integer size, Integer sizePage) throws UserException {
        // 判断数据
        if (size == null || sizePage == null)
           throw new UserException(205,"请求驳回！参数为空");
        if (size == 0 || sizePage == 0)
            throw new UserException(206,"请求驳回！参数不正确");

        // 正常返回数据
        PageHelper pageHelper = new PageHelper();

        pageHelper.startPage(size, sizePage);
        // 获取全部用户
        List<User> users = userMapper.findAllUser();

        if (users == null)
            // 数据库无数据
            throw new UserException(204,"请求已处理，数据库无数据");

        return new PageInfo(users);
    }

    /**
     * 查找所有被删除的用户(含分页)
     * @author 李静
     * @param size
     * @param sizePage
     * @return
     */
    @Override
    public PageInfo findAllDelUser(Integer size, Integer sizePage) throws UserException {
        // 判断数据
        if (size == null || sizePage == null)
            throw new UserException(205,"请求驳回！参数为空");
        if (size == 0 || sizePage == 0)
            throw new UserException(206,"请求驳回！参数不正确");

        // 正常返回数据
        PageHelper pageHelper = new PageHelper();

        pageHelper.startPage(size, sizePage);
        // 获取全部用户
        List<User> users = userMapper.findAllUser();

        if (users == null)
            // 数据库无数据
            throw new UserException(204,"请求已处理，数据库无数据");

        return new PageInfo(users);
    }


    /**
     * 查询数据库所有的状态信息
     * @author 李静
     * @return
     */
    @Override
    public List<State> findAllState() {
        return stateMapper.findAllState();
    }

    /**
     * 后台管理员根据条件查询用户信息
     * @author 李静
     * @param size
     * @param sizePage
     * @param userName
     * @param userState
     * @return
     */
    @Override
    public PageInfo findUserByConditions(Integer size, Integer sizePage, String userName, Integer userState) throws UserException {
        // 判断数据
        if (size == null || sizePage == null)
            throw new UserException(2004,"请求驳回！参数为空");
        if (size == 0 || sizePage == 0)
            throw new UserException(2005,"请求驳回！参数不正确");


        PageHelper pageHelper = new PageHelper();
        // 正常访问
        pageHelper.startPage(size, sizePage);
        // 条件查询
        List<User> users = userMapper.findUserByConditions(userName,userState);

        if (users.size() == 0)
            // 数据库无数据
            throw new UserException(204,"请求已处理，数据库无数据");

        return new PageInfo(users);
    }

    /**
     * 根据用户Id
     * @param userId
     * @return
     */
    @Override
    public User findUserById(Integer userId) throws UserException {

        // 验证数据 userId == null 无法判断
        if (userId.equals("") || userId == 0) {
            throw new UserException(203,"用户Id为空");
        }

        User user = userMapper.findUserById(userId);

        // 从数据库中无数据获取
        if (user == null) {
            throw new UserException(204,"请求已处理，用户不存在");
        }

        // 成功返回
        return user;
    }

    /**
     * 根据用户Id删除(假删)用户
     * @author 李静
     * @param userId
     * @return 是否删除
     */
    @Override
    public JsonResult delUserById(Integer userId) throws UserException {
        // 判断参数是否有效
        if (userId == 0 || userId == null || userId.equals("") ) {
            throw new UserException(203, "用户Id为空！");
        }

        // Id不在数据库中
        if (userMapper.delUser(userId) <= 0) {
            throw new UserException(204,"请求已处理，数据库中无此用户");
        }

        // 删除成功
        return new JsonResult(200,"删除成功");
    }

    /**
     * 根据用户id组删除(假删)用户
     * @author 李静
     * @param ids
     * @return
     */
    @Override
    public JsonResult delUsers(List<Integer> ids) throws UserException {
        // 判断参数是否有效
        if (ids.size() <= 0 || ids == null) {
            throw new UserException(207,"用户ids组参数有误");
        }
        // 参数有效
        Integer isDel = userMapper.delUsers(ids);
        System.out.println(ids);
        if (isDel == 0) {
            return new JsonResult(301,"删除失败");
        }
        return new JsonResult(200,"删除成功",isDel);
    }

    /**
     * 根据用户id恢复
     * @param userId
     * @return
     */
    public Boolean resumeUser(Integer userId) throws UserException {
        // 判断参数是否有效
        if (userId == 0 || userId == null || userId.equals("") ) {
            throw new UserException(2006,"用户Id为空");
        }
        return userMapper.resumeUser(userId) > 0 ? true : false;
    }

    /**
     * 根据用户Id删除(真删)用户
     * @author 李静
     * @param userId
     * @return 是否删除
     */
    @Override
    public Boolean deleteUserById(Integer userId) throws UserException {
        // 判断参数是否有效
        if (userId == 0 || userId == null || userId.equals("") ) {
            throw new UserException(2006,"用户Id为空");
        }

        if (userMapper.delUser(userId) <= 0) {
            throw new UserException(204,"请求已处理，无实体返回");
        }

        // 参数有效
        return true;
    }

    /**
     * 根据用户id组删除(真删)用户
     * @author 李静
     * @param ids
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteUsers(List<Integer> ids) throws UserException {
        // 判断参数是否有效
        if (ids.size() <= 0 || ids == null) {
            throw new UserException(2007,"用户ids组参数有误");
        }
        // 参数有效
        return userMapper.delUsers(ids)>0?true:false;
    }
    ///////////////////////////////////////////////////保护屏障//////////////////////////////////////////////////////////

    @Override
    public Boolean updateUser(User user) {
        Integer updateuser = userMapper.updateuser(user);
        System.out.println(updateuser);
        if (updateuser>0){
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUserid(Integer userId) {
        User user = userMapper.findUser(userId);
        if (user!=null){
            return user;
        }
        return null;
    }

    @Override
    public Integer countFants(Integer userId) {
        Integer countFants = userMapper.countFants(userId);
        return countFants;
    }

    @Override
    public Boolean updateState(Integer userId, Integer stateId) {
        return null;
    }



    //////////////////////////////////////////////////// -- 尤翔龙 -- //////////////////////////////////////////////

    /**
     * 关注用户
     * @author 尤翔龙
     * @param userId
     * @param followUserId
     * @return
     */
    @Override
    public JsonResult followUser(Integer userId, Integer followUserId) {
        if (userId==null || userId==0 || followUserId==null || followUserId==0) {
            return new JsonResult(400,"参数错误");
        }else {
            Integer nums = userMapper.followUser(userId, followUserId);
            if (nums>0) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"关注失败");
    }

    /**
     * 取消关注用户
     * @author 尤翔龙
     * @param userId
     * @param followUserId
     * @return
     */
    @Override
    public JsonResult notFollowUser(Integer userId, Integer followUserId) {
        if (userId==null || userId==0 || followUserId==null || followUserId==0) {
            return new JsonResult(400,"参数错误");
        }else {
            Integer nums = userMapper.notFollowUser(userId,followUserId);
            if (nums>0) {
                return new JsonResult(200,"success");
            }
        }
        return new JsonResult(422,"取消关注失败");
    }

//    /**
//     * 判断是否已关注
//     * @author 尤翔龙
//     * @param userId
//     * @param followUserId
//     * @return
//     */
//    @Override
//    public JsonResult isFollow(Integer userId, Integer followUserId) {
//        if (userId==null || userId==0 || followUserId==null || followUserId==0) {
//            return new JsonResult(400,"参数错误");
//        }else {
//            Integer nums = userMapper.isFollow(userId,followUserId);
//            if (nums>0) {
//                return new JsonResult(200,"success");
//            }
//        }
//        return new JsonResult(4011,"未关注");
//    }

    @Override
    public JsonResult findPostByUserId(Integer userId) {
        List<Post> post = postMapper.findByUserId(userId);
        if(post.size() == 0){
            return new JsonResult(4018,"用户没有发表帖子");
        }
        return new JsonResult(200,"查询成功",post);
    }

    @Override
    public JsonResult findPostCollectByUserId(Integer userId) {
        List<Post> post = userMapper.findCollectPostByUserId(userId);
        if(post.size() == 0){
            return new JsonResult(4019,"用户没有收藏帖子");
        }
        return new JsonResult(200,"查询成功",post);
    }


}
