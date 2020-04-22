package com.cn.service;

import com.aliyuncs.exceptions.ClientException;
import com.cn.dto.JsonResult;
import com.cn.pojo.Admin;
import com.cn.pojo.Register;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/28 9:39
 * Description:
 */
public interface AdminService {

    /**
     * 登录
     *
     * @param adminName
     * @param password
     * @return
     */
    JsonResult<Admin> login(String adminName, String password);

    /**
     * 通过账号和密码查找admin
     *
     * @param adminName
     * @return
     */
    JsonResult<Admin> findByAdminName(String adminName, String adminPhone) throws ClientException;

    /**
     * 修改密码
     *
     * @param adminId
     * @param adminPassword
     * @return
     */
    JsonResult<Admin> updateAdminPassword(Integer adminId, String adminPassword);

    /**
     * 验证验证码是否正确
     *
     * @param register
     * @return
     */
    JsonResult judgeCode(Register register);

    /**
     * 查询自己的资料
     *
     * @param adminId
     * @return
     */
    JsonResult findByadminId(Integer adminId);

    /**
     * 修改个人资料
     *
     * @param admin
     * @return
     */
    JsonResult updateMyselfe(Admin admin, MultipartFile header);

    Boolean addRegister(Register register);

    //////////////////////////////////李静的Admin相关操作/////////////////////////////////////////////////////////////////


    /**
     * 查找所有管理员(含分页)
     *
     * @param size
     * @param sizePage
     * @return
     * @author 李静
     */
    public PageInfo findAllAdmin(Integer size, Integer sizePage);

    /**
     * 查找被删除的管理员(含分页)
     *
     * @param size
     * @param sizePage
     * @return
     * @author 李静
     */
    public PageInfo findAllDelAdmin(Integer size, Integer sizePage);

    /**
     * 后台管理员根据条件查询用户信息
     *
     * @param size
     * @param sizePage
     * @param
     * @param
     * @return
     * @author 李静
     */
    public PageInfo findAdminByConditions(Integer size, Integer sizePage, String userName, Integer userState);

    /**
     * 根据管理员Id
     *
     * @param adminId
     * @return
     * @author 李静
     */
    public JsonResult findAdminById(Integer adminId);


    /**
     * 根据管理员Id删除(假删)管理员
     *
     * @param adminId
     * @return 是否删除
     * @author 李静
     */
    public JsonResult delAdminById(Integer adminId);


    /**
     * 根据管理员id组删除(假删)管理员
     *
     * @param ids
     * @return
     * @author 李静
     */
    public JsonResult delAdmins(List<Integer> ids);


    /**
     * 根据管理员id恢复
     *
     * @param adminId
     * @return
     */
    public JsonResult resumeAdmin(Integer adminId);

    /**
     * 根据管理员Id删除(真删)管理员
     *
     * @param adminId
     * @return 是否删除
     * @author 李静
     */
    public JsonResult deleteAdminById(Integer adminId);


    /**
     * 根据管理员id组删除(真删)管理员
     *
     * @param ids
     * @return 是否删除成功
     * @author 李静
     */
    public JsonResult deleteAdmins(List<Integer> ids);


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
