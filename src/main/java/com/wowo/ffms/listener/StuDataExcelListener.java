package com.wowo.ffms.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wowo.ffms.dto.StudentDto;
import com.wowo.ffms.service.SsStudentBaseInfoService;
import com.wowo.ffms.utils.NumConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

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
public class StuDataExcelListener extends AnalysisEventListener<StudentDto> {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StuDataExcelListener.class);

    /**
     * 该学校下所有的班级年级数据
     */
    private List<Map<String, Object>> classAndGradeInfos;

    /**
     * 唯一校验信息数据
     */
    private List<Map<String, Object>> uniqueInfos;

    /**
     * 学生基本信息
     */
    private SsStudentBaseInfoService ssStudentBaseInfoService;

    /**
     * 数字字典数据
     */
    private List<Map<String, Object>> dictDatas;

//
//    /**
//     * 班级信息service
//     */
//    private SsClassService ssClassService;

    /**
     * 学生学校信息
     */
    private Map<String, Object> schoolInfo;


    /**
     * @Fields isLegal : 模板是否合法
     */
    private boolean isLegal = true;

    /**
     * @Fields illegalInfo : 模板非法信息
     */
    private String illegalInfo;



    /**
     * 用于存放excel数据的dto类
     */
    List<StudentDto> studentDtos = new ArrayList<StudentDto>();


    /**
     * @Fields importHeads : 导入表头
     */
    private String importHeads;

    /**
     * @Fields total : 总量
     */
    private Integer total;

    public StuDataExcelListener() {
        super();

    }


    @Override
    public void invoke(StudentDto studentDto, AnalysisContext analysisContext) {

        System.out.println(analysisContext.getCurrentRowNum());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        setTotal(analysisContext.getTotalCount());
    }




    /**
     * <简述> 解析数据为是否的字段
     * <详细描述>是返回0 否返回1
     *
     * @author lingjian
     * @param data 行数据
     * @return 对应的数据
     */
    public String isOrNo(String data) {
        if (StringUtils.isNotBlank(data)) {
            if ("是".equals(data)) {
                return "0";
            } else if ("否".equals(data)) {
                return "1";
            } else {
                return "1";
            }
        }
        return "1";
    }



    /**
     * <简述> 解析空值null替换成""
     * <详细描述>
     *
     * @author lingjian
     * @param studentDto 需要解析的对象
     * @return 对应的数据
     */
    public StudentDto checkNull(StudentDto studentDto) {
        Class< ? extends Object> clazz = studentDto.getClass();
        // 获取实体类的所有属性，返回Field数组
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 可访问私有变量
            field.setAccessible(true);
            // 获取属性类型
            String type = field.getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if ("class java.lang.String".equals(type)) {
                // 将属性的首字母大写
                String methodName = field.getName().replaceFirst(field.getName().substring(0, 1),
                        field.getName().substring(0, 1).toUpperCase());
                try {
                    Method methodGet = clazz.getMethod("get" + methodName);
                    // 调用getter方法获取属性值
                    String str = (String) methodGet.invoke(studentDto);
                    if (StringUtils.isBlank(str)) {
                        // Method methodSet = clazz.getMethod("set" +
                        // methodName, new Class[] { String.class });
                        // methodSet.invoke(o, new Object[] { "" });
                        // 如果为null的String类型的属性则重新复制为空字符串
                        field.set(studentDto, field.getType().getConstructor(field.getType()).newInstance(""));
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return studentDto;
    }


    /**
     * 〈简述〉校验学生字段是否唯一
     * 〈详细描述〉
     *
     * @author lingjian
     * @param fieldName 字段名
     * @param value 字段值
     * @return 学生个人信息
     */
    public Boolean isUnique(String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            for (Map<String, Object> uniqueInfo : uniqueInfos) {
                if (value.equals(uniqueInfo.get(fieldName))) {
                    return false;
                }
            }
        } else {
            return true;
        }
        return true;
    }



    public boolean isLegal() {
        return isLegal;
    }

    public void setLegal(boolean legal) {
        isLegal = legal;
    }

    public String getIllegalInfo() {
        return illegalInfo;
    }

    public void setIllegalInfo(String illegalInfo) {
        this.illegalInfo = illegalInfo;
    }

    public List<StudentDto> getStudentDtos() {
        return studentDtos;
    }

    public void setStudentDtos(List<StudentDto> studentDtos) {
        this.studentDtos = studentDtos;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
