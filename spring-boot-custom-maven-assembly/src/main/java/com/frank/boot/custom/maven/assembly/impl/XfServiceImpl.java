package com.frank.boot.custom.maven.assembly.impl;

import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version XfServiceImpl.java, v 0.1 2020年09月03日 13:32 cy Exp $
 */
@Service("xfServiceImpl")
public class XfServiceImpl {

    private String msg;

    private String toWho;

    public XfServiceImpl() {
    }

    public XfServiceImpl(String msg, String toWho) {
        this.msg = msg;
        this.toWho = toWho;
    }

    public  String say(){
        return  this.msg+","+this.toWho;
    }
}
