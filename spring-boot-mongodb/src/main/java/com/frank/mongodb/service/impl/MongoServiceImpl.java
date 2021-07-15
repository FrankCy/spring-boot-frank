package com.frank.mongodb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.frank.mongodb.entity.SmsLogEntity;
import com.frank.mongodb.service.MongoService;
import com.frank.mongodb.util.DateUtil;
import com.mongodb.DBObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        String startDate = "2020-11-01 00:00:00";
        String endDate = "2021-07-15 23:59:59";

        if(StringUtils.isBlank(type)) {
            type = "day";
        }

        // 统计信息格式
        String formatDateEx = "%Y-%m-%d";
        if("month".equals(type)) {
            formatDateEx = "%Y-%m";
        } else
        if("year".equals(type)) {
            formatDateEx = "%Y";
        }

        List<AggregationOperation> commonOperations = new ArrayList<>();

        // 显示的字段
        ProjectionOperation showField = Aggregation.project("createdTime", "callBackResultSuccess", "callBackResultError", "price")
                .and(DateOperators.DateToString.dateOf("createdTime").toString(formatDateEx)).as("sendDate");
        commonOperations.add(showField);

        // 时间判断
        if(StringUtils.isNotBlank(startDate)) {
            // createdTime是date类型，先转换成string再分组
            // TODO：也可以在创建数据时直接格式化日期，新增三个字段（日、月、年），直接通过这三个字段分组
            MatchOperation dateStartMatch = Aggregation.match(Criteria.where("createdTime").gte(DateUtil.stringToDate(startDate)));
            commonOperations.add(dateStartMatch);
        }
        if(StringUtils.isNotBlank(endDate)) {
            MatchOperation dateEndMatch = Aggregation.match(Criteria.where("createdTime").lt(DateUtil.stringToDate(startDate)));
            commonOperations.add(dateEndMatch);
        }

        SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "createdTime");
        commonOperations.add(sort);

        // 获取总记录数
        GroupOperation group = Aggregation.group("sendDate")
                // 个数
                .count().as("totalCount")
                // 成功个数
                .sum("callBackResultSuccess").as("successCount")
                // 成功个数
                .sum("callBackResultError").as("successCount")
                // 总资费
                .sum("price").as("sumPrice");
        commonOperations.add(group);

        TypedAggregation<SmsLogEntity> aggregation = Aggregation.newAggregation(SmsLogEntity.class, commonOperations);
        AggregationResults<DBObject> reminds = mongoTemplate.aggregate(aggregation, "sms_log", DBObject.class);
        List<DBObject> mappedResults = reminds.getMappedResults();
        // 检索的条目数
        log.info("list.count : {}" , mappedResults.size());

        if(mappedResults.size() > 0) {
            for(DBObject object : mappedResults) {
                log.info("{}", JSONObject.toJSONString(object));
            }
        }

    }

}
