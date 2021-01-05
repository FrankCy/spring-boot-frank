package com.frank.excerpt.test1.after;

import com.frank.excerpt.test1.before.GeneralChannelRule;
import com.frank.excerpt.test1.before.TencentChannelRule;
import com.frank.excerpt.test1.before.TouTiaoChannelRule;

/**
 *
 *
 * @author cy
 * @version ChannelRuleEnum.java, v 0.1 2021年01月05日 2:03 下午 cy Exp $
 */
public enum ChannelRuleEnum {

    /**
     * 头条
     */
    TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    /**
     * 腾讯
     */
    TENCENT("TENCENT",new TencentChannelRule()),
    ;

    public String name;

    public GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    //匹配
    public static ChannelRuleEnum match(String name){
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if(value.name.equals(name)){
                return value;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }

}
