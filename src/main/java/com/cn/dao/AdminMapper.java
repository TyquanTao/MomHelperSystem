package com.cn.dao;

import com.cn.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/28 9:32
 * Description: 管理员Mapper
 */
public interface AdminMapper {

    /**
     * 根据呢称查找用户
     * @param adminName
     * @return
     */
    Admin findByAdminName(String adminName);


    /**
     * 根据账号和电话号码查询用户
     * @param adminName
     * @param adminPhone
     * @return
     */
    Admin findByAdminNameAndAdminPhone(
            @Param(value = "adminName") String adminName,
            @Param(value = "adminPhone") String adminPhone);


    /**
     * 修改密码
     * @param adminId
     * @param adminPassword
     * @return
     */
    Integer updateAdminPassword(
            @Param(value = "adminId") Integer adminId,
            @Param(value = "adminPassword") String adminPassword);

    /**
     * 通过Id查询用户
     * @param adminId
     * @return
     */
    Admin findByAdminId(Integer adminId);

    /**
     * 修改个人信息
     * @param admin
     * @return
     */
    Integer updateAdminMessage(Admin admin);

    /**
     * 判断电话号码是否已经注册
     * @param adminPhone
     * @return
     */
    Admin findByAdminPhone(String adminPhone);

    ////////////////////////////////////////////////////管理员操作----李静的Mapper/////////////////////////////////////////
    /**
     * 查找所有管理员
     * @author 李静
     * @return
     */
    public List<Admin> findAllAdmin();

    /**
     * 查找被删除的管理员
     * @author 李静
     * @return
     */
    public List<Admin> findAllDelAdmin();


    /**
     * 后台管理员根据条件查询管理员信息
     * @author 李静
     * @param adminName : 管理员姓名
     * @param adminNickName ： 管理员昵称
     * @return
     */
    public List<Admin> findAdminByConditions(@Param(value = "adminName") String adminName,
                                             @Param(value = "adminNickName") String adminNickName);


    /**
     * 根据管理员Id
     * @author 李静
     * @param adminId : 管理员id
     * @return
     */
    public Admin findAdminById(@Param(value = "adminId") Integer adminId);


    /**
     * 根据管理员Id删除(假删)管理员
     * @author 李静
     * @param adminId : 用户id
     * @return
     */
    public Integer delAdmin(@Param(value = "adminId") Integer adminId);


    /**
     * 根据管理员Id组删除(假删)管理员
     * @author 李静
     * @param ids : 管理员Id组
     * @return
     */
    public Integer delAdmins(@Param(value = "ids") List<Integer> ids);


    /**
     * 根据管理员Id恢复被删除的管理员
     * @author 李静
     * @param adminId : 管理员id
     * @return ：影响的行数
     */
    public Integer resumeAdmin(@Param(value = "adminId") Integer adminId);


    /**
     * 根据管理员Id删除(真删)管理员
     * @author 李静
     * @param adminId : 管理员id
     * @return
     */
    public Integer deleteAdmin(@Param(value = "adminId") Integer adminId);


    /**
     * 根据管理员Id组删除(真删)管理员
     * @author 李静
     * @param ids : 管理员Id组
     * @return
     */
    public Integer deleteAdmins(@Param(value = "ids") List<Integer> ids);

    /**
     * 新增管理员
     * @author 李静
     * @param admin : 要添加的管理员
     * @return
     */
    public Integer addAdmin(Admin admin);

    ///////////////////////////////////////////////////管理员操作----李静的Mapper//////////////////////////////////////////


}
