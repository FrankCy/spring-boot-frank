package com.frank.sb.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 使用JPA注解配置映射关系
 */

@Entity         //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user")       //指定和哪个数据表对应；如果省略name属性，表名默认就是首字母小写的类名
public class User {

    /**
     * 指定这是主键
     */
    @Id
    // 自增策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 指定这是表中的一个列
     */
    @Column(name = "last_name",length = 50)
    private String lastName;

    /**
     * name属性省略默认就是属性名
     */
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}