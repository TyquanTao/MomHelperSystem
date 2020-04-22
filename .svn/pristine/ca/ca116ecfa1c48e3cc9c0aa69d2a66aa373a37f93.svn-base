package com.cn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理String工具类
 * @author 周鑫
 */
public class StringUtil {

    /**
     * 将形如"1,2,3,4,5"的字符串转为List数组
     * 周鑫
     * @param ids ids字符串
     * @return
     */
   public static List<Integer>  conversionIds(String ids){
       String[] idSplit = ids.split(",");
       List<Integer> list = new ArrayList<>();
       for (String id : idSplit) {
           list.add(Integer.valueOf(id));
       }
       return list;
   }
}
