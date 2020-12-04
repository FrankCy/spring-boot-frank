//这里指明了代码生成之后,所处的文件路径
namespace java com.frank.thrift.api.shriftcode
namespace py py.com.frank.thrift.api.shriftcode

//将shrift的数据类型格式转换为java习惯的格式
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
