package com.cn.exception;
import com.cn.dto.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器: 捕获所有的异常
 * @author:Teacher黄
 * @date:Created at 2019/11/27
 * 捕获妈妈帮平台可能出现的所有异常，要使用时，自己添加相关配置
 */
@RestControllerAdvice
public class AllExceptionHandler {
    /**
     * 处理异常(例子)
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public JsonResult ExceptionHand(Exception e){
        // 进行一些异常的信息封装
        // 记录服务处的错误日志
        // 错误代码
        Integer code = 0;
        // 返回给前端的错误信息
        return new JsonResult(code,e.getMessage());
    }

    /**
     * 处理异常
     * @param e
     * @return
     */
    @ExceptionHandler(JwtException.class)
    public JsonResult JwtExceptionHand(JwtException e){
        // 进行一些异常的信息封装
        // 记录服务处的错误日志
        // 返回给前端的错误信息
        return new JsonResult(e.getCode(),e.getMsg());
    }


    /**
     * 处理用户数据异常
     * @param e
     * @author 李静
     * @return
     */
    @ExceptionHandler(UserException.class)
    public JsonResult UserExceptionHand(UserException e) {
        return new JsonResult(e.getCode(),e.getMsg());
    }

}
