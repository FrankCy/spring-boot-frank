package com.frank.lru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author cy
 * @version LruController.java, v 0.1 2020年06月23日 11:55 cy Exp $
 */
@RestController
@RequestMapping("/")
public class LruController {

    @GetMapping("/getMap")
    public String getMap() {
        System.out.println("getMap");
        return "getMap";
    }

    @PostMapping("/postMap")
    public String postMap() {
        System.out.println("postMap");
        return "postMap";
    }


}
