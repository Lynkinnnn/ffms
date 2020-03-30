package com.wowo.ffms.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.wowo.ffms.annotations.IsIdCardVaild;
import com.wowo.ffms.annotations.IsVaildDate;
import com.wowo.ffms.utils.NumConstant;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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

public class StudentDto extends BaseRowModel {

    /**
     * 姓名
     */
    @ExcelProperty(index = NumConstant.I3, value = "姓名")
    @NotBlank(message = "姓名为空")
    private String name;

    /**
     * 学籍号
     */
    @ExcelProperty(index = NumConstant.I9, value = "学籍号")
    @NotBlank(message = "学籍号为空")
    private String stuStatusNum;


    /**
     * 手机号
     */
    @ExcelProperty(index = NumConstant.I7, value = "手机号")
    private String mobilePhone;

    /**
     * 邮箱
     */
    @ExcelProperty(index = NumConstant.I8, value = "邮箱")
    private String email;

    /**
     * 班号
     */
    @ExcelProperty(index = NumConstant.I2, value = "班号")
    @NotBlank(message = "班号为空")
    private String classCode;

    /**
     * 校区编码
     */
    private String campusCode;

    /**
     * 身份证号码
     */
    @ExcelProperty(index = NumConstant.I6, value = "身份证号码")
    @NotBlank(message = "身份证号为空")
    @IsIdCardVaild(message = "身份证号码不规范")
    private String idCard;

    /**
     * 学校
     */
    private String schoolName;

    /**
     * 学段
     */
    @ExcelProperty(index = 0, value = "学段")
    @NotBlank(message = "学段为空")
    private String learnSectionName;

    /**
     * 年级
     */
    @ExcelProperty(index = 1, value = "年级")
    @NotBlank(message = "年级为空")
    private String gradeName;

    /**
     * 班级
     */
    private String className;

    /**
     * 校内学号
     */
    @ExcelProperty(index = NumConstant.I10, value = "校内学号")
    private String schoolStuNum;

    /**
     * 班内学号
     */
    @ExcelProperty(index = NumConstant.I11, value = "班内学号")
    private String classStuNum;

    /**
     * 会考号
     */
    @ExcelProperty(index = NumConstant.I12, value = "会考号")
    private String examineNum;

    /**
     * 教育ID
     */
    @ExcelProperty(index = NumConstant.I13, value = "教育ID")
    private String eduNum;

    /**
     *
     * 全国学籍号
     */
    @ExcelProperty(index = NumConstant.I14, value = "全国学籍号")
    private String nationalStuNum;

    /**
     * 所属届次
     */
    private String session;

    /**
     * 入学年度
     */
    @ExcelProperty(index = NumConstant.I26, value = "入学日期")
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
     * 学生类别
     */
    @ExcelProperty(index = NumConstant.I16, value = "学生类别")
    private String stuCatagory;

    /**
     * 就读方式
     */
    @ExcelProperty(index = NumConstant.I17, value = "就读方式")
    private String studyMode;

    /**
     * 毕业去向
     */
    private String graduateDest;

    /**
     * 招生类别
     */
    @ExcelProperty(index = NumConstant.I18, value = "招生类别")
    private String recruitType;

    /**
     * 学生状态
     */
    @ExcelProperty(index = NumConstant.I22, value = "学生状态")
    private String stuStatus;

    /**
     * 受过学前教育
     */
    @ExcelProperty(index = NumConstant.I20, value = "受过学前教育")
    private String isPreschool;

    /**
     * 随班就读
     */
    @ExcelProperty(index = NumConstant.I21, value = "随班就读")
    private String isRegularStudy;

    /**
     * 姓名拼音
     */
    @ExcelProperty(index = NumConstant.I28, value = "姓名拼音")
    private String namePinyin;

    /**
     * 英文名
     */
    @ExcelProperty(index = NumConstant.I29, value = "英文名")
    private String ename;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 出生日期
     */
    @ExcelProperty(index = NumConstant.I30, value = "出生日期")
    @IsVaildDate(message = "出生日期不合法 合法出生日期为：例：2000/01/01")
    private String birthday;

    /**
     * 性别
     */
    @ExcelProperty(index = NumConstant.I4, value = "性别")
    private String sex;


    /**
     * 政治面貌
     */
    @ExcelProperty(index = NumConstant.I35, value = "政治面貌")
    private String politicsOutlook;

    /**
     * 国别
     */
    @ExcelProperty(index = NumConstant.I32, value = "国别")
    private String country;

