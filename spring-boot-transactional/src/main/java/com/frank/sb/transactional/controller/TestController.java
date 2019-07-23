package com.frank.sb.transactional.controller;

import com.frank.sb.transactional.entity.po.Company;
import com.frank.sb.transactional.entity.po.Dept;
import com.frank.sb.transactional.entity.po.User;
import com.frank.sb.transactional.service.CompanyService;
import com.frank.sb.transactional.service.DeptService;
import com.frank.sb.transactional.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.controller、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:20
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private static final Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DeptService deptService;

    @ResponseBody
    @RequestMapping(value = "demo", method = RequestMethod.POST)
    @Transactional
    public String index() {
        logger.info("测试事务隔离问题 ------ begin");
        User user = new User();
        user.setUid(getUUID());
        user.setUcode(getUUID());
        user.setUname("用户名称");
        user.setUamount(1);
        int userCount = userService.insertSelective(user);
        logger.info("---- user count ---- : " + userCount);

        Company company = new Company();
        company.setcId(getUUID());
        company.setcCode("公司编码");
        company.setcName("我是公司");
        company.setcDes("公司描述信息");
        int companyCount = companyService.insertSelective(company);
        logger.info("---- company count ---- : " + companyCount);

        Dept dept = new Dept();
        dept.setDid(getUUID());
        dept.setDdes("部门信息");
        int deptCount = deptService.insertSelective(dept);
        logger.info("---- dept count ---- : " + deptCount);

        logger.info("测试事务隔离问题 ------ end");
        return "处理完啦";
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
