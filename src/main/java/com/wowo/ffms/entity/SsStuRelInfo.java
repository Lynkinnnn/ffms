package com.wowo.ffms.entity;


import com.wowo.ffms.utils.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 学生个人相关信息表实体类
 * <详细描述> 学生个人相关信息表实体类
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
@Entity
@Table(name = "th_edu_ss_stu_rel_info")
public class SsStuRelInfo extends IdEntity<Long> {

    /**
     * 姓名拼音
     */
    private String namePinyin;

    /**
     * 英文名
     */
    private String ename;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 有效证件类型
     */
    private String idType;

    /**
     * 有效证件号
     */
    private String idCard;

    /**
     * 政治面貌
     */
    private String politicsOutlook;

    /**
     * 国籍
     */
    private String country;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 招生类别
     */
    private String recruitType;

    /**
     * 户口性质
     */
    private String accountType;

    /**
     * 户口所在地
     */
    private String accountArea;

    /**
     * 通讯地址
     */
    private String postalAddress;

    /**
     * 家长
     */
    private String parent;

    /**
     * 家长身份
     */
    private Integer parentRela;
    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 是否独生子女
     */
    private Integer isOnlyChild;

    /**
     * 是否是孤儿
     */
    private Integer isOrphan;

    /**
     * 是否享受一补
     */
    private Integer isEnjoyPatch;

    /**
     * 是否申请补助
     */
    private Integer isApplySub;

    /**
     * 是否烈士子女
     */
    private Integer isMarthrChild;

    /**
     * 是否军区子女
     */
    private Integer isMilitaryChild;

    /**
     * 学生Uuid 唯一值
     */
    private String uuid;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
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

    public Integer getParentRela() {
        return parentRela;
    }

    public void setParentRela(Integer parentRela) {
        this.parentRela = parentRela;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getIsOnlyChild() {
        return isOnlyChild;
    }

    public void setIsOnlyChild(Integer isOnlyChild) {
        this.isOnlyChild = isOnlyChild;
    }

    public Integer getIsOrphan() {
        return isOrphan;
    }

    public void setIsOrphan(Integer isOrphan) {
        this.isOrphan = isOrphan;
    }

    public Integer getIsEnjoyPatch() {
        return isEnjoyPatch;
    }

    public void setIsEnjoyPatch(Integer isEnjoyPatch) {
        this.isEnjoyPatch = isEnjoyPatch;
    }

    public Integer getIsApplySub() {
        return isApplySub;
    }

    public void setIsApplySub(Integer isApplySub) {
        this.isApplySub = isApplySub;
    }

    public Integer getIsMarthrChild() {
        return isMarthrChild;
    }

    public void setIsMarthrChild(Integer isMarthrChild) {
        this.isMarthrChild = isMarthrChild;
    }

    public Integer getIsMilitaryChild() {
        return isMilitaryChild;
    }

    public void setIsMilitaryChild(Integer isMilitaryChild) {
        this.isMilitaryChild = isMilitaryChild;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
