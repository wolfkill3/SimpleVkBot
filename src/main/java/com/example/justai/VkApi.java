package com.example.justai;

import java.io.*;

import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public final class VkApi {
    private static final String URI = "https://api.vk.com/method/messages.send";
    private final ApiConfig apiConfig = ApiConfig.getInstance();
    private final CloseableHttpClient client;

    public VkApi() {
        CookieStore cookieStore = new BasicCookieStore();
        RequestConfig requestConfig = RequestConfig.custom()
                                                   .setSocketTimeout(60000)
                                                   .setConnectTimeout(5000)
                                                   .setConnectionRequestTimeout(5000)
                                                   .setCookieSpec("standard")
                                                   .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(300);
        connectionManager.setDefaultMaxPerRoute(300);
        client = HttpClients.custom()
                            .setConnectionManager(connectionManager)
                            .setDefaultRequestConfig(requestConfig)
                            .setDefaultCookieStore(cookieStore)
                            .setUserAgent("Java VK SDK/1.0")
                            .build();
    }

    public void sendMessage(VkMessageRequest request) throws IOException {
        HttpPost httpPost = new HttpPost(URI);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String message = apiConfig.getExtraText() + request.object.text;
        VkMessageResponse response = new VkMessageResponse(request, apiConfig.getAccessToken(), apiConfig.getApiVersion(), message);
        httpPost.setEntity(new StringEntity(response.toString(), "UTF-8"));
        client.execute(httpPost);
    }
}
