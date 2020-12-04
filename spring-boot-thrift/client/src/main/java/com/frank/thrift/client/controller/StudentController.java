package com.frank.thrift.client.controller;

import com.frank.thrift.api.shriftcode.Student;
import com.frank.thrift.client.service.StudentServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author cy
 * @version StudentController.java, v 0.1 2020年12月04日 11:00 上午 cy Exp $
 */
@RestController
@RequestMapping("thrift")
public class StudentController {

    @Autowired
    StudentServiceInf studentService;

    @GetMapping("get")
    public Student getStudeByName(String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("save")
    public Student save() {
        //直接模拟前端传递的数据
        Student student = new Student();
        student.setName("AAA");
        student.setAge(10);
        student.setAddress("BBB");
        //调用保存服务
        studentService.save(student);
        return student;
    }
}
