package com.frank.sb.hc.util;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cy
 * @version HttpClientUtil.java, v 0.1 2021年06月09日 1:58 下午 cy Exp $
 */
public class ClientUtil {

    public static Map<String, Object> doGet(String url, Map<String, String> param, Header[] headers, BasicCookieStore cookieStore, HttpClientContext clientContext, CloseableHttpClient httpClient) {
        Map<String, Object> resultMap = new HashMap<>();

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            if (headers != null) {
                httpGet.setHeaders(headers);
            }

            // 发起请求
            if (null != clientContext) {
                response = httpClient.execute(httpGet, clientContext);
            } else {
                response = httpClient.execute(httpGet);
            }

            // 判断返回状态是否为200
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        resultMap.put("resultString", resultString);
        resultMap.put("response", response);
        resultMap.put("store", cookieStore);
        resultMap.put("cookies", cookieStore.getCookies());

        return resultMap;
    }

    public static Map<String, Object> doPost(String url, Map<String, String> param, Header[] headers, BasicCookieStore cookieStore, HttpClientContext clientContext, CloseableHttpClient httpClient) {
        Map<String, Object> resultMap = new HashMap<>();

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 插入请求头
            if (headers != null) {
                httpPost.setHeaders(headers);
            }

            // 发起请求
            if (null != clientContext) {
                response = httpClient.execute(httpPost, clientContext);
            } else {
                response = httpClient.execute(httpPost);
            }

            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        resultMap.put("resultString", resultString);
        resultMap.put("response", response);
        resultMap.put("store", cookieStore);
        resultMap.put("cookies", cookieStore.getCookies());

        return resultMap;
    }

}