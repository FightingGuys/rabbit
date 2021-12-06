package cn.fightingguys.kaiheila.client.http;

import cn.fightingguys.kaiheila.client.http.impl.OkHttpClientImpl;
import cn.fightingguys.kaiheila.util.OkHttpClientSingleton;

@FunctionalInterface
public interface HttpClientFactory {

    HttpClientFactory DEFAULT_HTTP_CLIENT = () -> new OkHttpClientImpl(OkHttpClientSingleton.getInstance());

    IHttpClient buildHttpClient();

}
