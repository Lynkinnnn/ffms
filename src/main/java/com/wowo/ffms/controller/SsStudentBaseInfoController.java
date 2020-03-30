package com.wowo.ffms.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.wowo.ffms.dto.StudentDto;
import com.wowo.ffms.entity.SsStudentBaseInfo;
import com.wowo.ffms.listener.StuDataExcelListener;
import com.wowo.ffms.listener.StuHeadExcelListener;
import com.wowo.ffms.service.SsStudentBaseInfoService;
import com.wowo.ffms.utils.EasyExcelUtils;
import com.wowo.ffms.utils.NumConstant;
import org.jodconverter.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述>
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
@RequestMapping("/ssStudentBaseInfo")
@Controller
public class SsStudentBaseInfoController {

    /**
     * ssStudentBaseInfoService 学生基本信息服务层
     */
    @Autowired
    private SsStudentBaseInfoService ssStudentBaseInfoService;




    /**
     * <简述> 上传文件，导入数据
     * <详细描述>
     * @author lingjian
     *
     * @param file MultipartFile 上传的文件
     * @param schoolId Long 学校id
     * @return 导入信息
     */
    @RequestMapping("/readExcel")
    @ResponseBody
    public String readExcel(MultipartFile file, Long schoolId) {
        long start = System.currentTimeMillis();
        try {
            long start1 = System.currentTimeMillis();
            StuHeadExcelListener stuHeadExcelListener = new StuHeadExcelListener();
            StuDataExcelListener stuDataExcelListener = new StuDataExcelListener();
            ExcelReader headReader = EasyExcelUtils.getStuReader(file, stuHeadExcelListener);
            long end1 = System.currentTimeMillis();
            System.out.println("获取数据时间==================" + (end1 = start1) + "ms");
            //第一次 解析验证表头
            headReader.read((new Sheet(1, 1)));

            if (stuHeadExcelListener.isLegal()) {
                //如果验证表头合法 进行表内容读
                //第二次 解析数据
                ExcelReader dataReader = EasyExcelUtils.getStudentReader(file, stuDataExcelListener);
                if (dataReader == null) {
                    return "导入失败";
                }
                //从第三行开始解析
                dataReader.read(new Sheet(1, NumConstant.I2, StudentDto.class));
                //判断是否是空表
                if (stuHeadExcelListener.getTotal() == NumConstant.I2) {
                    return "导入失败，导入列表为空";
                }

                long end = System.currentTimeMillis();
                System.out.println("导入用时======================" + (end - start) + "ms");
                return "导入成功";
            } else {
                return stuHeadExcelListener.getIllegalInfo();
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "导入失败";
        }
    }




}

