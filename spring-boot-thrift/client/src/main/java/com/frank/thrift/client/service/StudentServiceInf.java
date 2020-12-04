package com.frank.thrift.client.service;

import com.frank.thrift.api.shriftcode.Student;

/**
 *
 *
 * @author cy
 * @version StudentServiceInf.java, v 0.1 2020年12月04日 10:55 上午 cy Exp $
 */
public interface StudentServiceInf {
    /**
     * 根据名称获取学生信息
     * @param name
     * @return
     */
    Student getStudentByName(String name);

    /**
     * 保存学生信息
     * @param student
     */
    void save(Student student);
}
