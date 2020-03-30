package com.wowo.ffms.entity;


import com.wowo.ffms.utils.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 学生校内信息表实体类
 * <详细描述> 学生校内信息表实体类
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
@Entity
@Table(name = "th_edu_ss_stu_inschool_info")
public class SsStuInschoolInfo extends IdEntity<Long> {

    /**
     * 校内学号
     */
    private String schoolStuNum;

    /**
     * 班内学号
     */
    private String classStuNum;

    /**
     * 教育ID
     */
    private String eduNum;

    /**
     * 会考号
     */
    private String examineNum;

    /**
     *
     * 全国学籍号
     */
    private String nationalStuNum;

    /**
     * 所属界次
     */
    private String session;

    /**
     * 入学年度
     */
    private String entranceYear;

    /**
     * 在校状态
     */
    private String inSchoolStatus;

    /**
     * 在籍状态
     */
    private String residenceStatus;

    /**
     * 就读方式
     */
    private String studyMode;

    /**
     * 学生类别
     */
    private String stuCatagory;

    /**
     * 毕业去向
     */
    private String graduateDest;

    /**
     * 招生类别
     */
    private String recruitType;

    /**
     * 学生状态
     */
    private String stuStatus;

    /**
     * 受过学前教育
     */
    private Integer isPreschool;

    /**
     * 随班就读
     */
    private Integer isRegularStudy;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 学生Uuid 唯一值
     */
    private String uuid;

    public String getSchoolStuNum() {
        return schoolStuNum;
    }

    public void setSchoolStuNum(String schoolStuNum) {
        this.schoolStuNum = schoolStuNum;
    }

    public String getClassStuNum() {
        return classStuNum;
    }

    public void setClassStuNum(String classStuNum) {
        this.classStuNum = classStuNum;
    }

    public String getEduNum() {
        return eduNum;
    }

    public void setEduNum(String eduNum) {
        this.eduNum = eduNum;
    }

    public String getExamineNum() {
        return examineNum;
    }

    public void setExamineNum(String examineNum) {
        this.examineNum = examineNum;
    }

    public String getNationalStuNum() {
        return nationalStuNum;
    }

    public void setNationalStuNum(String nationalStuNum) {
        this.nationalStuNum = nationalStuNum;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(String entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getInSchoolStatus() {
        return inSchoolStatus;
    }

    public void setInSchoolStatus(String inSchoolStatus) {
        this.inSchoolStatus = inSchoolStatus;
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    public String getStuCatagory() {
        return stuCatagory;
    }

    public void setStuCatagory(String stuCatagory) {
        this.stuCatagory = stuCatagory;
    }

    public String getGraduateDest() {
        return graduateDest;
    }

    public void setGraduateDest(String graduateDest) {
        this.graduateDest = graduateDest;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public Integer getIsPreschool() {
        return isPreschool;
    }

    public void setIsPreschool(Integer isPreschool) {
        this.isPreschool = isPreschool;
    }

    public Integer getIsRegularStudy() {
        return isRegularStudy;
    }

    public void setIsRegularStudy(Integer isRegularStudy) {
        this.isRegularStudy = isRegularStudy;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
