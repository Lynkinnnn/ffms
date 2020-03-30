package com.wowo.ffms.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述>
 * <详细描述>
 *
 * @author jinshengri
 * @version V1.0
 * @see
 * @since
 */
public class TemplateConstants {

    /**
     * @Fields templateNameMap : 模板路径集合
     */
    public static final Map<String, String> templatePathMap = new HashMap<String, String>() {
        {
            put(BJ_TEMPLATE_CODE, BJ_TEMPLATE_PATH);
            put(XS_TEMPLATE_CODE, XS_TEMPLATE_PATH);
        }
    };

    /**
     * @Fields templateNameMap : 模板名称集合
     */
    public static final Map<String, String> templateNameMap = new HashMap<String, String>() {
        {
            put(BJ_TEMPLATE_CODE, BJ_TEMPLATE_NAME);
            put(XS_TEMPLATE_CODE, XS_TEMPLATE_NAME);
        }
    };

    /**
     * @Fields BJ_TEMPLATE_CODE : 班级列表导入模板编码
     */
    public static final String BJ_TEMPLATE_CODE = "BJ_TEMPLATE";

    /**
     * @Fields ZZLB_TEMPLATE_NAME : 资助列表导入模板路径
     */
    public static final String BJ_TEMPLATE_PATH = "excelTemplates/export_class.xlsx";

    /**
     * @Fields ZZLB_TEMPLATE_NAME : 资助列表导入模板名称
     */
    public static final String BJ_TEMPLATE_NAME= "班级导入模板.xlsx";

    /**
     * @Fields BJ_TEMPLATE_CODE : 学生列表导入模板编码
     */
    public static final String XS_TEMPLATE_CODE = "XS_TEMPLATE";

    /**
     * @Fields BJ_TEMPLATE_CODE : 班级列表导入模板路径
     */
    public static final String XS_TEMPLATE_PATH = "excelTemplates/export_student.xlsx";

    /**
     * @Fields BJ_TEMPLATE_CODE : 班级列表导入模板名称
     */
    public static final String XS_TEMPLATE_NAME = "学生导入模板.xlsx";
}
