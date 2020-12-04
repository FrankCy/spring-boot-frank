package com.frank.thrift.client.service;

import com.frank.thrift.api.shriftcode.Student;
import com.frank.thrift.client.core.ThriftClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version StudentServiceImpl.java, v 0.1 2020年12月04日 10:59 上午 cy Exp $
 */
@Service
public class StudentServiceImpl implements StudentServiceInf {

    @Autowired
    ThriftClient thriftClient;

    @Override
    public Student getStudentByName(String name) {
        try {
            thriftClient.open();
            System.out.println("客户端请求用户名为:" + name + "的数据");
            Student student = thriftClient.getService().getStudentByName(name);
            System.out.println("获取成功！！！服务端返回的对象:" + student);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
        return null;
    }

    @Override
    public void save(Student student) {
        try {
            thriftClient.open();
            System.out.println("客户端请求保存对象:" + student);
            thriftClient.getService().save(student);
            System.out.println("保存成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thriftClient.close();
        }
    }
}
