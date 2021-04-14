package com.example.demo.utils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author 夏龙
 * @date 2021-04-02
 */
public class test {

    /**
     * @param url 访问地址
     * @param headerMap  header 参数；可以通过下面工具类将string类型转换成map
     * @param contentMap 需要传输参数参数；对象可以通过json转换成map
     * @return 返回网页返回的数据
     */
    public static String postMap(String url, Map<String, String> headerMap, Map<String, String> contentMap) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> content = new ArrayList<NameValuePair>();
        //将content生成entity
        Iterator iterator = contentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> elem = (Entry<String, String>) iterator.next();
            content.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            //循环增加header
            Iterator headerIterator = headerMap.entrySet().iterator();
            while (headerIterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) headerIterator.next();
                post.addHeader(elem.getKey(), elem.getValue());
            }
            if (content.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(content, "UTF-8");
                post.setEntity(entity);
            }
            //发送请求并接收返回数据
            response = httpClient.execute(post);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                //获取response的body部分
                HttpEntity entity = response.getEntity();
                //读取reponse的body部分并转化成字符串
                result = EntityUtils.toString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
