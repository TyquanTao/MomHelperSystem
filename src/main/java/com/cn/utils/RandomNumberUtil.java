package com.cn.utils;

/**
 * Created with IntelliJ IDEA.
 * User: wmy
 * Date: 2019/11/28 16:03
 * Description:
 */
public class RandomNumberUtil {


    public static   String getCode(){
        String vcode = "";
        for (int i = 0;i < 6 ;i ++){
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
