# Spring Boot —— Mybatis-plus
- - -
## 简介
通过MybatisPlus实现CRUD

## 集成步骤
### 加依赖
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>2.3</version>
</dependency>
<!-- freemarker -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
</dependency>
<!-- fastjson -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.70</version>
</dependency>
```
### 加配置
```yaml
# mysql
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/frank-dao-user?useUnicode=true&characterEncoding=utf8
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver

# mybaties-plus
mybatis-plus:
  mapper-locations: classpath:com/frank/mybatisplus/mapper/xml/*.xml
  type-aliases-package: com.frank.mybatisplus.entity
  configuration:
    map-underscore-to-camel-case: true
```
### 加注解
没注解需要加
### 使用生成器
```java

package com.frank.mybatisplus.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 *
 * 代码生成器
 *
 * @author cy
 * @version MpGenerator.java, v 0.1 2020年10月20日 15:40 cy Exp $
 */
public class MpGenerator {

    public static void main(String[] args) {
        //        assert (false) : "代码生成属于危险操作，请确定配置后取消断言执行代码生成！";
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Cyoung");
        gc.setOutputDir("/Users/cy/project/spring-boot-frank/spring-boot-mybatis-plus/src/main/java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/frank-dao-user?useUnicode=true&characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "permission_", "role_", "user_", "user_group_", "user_login_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.nochange);// 表名生成策略
        strategy.setInclude(new String[] { "permission", "role", "user", "user_group", "user_login" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.frank.mybatisplus");
        // pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        // InjectionConfig cfg = new InjectionConfig() {
        // @Override
        // public void initMap() {
        // Map<String, Object> map = new HashMap<String, Object>();
        // map.put("abc", this.getConfig().getGlobalConfig().getAuthor() +
        // "-mp");
        // this.setMap(map);
        // }
        // };
        //
        // // 自定义 xxList.jsp 生成
        // List<FileOutConfig> focList = new ArrayList<>();
        // focList.add(new FileOutConfig("/template/list.jsp.vm") {
        // @Override
        // public String outputFile(TableInfo tableInfo) {
        // // 自定义输入文件名称
        // return "D://my_" + tableInfo.getEntityName() + ".jsp";
        // }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);
        //
        // // 调整 xml 生成目录演示
        // focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
        // @Override
        // public String outputFile(TableInfo tableInfo) {
        // return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
        // }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);
        //
        // // 关闭默认 xml 生成，调整生成 至 根目录
        // TemplateConfig tc = new TemplateConfig();
        // tc.setXml(null);
        // mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
        // System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}

```
### 执行生成器
**```执行生成器main函数，就会生成对应的代码了，注意修改生成器的配置，以及yaml中的配置路径```**

## 测试的数据结构SQL
```sql
/*
 Navicat Premium Data Transfer

 Source Server         : frank_mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost
 Source Database       : frank-dao-user

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : utf-8

 Date: 10/20/2020 16:01:33 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` bigint(20) unsigned NOT NULL COMMENT '创建者的用户ID',
  `description` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '权限描述',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` bigint(20) unsigned NOT NULL COMMENT '最后修改者的用户ID',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值，0表示已删除，1表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` bigint(20) unsigned NOT NULL COMMENT '创建者的用户ID',
  `description` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '角色描述',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` bigint(20) unsigned NOT NULL COMMENT '最后修改者的用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值，0表示已删除，1表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  `creator` bigint(20) unsigned NOT NULL COMMENT '创建者的用户ID',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` bigint(20) unsigned NOT NULL COMMENT '最后修改者的用户ID',
  `signature_of_personality` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '个性签名',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值，0表示已删除，1表示正常',
  `user_name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `user_group`
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `creator` bigint(20) unsigned NOT NULL COMMENT '创建者的用户ID',
  `description` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户组描述',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` bigint(20) unsigned NOT NULL COMMENT '最后修改者的用户ID',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值，0表示已删除，1表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `creator` bigint(20) unsigned NOT NULL COMMENT '创建者的用户ID',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` bigint(20) unsigned NOT NULL COMMENT '最后修改者的用户ID',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `passwd` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '密码（加盐后MD5）',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态值，0表示已删除，1表示正常',
  `type` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '类型（admin：管理员；operator：运营；scm：软件配置管理员（配置管理员））',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;

```