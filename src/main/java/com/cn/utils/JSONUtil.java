/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: JSONUtil
 * Author:   李俊
 * Date:     2019/11/27 20:04
 * Description: JSON工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.cn.utils;

import net.sf.json.JSONObject;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈JSON工具类〉
 *
 * @author 李俊
 * @create 2019/11/27
 * @since 1.0.0
 */
public class JSONUtil {
    //T是随便定义的泛型，你根据自己需要自己定义类型
    //doList是json类型字符串
    /**
     * 功能描述: <br>
     * 〈将json字符串转换成对应的类型〉
     *
     * @param jsonStr    json字符串
     * @return:
     * @since: 1.0.0
     * @Author:李俊
     * @Date: 2019/11/27 20:06
     */
     public static JSONObject doObject(String jsonStr){
         JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        return jsonObject;
    }
    /**
     * 功能描述: <br>
     * 〈将对应json字符串中字段名为“ids”的id数组转换为List<Integer>类型〉
     *
     * @param jsonStr   json字符串
     * @return:
     * @since: 1.0.0
     * @Author:李俊
     * @Date: 2019/11/28 11:17
     */
    public static List<Integer> doIds(String jsonStr){
        List<Integer> ids = (List<Integer>) doObject(jsonStr).get("ids");
        if (ids!=null && ids.size()>0){
            return ids;
        }
        return null;
    }
}
