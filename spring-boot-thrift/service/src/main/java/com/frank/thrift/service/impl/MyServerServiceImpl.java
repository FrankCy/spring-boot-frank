package com.frank.thrift.service.impl;

import com.frank.thrift.api.shriftcode.DataException;
import com.frank.thrift.api.shriftcode.Student;
import com.frank.thrift.api.shriftcode.StudentService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version MyServerServiceImpl.java, v 0.1 2020年12月04日 10:29 上午 cy Exp $
 */
/**
 * 服务端具体的操作的实现
 */
@Service
public class MyServerServiceImpl implements StudentService.Iface {
    @Override
    public Student getStudentByName(String name) throws DataException, TException {
        System.out.println("服务端收到客户端获取用户名:" + name + "信息");
        Student student = new Student();
        student.setName(name);
        student.setAge(100);
        student.setAddress("深圳");

        //模拟耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("模拟获取成功并返回：" + student);
        return student;
    }

    @Override
    public void save(Student student) throws DataException, TException {
        System.out.println("服务端收到客户端请求保存学生信息：" + student);
        //模拟耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("模拟保存成功!!!");
    }
}
