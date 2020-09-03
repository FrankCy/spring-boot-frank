package com.frank.boot.custom.maven.action.impl;

import com.frank.boot.custom.maven.action.service.ActionService;
import com.frank.boot.custom.maven.assembly.impl.XfServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version ActionService.java, v 0.1 2020年09月03日 17:07 cy Exp $
 */
@Slf4j
@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private XfServiceImpl xfService;

    @Override
    public String sendMail(String to, String title, String content) {
        return xfService.say();
    }
}
