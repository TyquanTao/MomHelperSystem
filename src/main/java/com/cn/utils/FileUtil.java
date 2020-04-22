package com.cn.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 文件处理工具
 * @Author Poor
 * @CreateTime 2019-11-20
 */
public class FileUtil {

    /**
     * UUID生成文件名
     * @return
     */
    public static String getFileName() {
        // 通过UUID生成文件名
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 获取文件的后缀
     * @param filename
     * @return
     */
    public static String getSuffix(String filename) {
        // 1. 先判断文件名是否含有后缀,以及文件名是否合法
//        filename.isEmpty()  -- value.length == 0;
        if (filename.contains(".") && filename != null && !filename.isEmpty()) {
            // 2. 获取后缀
            return filename.substring(filename.lastIndexOf("."));
        }
        // 判断是否是文件，当然不是!这只是个名字
        return null;
    }

    /**
     * 获取上传路径
     * 以日期为标准
     * @return
     */
    public static String getDataFilePath() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/");
        return format.format(new Date());
    }

    /**
     * 创建文件夹
     * @param filepath : 文件路径
     */
    public static void createDirs(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            // 除非JVM，应会创建成功
            file.mkdirs();
        }
    }
}
