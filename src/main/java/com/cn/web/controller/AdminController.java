package com.cn.web.controller;

import com.aliyuncs.exceptions.ClientException;
import com.cn.dto.JsonResult;
import com.cn.groups.Login;
import com.cn.groups.Update;
import com.cn.pojo.Admin;
import com.cn.pojo.Register;
import com.cn.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/27 10:43
 * Description: 管理员
 */

@RestController
@Api(tags = "文茂宇—管理员API",value = "管理员入口")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param adminName
     * @param adminPassword
     * @return
     */

        @PostMapping("/admin/login")
        @ApiOperation(value = "管理员登录方法")
        @ApiImplicitParams({
                @ApiImplicitParam(paramType = "query",name = "adminName",value = "管理员呢称",required = true,dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "adminPassword",value = "管理员密码",required = true,dataType = "String")
        })
        public JsonResult login(@RequestParam(value = "adminName")  String adminName,
                                @RequestParam(value = "adminPassword") String adminPassword){

            return adminService.login(adminName,adminPassword);
        }


    @PostMapping("/admin/login1")
    @ApiOperation(value = "管理员登录方法（Json 传入数据）")
    @ApiImplicitParam(paramType = "body",name = "admin",value = "管理员对象",required = true,dataType = "Admin")
    public JsonResult login1(@RequestBody  Admin admin){

        return adminService.login(admin.getAdminName(),admin.getAdminPassword());
    }

    /**
     * 查看自己的资料
     * @param adminId
     * @return
     */
    @GetMapping("/admin/findMyselfMessage")
    @ApiOperation(value = "查看自己的资料")
    @ApiImplicitParam(paramType = "query",name = "adminId",value = "管理员自己的Id",required = true,dataType = "int")
    public JsonResult findMyselfMessage(@RequestParam(value = "adminId") Integer adminId){
        return adminService.findByadminId(adminId);
    }

    /**
     * 修改个人信息
     * @param adminId
     * @param adminNickName
     * @param adminPhone
     * @param header
     * @return
     */
        @PostMapping("admin/updateMyselfMessage")
        @ApiOperation(value = "修改信息")
        @ApiImplicitParams({

                @ApiImplicitParam(paramType = "query",name = "adminId",value = "管理员Id",required = true,dataType = "int"),
                @ApiImplicitParam(paramType = "query",name = "adminNickName",value = "管理员呢称",required = true,dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "adminPhone",value = "管理员电话",required = true,dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "header",value = "头像上传框的name",required = true,dataType = "MultiparFile")
        })

        public JsonResult update(@RequestParam(value = "adminId") Integer adminId,
                                 @RequestParam(value = "adminNickName")  String adminNickName,
                                 @RequestParam(value = "adminPhone")  String adminPhone,
                                 @RequestParam(value = "header") MultipartFile header){
            System.out.println("-------------");
            System.out.println(adminService.findByadminId(adminId));
            System.out.println(adminNickName);
            return adminService.updateMyselfe(new Admin(adminId,adminNickName,adminPhone,""),header);
        }


    /**
     * 忘记密码，用账号，和手机号验证发送验证码
     * @param adminName
     * @param adminPhone
     * @return
     */
        @GetMapping("admin/sendCode")
        @ApiOperation(value = "发送验证码")
        @ApiImplicitParams({
                @ApiImplicitParam(paramType = "query",name = "adminName",value = "管理员账号",required = true,dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "adminPhone",value = "管理员电话",required = true,dataType = "String")
        })
        public JsonResult sendCode(
                @RequestParam(value = "adminName")  String adminName,
                @RequestParam(value = "adminPhone")  String adminPhone) throws ClientException {
            return adminService.findByAdminName(adminName,adminPhone);
        }

    /**
     * 验证验证码
     * @param adminPhone
     * @param code
     * @return
     */
        @PostMapping("admin/judgeCode")
        @ApiOperation(value = "验证验证码是否正确")
        @ApiImplicitParams({
           @ApiImplicitParam(paramType = "query",name = "adminPhone",value = "管理员电话",required = true,dataType = "String"),
           @ApiImplicitParam(paramType = "query",name = "code",value = "验证码",required = true,dataType = "String")

        })
        public JsonResult judgeCode(
                @RequestParam(value = "adminPhone")  String adminPhone,
                @RequestParam(value = "code") String code){
            return adminService.judgeCode(new Register(adminPhone,code));
        }

    @PostMapping("admin/judgeCode1")
    @ApiOperation(value = "验证验证码是否正确(Json)")
    @ApiImplicitParam(paramType = "body",name = "register",value = "电话验证码",required = true,dataType = "Register")
    public JsonResult judgeCode1(@RequestBody Register register){
        return adminService.judgeCode(register);
    }

    /**
     * 修改密码
     * @param adminId
     * @param adminPassword
     * @return
     */
        @PostMapping("admin/updatePassword")
        @ApiOperation(value = "修改密码")
        @ApiImplicitParams({
                @ApiImplicitParam(paramType = "query",name = "adminId",value = "管理员id",required = true,dataType = "Integer"),
                @ApiImplicitParam(paramType = "query",name = "adminPassword",value = "管理员密码",required = true,dataType = "String")
        })
        public JsonResult updateAdminPassword(
                @RequestParam(value = "adminId") Integer adminId,
                @RequestParam(value = "adminPassword")
                String adminPassword){
            return adminService.updateAdminPassword(adminId,adminPassword);
        }




}
