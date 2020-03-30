package com.wowo.ffms.entity;


import com.wowo.ffms.utils.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 学生基础信息表实体类
 * <详细描述> 学生基础信息表实体类
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
@Entity
@Table(name = "th_edu_ss_student_base_info")
public class SsStudentBaseInfo extends IdEntity<Long> {

    /**
     * 名字
     */
    private String name;

    /**
     * 学籍号
     */
    private String stuStatusNum;

    /**
     * 学籍号密文
     */
    private String password;

    /**
     * 手机号
     */
    private String mPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 学段编码
     */
    private String learnSectionCode;

    /**
     * 年级编码
     */
    private String gradeCode;

    /**
     * 班级编码
     */
    private String classCode;

    /**
     * 校区编码
     */
    private String campusCode;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 学校名
     */
    private String schoolName;

    /**
     * 学校名
     */
    private String schoolId;

    /**
     * 班级名
     */
    private String className;

    /**
     * 班级id
     */
    private String classId;

    /**
     * 年级名
     */
    private String gradeName;

    /**
     * 学段名
     */
    private String learnSectionName;

    /**
     * 头像路径
     */
    private String path;

    /**
     * 是否已毕业
     */
    private Integer isGraduate;

    /**
     * 学生Uuid 唯一值
     */
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuStatusNum() {
        return stuStatusNum;
    }

    public void setStuStatusNum(String stuStatusNum) {
        this.stuStatusNum = stuStatusNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLearnSectionCode() {
        return learnSectionCode;
    }

    public void setLearnSectionCode(String learnSectionCode) {
        this.learnSectionCode = learnSectionCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getLearnSectionName() {
        return learnSectionName;
    }

    public void setLearnSectionName(String learnSectionName) {
        this.learnSectionName = learnSectionName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(Integer isGraduate) {
        this.isGraduate = isGraduate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
