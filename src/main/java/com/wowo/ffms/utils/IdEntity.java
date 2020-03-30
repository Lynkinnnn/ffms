//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wowo.ffms.utils;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class IdEntity<ID extends Serializable> {
    private static final long serialVersionUID = -1907420656600668218L;
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private ID id;
    @DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
        updatable = false
    )
    private Date createAt;
    @Column(
        updatable = false
    )
    private Long creator;
    @Column(
        updatable = false
    )
    private String creatorName;
    @DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private Long updater;
    private String updaterName;
    private Integer isDisabled = 0;

    public IdEntity() {
    }

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdater() {
        return this.updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Integer getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(Integer isDisabled) {
        this.isDisabled = isDisabled;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdaterName() {
        return this.updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }
}
