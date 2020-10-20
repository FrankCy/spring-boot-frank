package com.frank.mybatisplus.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cyoung
 * @since 2020-10-20
 */
@TableName("user_login")
public class Login extends Model<Login> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 创建者的用户ID
     */
    private Long creator;

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
     * 名称
     */
    private String name;

    /**
     * 密码（加盐后MD5）
     */
    private String passwd;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    private Integer status;

    /**
     * 类型（admin：管理员；operator：运营；scm：软件配置管理员（配置管理员））
     */
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Login{" +
        "id=" + id +
        ", account=" + account +
        ", creator=" + creator +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        ", modifier=" + modifier +
        ", name=" + name +
        ", passwd=" + passwd +
        ", status=" + status +
        ", type=" + type +
        "}";
    }
}
