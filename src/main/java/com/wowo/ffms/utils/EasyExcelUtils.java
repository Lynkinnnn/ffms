package com.wowo.ffms.utils;

import com.alibaba.excel.ExcelReader;
import com.wowo.ffms.listener.StuDataExcelListener;
import com.wowo.ffms.listener.StuHeadExcelListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述>
 * <详细描述>
 *
 * @author sunqiming
 * @version V1.0
 * @see
 * @since
 */
public class EasyExcelUtils {

    /**
     * @Fields LOGGER : 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelUtils.class);




    /**
     * <简述> 返回ExcelReader
     * <详细描述>
     * @author lingjian
     * @param file MultipartFile 要解析的学生Excel文件
     * @param stuHeadExcelListener 解析excel
     * @return ExcelReader
     * @throws IOException io流异常抛出
     */
    public static ExcelReader getStuReader(MultipartFile file, StuHeadExcelListener stuHeadExcelListener) throws IOException {
        String filename = file.getOriginalFilename();
        if (filename != null && (filename.toLowerCase().endsWith(".xls") || filename.toLowerCase().endsWith(".xlsx"))) {
            InputStream is = new BufferedInputStream(file.getInputStream());
            return new ExcelReader(is, null, stuHeadExcelListener, false);
        } else {
            return null;
        }
    }

    /**
     * <简述> 返回ExcelReader
     * <详细描述>
     * @author lingjian
     * @param file MultipartFile 要解析的学生Excel文件
     * @param stuDataExcelListener StuDataExcelListener 解析的学生Excel
     * @return ExcelReader
     * @throws IOException io流异常抛出
     */
    public static ExcelReader getStudentReader(MultipartFile file, StuDataExcelListener stuDataExcelListener) throws IOException {
        String filename = file.getOriginalFilename();
        if (filename != null && (filename.toLowerCase().endsWith(".xls") || filename.toLowerCase().endsWith(".xlsx"))) {
            InputStream is = new BufferedInputStream(file.getInputStream());
            return new ExcelReader(is, null, stuDataExcelListener, false);
        } else {
            return null;
        }
    }
}
