package com.frank.mongodb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.frank.mongodb.pojo.SmsLogResult;
import com.frank.mongodb.service.MongoService;
import com.frank.mongodb.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version MongoServiceImpl.java, v 0.1 2021年07月14日 5:20 下午 cy Exp $
 */
@Slf4j
@Service
public class MongoServiceImpl implements MongoService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void statisticsTariff() {

        // 类型（day：天；month：月；year：年）
        String type = "day";
        String startDate = "2009-11-01 00:00:00";
        String endDate = "2021-07-15 23:59:59";

        if(StringUtils.isBlank(type)) {
            type = "day";
        }

        if(StringUtils.isBlank(startDate)) {
            startDate = "1970-01-01 00:00:00";
        }
        if(StringUtils.isBlank(endDate)) {
            endDate = DateUtil.getCurrentTime();
        }

        Aggregation eatAggregation = Aggregation.newAggregation(
                //查询条件
                Aggregation.match(Criteria.where("createdTime").gte(startDate).lte(endDate)),
                // price不等于空
                Aggregation.match(Criteria.where("price").exists(true)),
                // callBackSize不等于空
                Aggregation.match(Criteria.where("callBackSize").exists(true)),
                //查询项
                Aggregation.project(type, "callBackResultSuccess", "callBackResultError", "price")
                        // 求乘积，并强转数据
                        .andExpression("multiply('$price', { $toInt: '$callBackSize' })").as("sumPrice"),
                //分组条件和聚合项
                Aggregation.group(type)
                        // 个数
                        .count().as("totalCount")
                        // 成功个数
                        .sum("callBackResultSuccess").as("successCount")
                        // 失败个数
                        .sum("callBackResultError").as("errorCount")
                        // 总资费
                        .sum("sumPrice").as("sumPrice"));
        AggregationResults<SmsLogResult> eatOutputType = mongoTemplate.aggregate(eatAggregation, "sms_log", SmsLogResult.class);

        List<SmsLogResult> mappedResults = eatOutputType.getMappedResults();

        log.info("检索 {} 条数据", mappedResults.size());
        for(SmsLogResult smsLogResult : mappedResults) {
            log.info("JSON: {}", JSONObject.toJSON(smsLogResult));
        }
    }

}
