package com.frank.sb.jpa.repository;

import com.frank.sb.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: spring-boot-frank
 * @Package: com.frank.sb.jpa.repository
 * @ClassName: UserRepository
 * @Author: cy
 * @Description: 继承JpaRepository来完成对数据库的操作
 * @Date: 2020-04-21 18:19
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
