package com.wowo.ffms.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wowo.ffms.constant.SsStudentBaseInfoConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> excel导入监听类
 * <详细描述>
 *
 * @author lingjian
 * @version V1.0
 * @see
 * @since
 */
public class StuHeadExcelListener extends AnalysisEventListener {


    /**
     * 构造器
     */
    public StuHeadExcelListener() {
        super();
    }


    /**
     * @Fields importHeads : 导入表头
     */
    private String importHeads;

    /**
     * @Fields idcardHeadIndex : 身份证号表头序号
     */
    private Integer idcardHeadIndex;

    /**
     * @Fields idcardHeadName : 身份证号表头名称
     */
    private String idcardHeadName;


    /**
     * @Fields total : 总量
     */
    private Integer total;

    /**
     * @Fields isLegal : 模板是否合法
     */
    private boolean isLegal = false;

    /**
     * @Fields illegalInfo : 模板非法信息
     */
    private String illegalInfo;


    /**
     * <简述> 监听excel中每一行数据进行自定义处理
     * <详细描述>
     * @author sunqiming
     * @param o Object excel中每一行数据
     * @param analysisContext AnalysisContext analysisContext
    */
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        total = analysisContext.getTotalCount();
        setTotal(total);
        Integer currentRowNum = analysisContext.getCurrentRowNum();
        // 获取导入表头，默认第二行为表头
        if (currentRowNum == 1) {
            importHeads = StringUtils.join((List<String>) o, ",");
            checkExcelTemplate(SsStudentBaseInfoConstants.STU_IMPORT_EXCEL_HEAD);
        }
    }

    /**
     * <简述> 验证模板表头是否合法
     * <详细描述>
     * @author sunqiming
     * @param excelHead String[] 模板表头
    */
    public void checkExcelTemplate(String[] excelHead) {
        List<String> tempHead = Arrays.asList(excelHead);
        if (importHeads.equals(StringUtils.join(tempHead, ","))) {
            isLegal = true;
        } else {
            illegalInfo = "导入模板有误";
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }





    public boolean isLegal() {
        return isLegal;
    }

    public void setLegal(boolean legal) {
        isLegal = legal;
    }


    public String getImportHeads() {
        return importHeads;
    }

    public void setImportHeads(String importHeads) {
        this.importHeads = importHeads;
    }

    public Integer getIdcardHeadIndex() {
        return idcardHeadIndex;
    }

    public void setIdcardHeadIndex(Integer idcardHeadIndex) {
        this.idcardHeadIndex = idcardHeadIndex;
    }

    public String getIdcardHeadName() {
        return idcardHeadName;
    }

    public void setIdcardHeadName(String idcardHeadName) {
        this.idcardHeadName = idcardHeadName;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getIllegalInfo() {
        return illegalInfo;
    }

    public void setIllegalInfo(String illegalInfo) {
        this.illegalInfo = illegalInfo;
    }

}
