package com.frank.excerpt.test1.before;

/**
 *
 * 1、首先构建一个 GeneralChannelRule 基础规则抽象类，定义一个抽象方法process()，不同的渠道都需要实现该抽象方法。
 *
 * @author cy
 * @version GeneralChannelRule.java, v 0.1 2021年01月05日 1:59 下午 cy Exp $
 */
public abstract class GeneralChannelRule {
    public abstract void process();
}