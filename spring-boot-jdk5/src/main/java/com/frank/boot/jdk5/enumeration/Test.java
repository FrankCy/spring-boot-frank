package com.frank.boot.jdk5.enumeration;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author cy
 * @version Test.java, v 0.1 2020年12月25日 3:23 下午 cy Exp $
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        EnumDes man = EnumDes.valueOf("MAN");
        log.info("valueOf MAN -> {}", man);
        EnumDes woman = EnumDes.valueOf("WOMAN");
        log.info("valueOf WOMAN -> {}", woman);

        EnumDes[] enumDes = EnumDes.values();
        for(EnumDes enumDesFor : enumDes) {
            log.info("for Enum -> {}", enumDesFor);
        }

        System.out.println("---------------------------------- 下面是一个enum工具类 ---------------------------------- ");

        EnumExample[] enumExamples = EnumExample.values();
        for(EnumExample enumExample: enumExamples) {
            log.info("for EnumExample code -> {}; us -> {} ; cn -> {}", enumExample.code(),enumExample.reasonPhraseUS(), enumExample.reasonPhraseCN());
        }
    }

}
