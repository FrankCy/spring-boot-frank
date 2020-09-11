package com.frank.sb.base62;

import io.seruco.encoding.base62.Base62;

/**
 *
 *
 * @author cy
 * @version Test.java, v 0.1 2020年09月11日 10:27 cy Exp $
 */
public class Test {

    public static void main(String[] args) {
        String string = "学习进行时】赴一线视察调研防汛救灾工作、围绕谋划国家“新发展阶段”主持召开重磅座谈会、出席中央第七次西藏工作座谈会并发表重要讲话……8月，习近平总书记的各项重要活动意义重大。新华社《学习进行时》原创品牌栏目“讲习所”推出文章，为您梳理回顾。";
        System.out.println(string.length());
        Base62 base62 = Base62.createInstance();
        final byte[] encoded = base62.encode(string.getBytes());
        String encodeString = new String(encoded);
        System.out.println(encodeString.length());

        final byte[] decoded = base62.decode(encodeString.getBytes());
        String decodedString = new String(decoded);
        System.out.println(decodedString);
    }
}
