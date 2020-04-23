package com.whvcse.my.shop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
/**
 * TODO: HttpClient工具类
 * @author JavaMan
 * @date 2020/3/31 13:19
 * @since: 1.0.0
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";
    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";

    /**
     * GET请求
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return createHttpClient(url,GET,null);
    }

    /**
     * GET请求(带有cookie)
     * @param url
     * @param cookie
     * @return
     */
    public static String doGet(String url,String cookie) {
        return createHttpClient(url,GET,cookie);
    }

    /**
     * POST请求
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url,BasicNameValuePair...params) {
        return createHttpClient(url,POST,null,params);
    }

    /**
     * POST请求(带有cookie)
     * @param url
     * @param cookie
     * @param params
     * @return
     */
    public static String doPost(String url,String cookie,BasicNameValuePair...params) {
        return createHttpClient(url,POST,cookie,params);
    }


    /**
     *
     * @param url  请求地址
     * @param requestMethod   请求方式
     * @param cookie    cookie
     * @param params  请求参数（可选）
     * @return
     */
    public static String createHttpClient(String url, String requestMethod,String cookie, BasicNameValuePair... params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;
        try {
            HttpGet httpGet = null;
            HttpPost httpPost = null;
            //响应
            CloseableHttpResponse response = null;
            //请求结果
            result = null;
            //GET请求
            if (GET.equals(requestMethod)) {
                httpGet = new HttpGet(url);
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpGet.setHeader("Cookie", cookie);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                response = httpClient.execute(httpGet);
            }
            //POST请求
            else if (POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpPost.setHeader("Cookie", cookie);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);

                //有参数进来
                if (params != null && params.length > 0) {
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params)));

                    response = httpClient.execute(httpPost);
                }
            }
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
