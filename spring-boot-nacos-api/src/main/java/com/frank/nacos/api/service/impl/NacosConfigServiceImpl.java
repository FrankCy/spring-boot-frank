package com.frank.nacos.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.frank.nacos.api.service.NacosConfigService;
import com.frank.nacos.api.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version NacosConfigServiceImpl.java, v 0.1 2021年02月25日 2:07 下午 cy Exp $
 */
@Slf4j
@Service
public class NacosConfigServiceImpl implements NacosConfigService {

    private static final String HOST = "http://localhost:8848/";

    private static final String METHOD = "nacos/v1/cs/configs";

    private static final String NAMESPACE = "cy-namespace";

    private static final String TARGET_CONFIG = "nacos_config_test.yaml";

    private static final String GROUP = "DEFAULT_GROUP";

    private static final String URL = HOST+METHOD+"?show=all&dataId="+TARGET_CONFIG+"&group="+GROUP+"&tenant="+NAMESPACE;

    @Override
    public String findNacosConfig() {
        String result = HttpClientUtil.get(URL,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(result);
        String content = jsonObject.getString("content");
        log.info("result.content -> {}", content);

        String[] contentArr = content.split("\n");
        for(String contentstring : contentArr) {
            // 过滤注释的行
            if(contentstring.contains("#")) {
                continue;
            }
            // contentstring.split("  ").length： 代表层级
            log.info("contentString :{} -> {}", contentstring, contentstring.split("  ").length);
            // 处理空格，看每行有多少空格

        }
        return result;
    }


}
