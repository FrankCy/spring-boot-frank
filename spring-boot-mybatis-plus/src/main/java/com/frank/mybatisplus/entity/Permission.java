package com.frank.mybatisplus.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cyoung
 * @since 2020-10-20
 */
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建者的用户ID
     */
    private Long creator;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date gmt_create;

    /**
     * 最后修改时间
     */
    private Date gmt_modified;

    /**
     * 最后修改者的用户ID
     */
    private Long modifier;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", creator=" + creator +
        ", description=" + description +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        ", modifier=" + modifier +
        ", status=" + status +
        "}";
    }
}
