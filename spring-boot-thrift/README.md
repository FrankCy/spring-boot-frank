# Spring Boot Thrift
- - -
## 简介

## 干什么？
1.先配置Thrift
```shell script
> brew install thrift
> thrift --version
# 显示下面内容则是安装成功
Thrift version 0.13.0
```
2.编辑thrift demo
```shell script
# 规则
实现服务发布、服务订阅、调用的客户端
```
3.thrift是通过命令 thrift解析编译的框架支持好多好多语言，详看简介，所以先编辑一个thrift：
```thrift
//这里指明了代码生成之后,所处的文件路径
namespace java com.lupf.thriftserver.shriftcode
namespace py py.com.lupf.thriftserver.shriftcode

//将thrift的数据类型格式转换为java习惯的格式
typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

//定义学生对象
struct Student {
    1:optional String name,
    2:optional int age,
    3:optional String address
}

//定义数据异常
exception DataException {
    //optional 可选 非必传
    1:optional int code,
    2:optional String message,
    3:optional String dateTime
}

//定义操作学生的服务
service StudentService {
    //根据名称获取学生信息 返回一个学生对象  抛出DataException异常
    //required 必传项
    Student getStudentByName(1:required String name) throws (1:DataException dataException),

    //保存一个学生信息 无返回 抛出DataException异常
    void save(1:required Student student) throws (1:DataException dataException)
}
```
4.通过命令触发构建这段代码，会生成我们的目录结构...结果参照项目目录机构
```shell script
# 构建成java，在根目录下会根据编辑的内容构建出目录结构
thrift --gen java student.thrift 
```
***注***
```
不要以任何的理由去修改这部分自动生成的代码，一方面很复杂，另一方面，再次生成的时候，你所调整的修改将会丢失

文件说明:
DataException.java -> 异常对象
- - -
Student.java -> 交互的数据模型对象
- - -
StudentService.java -> 服务对象，提供了接口，客户端连接相关方法
```

# 参照
[CSDN - SpringBoot整合RPC框架---Thrift](https://blog.csdn.net/lupengfei1009/article/details/100934794)