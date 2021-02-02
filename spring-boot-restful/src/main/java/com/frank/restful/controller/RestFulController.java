package com.frank.restful.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 *
 * @author cy
 * @version RestFulController.java, v 0.1 2021年01月29日 5:17 下午 cy Exp $
 */
@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class RestFulController {

    @GetMapping(value = "/demo")
    @ResponseStatus(HttpStatus.OK)
    public String sendMail() {
        List<Map<String, String>> list= new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("1", "Json");
        map.put("2", "Bill");
        map.put("3", "Frank");
        list.add(map);
        //获取开始时间
        return JSON.toJSONString(list);
    }

    /**
     * 具有幂等性
     * @param id
     * @return
     */
    @GetMapping("/demo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id){

        if(null==id){
            return  null;
        }

        List<Map<String, String>> list= new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        map.put("1", "Json");
        map.put("2", "Bill");
        map.put("3", "Frank");
        list.add(map);

        AtomicReference<String> string = new AtomicReference<>("");
        map.forEach((k, v) -> {
            if(id.equals(k)) {
                string.set(v);
                return;
            }
        });
        return string;
    }

    /**
     * 新增
     * 非幂等
     * */
    @PostMapping("/demo")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody String userName){
        List<Map<String, String>> list= new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("1", "Json");
        map.put("2", "Bill");
        map.put("3", "Frank");
        //模拟向列表中增加数据
        map.put("4", userName);
        list.add(map);
        return list;
    }

    /**
     * 编辑
     * 幂等性
     * */
    @PutMapping("/demo/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object editUser(@PathVariable("id") String id, String name){
        List<Map<String, String>> list= new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("1", "Json");
        map.put("2", "Bill");
        map.put("3", "Frank");
        //模拟向列表中增加数据

        for (Map<String, String> stringMap:list) {
            if(map.containsKey(id)) {
                stringMap.put(id, name);
            }
        }
        return true;
    }

    /**
     * 删除
     * 幂等性
     * */
    @DeleteMapping("/demo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteUser(@PathVariable("id") String id){
        List<Map<String, String>> list= new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("1", "Json");
        map.put("2", "Bill");
        map.put("3", "Frank");

        map.remove(id);
        return true;
    }


}
