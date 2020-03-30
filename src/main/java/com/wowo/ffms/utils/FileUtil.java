package com.wowo.ffms.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by lenovo12 on 2018/8/18.
 */
public final  class FileUtil {
    private FileUtil(){}

    /**
     * 获取后缀
     * @param fileName 文件名
     * @return 后缀名
     */
    public static String getFileSuffix(String fileName){
        if(StringUtil.isEmpty(fileName) || fileName.lastIndexOf(".")<0 ){
            return "error";
        }
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
