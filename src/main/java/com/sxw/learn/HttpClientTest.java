package com.sxw.learn;

import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.http.HttpClient;

public class HttpClientTest {
    @SneakyThrows
    public static void main(String[] args) {
        HttpGet get = new HttpGet("http://www.baidu.com");
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .build();
        get.setConfig(config);
        CloseableHttpClient client = HttpClientBuilder.create()
                .setMaxConnTotal(1 << 6)
                .setMaxConnPerRoute(1 << 3)
                .evictExpiredConnections()
                .build();
        HttpResponse response = client.execute(get);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
