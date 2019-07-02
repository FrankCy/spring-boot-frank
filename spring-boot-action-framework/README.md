# Spring Boot 实战基础框架 #

## 前言 ##
搭建一个基础的Spring Boot框架，可作为软件研发的基础开发平台使用。

## 项目介绍 ##
### 客户端 ###
|名称|描述|
|:--|:--|
|boot-action-app| 提供外部APP接口的移动端客户端 |
|boot-action-pc| 门户客户端 |
|boot-action-admin| 后台管理客户端 |
### 公共组件 ###
|名称|描述|
|:--|:--|
|boot-action-service|实际业务处理类|
|boot-action-commons|工具类|
|boot-action-dao|实际与数据库发生交互的组件|
|boot-action-entity|包含po，jo的实体组件（可以引入Swagger2，用于文档生成）|

## 设计理念 ##
- 公共组件由service为首，将commons -> dao -> entity 依照顺序通过maven，配置依赖到service内。
- 客户端，可以水平扩展（提高客户端负载均衡，实际投产可通过Nginx做软负载。将公共组件service依赖至客户端。
- 如果实际业务需要service分离（为将来服务化做准备），可以将不同的业务分别开发出多个service组件，再通过maven配置依赖到客户端，未来服务化（spring cloud）时，可以将这些服务独立出来，通过Feign进行配置使用。

