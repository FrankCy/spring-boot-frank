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
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 地址
     */
    private String address;

    /**
     * 年龄
     */
    private Integer age;

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
     * 个性签名
     */
    private String signature_of_personality;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    private Integer status;

    /**
     * 用户名
     */
    private String user_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
    public String getSignature_of_personality() {
        return signature_of_personality;
    }

    public void setSignature_of_personality(String signature_of_personality) {
        this.signature_of_personality = signature_of_personality;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", address=" + address +
        ", age=" + age +
        ", creator=" + creator +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        ", modifier=" + modifier +
        ", signature_of_personality=" + signature_of_personality +
        ", status=" + status +
        ", user_name=" + user_name +
        "}";
    }
}
