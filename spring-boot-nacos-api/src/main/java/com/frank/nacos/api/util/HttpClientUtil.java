package com.frank.nacos.api.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cy
 * @version $Id: HttpClientUtil.java, v 0.1 2020年05月15日 21:19 cy Exp $
 */
@Slf4j
public class HttpClientUtil {
    /**
     * get获取最终结果
     * @param url
     * @param encoding
     * @return
     */
    public static String get(String url, String encoding) {
        log.info("HttpClient Get Url : 【{}】", url);
        // 创建http连接池
        CloseableHttpClient httpClient = null;

        // 接收返回值
        CloseableHttpResponse response = null;

        try {

            httpClient = HttpClients.custom().build();
            // 创建Http get请求
            HttpGet httpGet = new HttpGet(url);

            // 设置用户代理
            httpGet.setHeader("User-Agent", UserAgentUtil.getRandomUserAgent());

            response = httpClient.execute(httpGet);

            // 返回值
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() != 200) {
                log.error("statusLine : {}, result : {}", statusLine.getStatusCode(), response.getEntity().toString());
            }

            // 返回页面信息
            HttpEntity httpEntity = response.getEntity();
            String info = httpEntity.toString();
            if(StringUtils.isEmpty(encoding)) {
                return info;
            }
            // 处理编码格式
            String responseInfo = EntityUtils.toString(httpEntity, encoding);

            if(StringUtils.isEmpty(responseInfo)) {
                // 编写重试机制，动态更换代理
                log.error("未获取到结果，手动抛出异常，触发重试！");
            }

            // 退出前，关闭连接
            httpClient.close();
            return responseInfo;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建Httpclient发生错误，更换代理，开始重试{}", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e1) {
                log.error("重试时，关闭http连接失败！{}", e1);
                e1.printStackTrace();
                return "";
            }
        }
        return null;
    }

    /**
     * post方式获取HttpEntity
     * @param url
     * @param isProxy
     * @param parameters
     * @return
     * @throws IOException
     */
    public static HttpEntity post(String url, boolean isProxy, HashMap<String, String> parameters) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = null;
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 判断是否有代理
        httpClient = HttpClients.createDefault();
        // 伪装成浏览器
        httpPost.setHeader("User-Agent", UserAgentUtil.getRandomUserAgent());
        List<NameValuePair> params = null;
        if(parameters != null && parameters.size() > 0) {
            // 设置参数
            params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params);
            // 将参数放入Post
            httpPost.setEntity(formEntity);
        }

        // 设置响应信息
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                log.info("content: {}", content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return response.getEntity();
    }
}
