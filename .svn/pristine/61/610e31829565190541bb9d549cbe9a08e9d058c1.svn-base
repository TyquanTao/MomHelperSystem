package com.cn.dao;

import com.cn.pojo.Post;
import com.cn.pojo.Register;
import com.cn.pojo.User;
import com.cn.pojo.UserState;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface UserMapper {

    /**
     * 通过账号密码登录
     * @param user
     * @return
     */
    /*public User login(String userPhone,String password);*/
    public User login(User user);


    /**
     * 注册用户
     * @param user
     * @return
     */
    public Integer adduser(User user);


    /**
     * 通过User的id判断user的当前状态
     * @param userId
     * @return
     */
    public UserState decideState(Integer userId);

    /**
     * 通过用户id修改用户当前的状态和当前状态的时间
     * @param userId
     * @return
     */
    public Integer updateState(Integer userId, Integer stateid, Timestamp starttime);

    /**
     * 通过userId 查询userState
     * @param userId
     * @return
     */
    UserState findUserStateStateId(@Param("userId") Integer userId);


    /**
     * 通过用户的id查询用户
     * @param userId
     * @return
     */

    public User findUser(Integer userId);
    /**
     * 修改用户的资料
     * @param user
     * @return
     */
    public Integer updateuser(User user);

    /**
     * 通过用户的id统计该用户的粉丝数量
     * @param userId
     * @return
     */
    public Integer countFants(Integer userId);

    /**
     * 根据用户呢称模糊查询用户
     * @param userName
     * @return
     */
    List<User> findByUserName(@Param(value = "userName") String userName);


    /**
     * 通过手机号查询临时注册表
     * @param phone
     * @return
     */
    public Register findRegister(String phone);


    /**
     * 修改注册表的信息
     * @param register
     * @return
     */
    public Integer updateRegister(Register register);

    /**
     * 往临时表添加记录
     * @param register
     * @return
     */
    public Integer addRegister(Register register);

    /**
     * 判断手机号和验证码能否对应
     * @param register
     * @return
     */
    public Register findRegisterAll(Register register);


    /**
     * 通过ID查询User(一对一关系)
     * @author 尤翔龙
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);

    /**
     * 关注用户
     * @author 尤翔龙
     * @param userId
     * @param followUserId
     * @return
     */
    Integer followUser(@Param(value = "userId") Integer userId,@Param(value = "followUserId")Integer followUserId);

    /**
     * 取消关注用户
     * @author 尤翔龙
     * @param userId
     * @param followUserId
     * @return
     */
    Integer notFollowUser(@Param(value = "userId") Integer userId,@Param(value = "followUserId")Integer followUserId);

    /**
     * 判断是否已关注
     * @author 尤翔龙
     * @param userId
     * @param followUserId
     * @return
     */
    Integer isFollow(@Param(value = "userId") Integer userId,@Param(value = "followUserId")Integer followUserId);





    ////////////////////////////////////////////////////管理员操作----李静的Mapper/////////////////////////////////////////
    /**
     * 查找所有用户
     * @author 李静
     * @return
     */
    public List<User> findAllUser();

    /**
     * 查找被删除的用户
     * @author 李静
     * @return
     */
    public List<User> findAllDelUser();


    /**
     * 后台管理员根据条件查询用户信息
     * @author 李静
     * @param userName : 用户姓名
     * @param stateId ： 用户状态
     * @return
     */
    public List<User> findUserByConditions(@Param(value = "userName")String userName,
                                           @Param(value = "stateId")Integer stateId);


    /**
     * 根据用户Id
     * @author 李静
     * @param userId : 用户id
     * @return
     */
    public User findUserById(@Param(value = "userId") Integer userId);


    /**
     * 根据用户Id删除(假删)用户
     * @author 李静
     * @param userId : 用户id
     * @return
     */
    public Integer delUser(@Param(value = "userId") Integer userId);


    /**
     * 根据用户Id组删除(假删)用户
     * @author 李静
     * @param ids : 用户Id组
     * @return
     */
    public Integer delUsers(@Param(value = "ids") List<Integer> ids);


    /**
     * 根据用户Id恢复被删除的用户
     * @author 李静
     * @param userId : 用户id
     * @return ：影响的行数
     */
    public Integer resumeUser(@Param(value = "userId") Integer userId);


    /**
     * 根据用户Id删除(真删)用户
     * @author 李静
     * @param userId : 用户id
     * @return
     */
    public Integer deleteUser(@Param(value = "userId") Integer userId);


    /**
     * 根据用户Id组删除(真删)用户
     * @author 李静
     * @param ids : 用户Id组
     * @return
     */
    public Integer deleteUsers(@Param(value = "ids") List<Integer> ids);

    ///////////////////////////////////////////////////管理员操作----李静的Mapper//////////////////////////////////////////

    public Integer updateState(Integer userId,Integer stateid);

    /**
     * 查询用户收藏的所有帖子
     * @param userId
     * @return
     */
    List<Post> findCollectPostByUserId(Integer userId);
}
