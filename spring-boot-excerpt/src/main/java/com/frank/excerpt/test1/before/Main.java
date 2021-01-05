package com.frank.excerpt.test1.before;

/**
 *
 *
 * @author cy
 * @version Main.java, v 0.1 2021年01月05日 2:02 下午 cy Exp $
 */
public class Main {

    public static void main(String[] args) {

        /**
         * before
         */
        //这里我们模拟接收到的数据，其渠道为为TOUTIAO，来自头条的数据
        //String sign = "TOUTIAO";
        //GeneralChannelRule rule;
        ////根据对应渠道获取对应的具体规则实现类
        //if (ChannelRuleEnum.TENCENT.code.equals(sign)) {
        //    rule = new TencentChannelRule();
        //} else if (ChannelRuleEnum.TOUTIAO.code.equals(sign)) {
        //    rule = new TouTiaoChannelRule();
        //} else {
        //    //匹配不到
        //}
        ////执行
        //rule.process();

        /**
         * after
         */
        String sign = "TOUTIAO";
        com.frank.excerpt.test1.after.ChannelRuleEnum channelRule = com.frank.excerpt.test1.after.ChannelRuleEnum.match(sign);
        GeneralChannelRule rule = channelRule.channel;
        rule.process();
    }

}
