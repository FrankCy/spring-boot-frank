package com.frank.sb.admin.client;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version $Id: Question.java, v 0.1 2020年06月05日 11:21 cy Exp $
 */
public class Question implements Serializable {


    private String seq;

    private String question;

    private String ans;

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