    /**
     * 民族
     */
    @ExcelProperty(index = NumConstant.I33, value = "民族")
    private String nation;

    /**
     * 籍贯
     */
    @ExcelProperty(index = NumConstant.I34, value = "籍贯")
    private String nativePlace;


    /**
     * 户口性质
     */
    @ExcelProperty(index = NumConstant.I44, value = "户口性质")
    private String accountType;

    /**
     * 户口所在地
     */
    @ExcelProperty(index = NumConstant.I45, value = "户口所在地")
    private String accountArea;

    /**
     * 通讯地址
     */
    @ExcelProperty(index = NumConstant.I42, value = "通讯地址")
    private String postalAddress;

    /**
     * 家长
     */
    private String parent;

    /**
     * 家长身份
     */
    private String parentRela;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 是否独生子女
     */
    @ExcelProperty(index = NumConstant.I51, value = "是否独生子女")
    private String isOnlyChild;

    /**
     * 是否是孤儿
     */
    @ExcelProperty(index = NumConstant.I52, value = "是否是孤儿")
    @DateTimeFormat
    private String isOrphan;

    /**
     * 是否享受一补
     */
    @ExcelProperty(index = NumConstant.I55, value = "是否享受一补")
    private String isEnjoyPatch;

    /**
     * 是否申请补助
     */
    @ExcelProperty(index = NumConstant.I54, value = "是否申请补助")
    private String isApplySub;

    /**
     * 是否烈士子女
     */
    @ExcelProperty(index = NumConstant.I53, value = "烈士优抚子女")
    private String isMarthrChild;

    /**
     * 是否军区子女
     */
    @ExcelProperty(index = NumConstant.I56, value = "是否军区子弟")
    private String isMilitaryChild;

    /**
     * 学段编码
     */
    private String learnSectionCode;

    /**
     * 年级编码
     */
    private String gradeCode;

    /**
     * 班级id
     */
    private String classId;

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 是否毕业
     */
    private String isGraduate;

    /**
     * 密码
     */
    private String password;

    /**
     * 更新时间
     */
    private Date createAt;

    /**
     * 学生的uuid
     */
    private String uuid;

    /**
     * 有效证件类型
     */
    @ExcelProperty(index = NumConstant.I5, value = "有效证件类型")
    @NotBlank(message = "有效证件类型为空")
    private String idType;

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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLearnSectionName() {
        return learnSectionName;
    }

    public void setLearnSectionName(String learnSectionName) {
        this.learnSectionName = learnSectionName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

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

    public String getIsPreschool() {
        return isPreschool;
    }

    public void setIsPreschool(String isPreschool) {
        this.isPreschool = isPreschool;
    }

    public String getIsRegularStudy() {
        return isRegularStudy;
    }

    public void setIsRegularStudy(String isRegularStudy) {
        this.isRegularStudy = isRegularStudy;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPoliticsOutlook() {
        return politicsOutlook;
    }

    public void setPoliticsOutlook(String politicsOutlook) {
        this.politicsOutlook = politicsOutlook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountArea() {
        return accountArea;
    }

    public void setAccountArea(String accountArea) {
        this.accountArea = accountArea;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentRela() {
        return parentRela;
    }

    public void setParentRela(String parentRela) {
        this.parentRela = parentRela;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getIsOnlyChild() {
        return isOnlyChild;
    }

    public void setIsOnlyChild(String isOnlyChild) {
        this.isOnlyChild = isOnlyChild;
    }

    public String getIsOrphan() {
        return isOrphan;
    }

    public void setIsOrphan(String isOrphan) {
        this.isOrphan = isOrphan;
    }

    public String getIsEnjoyPatch() {
        return isEnjoyPatch;
    }

    public void setIsEnjoyPatch(String isEnjoyPatch) {
        this.isEnjoyPatch = isEnjoyPatch;
    }

    public String getIsApplySub() {
        return isApplySub;
    }

    public void setIsApplySub(String isApplySub) {
        this.isApplySub = isApplySub;
    }

    public String getIsMarthrChild() {
        return isMarthrChild;
    }

    public void setIsMarthrChild(String isMarthrChild) {
        this.isMarthrChild = isMarthrChild;
    }

    public String getIsMilitaryChild() {
        return isMilitaryChild;
    }

    public void setIsMilitaryChild(String isMilitaryChild) {
        this.isMilitaryChild = isMilitaryChild;
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

    public String getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(String isGraduate) {
        this.isGraduate = isGraduate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
