package cn.fightingguys.kaiheila.client.ws;

import cn.fightingguys.kaiheila.client.ws.impl.OkHttpWebSocketClientImpl;
import cn.fightingguys.kaiheila.util.OkHttpClientSingleton;

@FunctionalInterface
public interface WebSocketClientFactory {

    WebSocketClientFactory DEFAULT_WEBSOCKET_CLIENT = () -> new OkHttpWebSocketClientImpl(OkHttpClientSingleton.getInstance());

    IWebSocketClient buildWebSocketClient();

}
