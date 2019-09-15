package com.frank.sb.junit.controller;

import com.frank.sb.junit.service.JunitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.junit.controller、
 * @email: cy880708@163.com
 * @date: 2019/9/15 下午4:22
 * @mofified By:
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JunitTestController.class)
public class JunitTestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JunitService junitService;

    public void setUp() {
        // 数据打桩，设置该方法返回的 body一直 是空的
        Mockito.when(junitService.junitTestServiceString("弗兰克测试")).thenReturn(new String());
    }

    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/junit"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                // JsonPath expression  https://github.com/jayway/JsonPath
                //.andExpect(jsonPath("$[1].name").exists()) // 这里是期待返回值是数组，并且第二个值的 name 存在，所以这里测试是失败的
                .andDo(print()); // 打印返回的 http response 信息
    }
}