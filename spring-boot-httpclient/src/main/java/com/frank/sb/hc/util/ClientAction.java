package com.frank.sb.hc.util;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cy
 * @version HttpClientAction.java, v 0.1 2021年06月09日 1:59 下午 cy Exp $
 */
public class ClientAction {

    public static void main(String[] args) {
        exportData();
    }

    private static void exportData() {

        HttpClientContext clientContext = HttpClientContext.create();

        // 传递cookie，实例化一个cookie，然后下面的所有请求都使用这一个，就会透传到下面所有函数中
        BasicCookieStore cookieStore = new BasicCookieStore();
        
        clientContext.setCookieStore(cookieStore);
        
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        /******** 第一步：LOGIN *********/
        String username = "bigdata";
        String passwd = "Bigdata_2021";

        // 目标url
        String loginUrl = "http://xxxx:xxxx/xxx";

        // 请求正文
        Map<String, String> loginParam = new HashMap<>();
        loginParam.put("xxx", username);
        loginParam.put("xxx", passwd);
        loginParam.put("xxx", " ");
        loginParam.put("xxs", " ");

        // cookie参数拼接
        String cookies = "abc=123; "
                + "bac=213; "
                + "cba=321";

        // header封装
        Header[] headers = {
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Accept-Language", "zh-CN"),
                new BasicHeader("Referer", "xxxxx"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/7.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)"),
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cache-Control", "no-cache"),
                // 放入cookie
                new BasicHeader("Cookie", cookies)
        };

        Map<String, Object> loginResultMap = ClientUtil.doPost(loginUrl, loginParam, headers, cookieStore, clientContext, httpClient);
        Map<String, String> loginMap = new HashMap<>();
        CloseableHttpResponse response = null;
        List<Cookie> cookieArrayList = new ArrayList<>();
        if(loginResultMap.size() > 0) {
            loginMap = analysisLoginXml(String.valueOf(loginResultMap.get("resultString")));
            response = (CloseableHttpResponse)loginResultMap.get("response");
            cookieArrayList = (List)loginResultMap.get("cookies");
        }

        // 输出Cookie
        for(Cookie cookie : cookieArrayList) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        // token
        String ssoToken = loginMap.get("token");
        System.out.println("ssoToken : " + ssoToken);

        // user
        String user = loginMap.get("user");
        System.out.println("user : " + user);

        // assertertoken
        String assertertoken = loginMap.get("assertertoken");
        System.out.println("assertertoken : " + assertertoken);

    }

    /**
     * 解析xml
     * @param xml
     */
    private static Map<String, String> analysisLoginXml(String xml) {
        Map<String, String> result = new HashMap<>();
        Document document = Jsoup.parse(xml);
        result.put("token", printElement(document, "token"));
        result.put("user", printElement(document, "user"));
        result.put("assertertoken", printElement(document, "assertertoken"));
        return result;
    }


    private static String splitData(String str, String strStart, String strEnd) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }

    private static String printElement(Document document, String targetElementName) {
        Elements elements = document.getElementsByTag(targetElementName);
        if(elements.size() > 0) {
            Element element = elements.get(0);
            String eContent = element.text();
            return eContent;
        } else {
            System.out.println("没有找到数据："+ targetElementName);
        }
        return "";
    }

}
