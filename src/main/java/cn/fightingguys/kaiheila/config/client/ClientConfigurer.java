package cn.fightingguys.kaiheila.config.client;

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitBuilder;
import cn.fightingguys.kaiheila.client.http.HttpClientFactory;
import cn.fightingguys.kaiheila.client.ws.WebSocketClientFactory;
import cn.fightingguys.kaiheila.config.AbstractConfigurer;

import java.util.Objects;

public class ClientConfigurer extends AbstractConfigurer<RabbitBuilder, Rabbit> {

    private HttpClientFactory httpClientFactory = HttpClientFactory.DEFAULT_HTTP_CLIENT;
    private WebSocketClientFactory webSocketClientFactory = WebSocketClientFactory.DEFAULT_WEBSOCKET_CLIENT;

    public ClientConfigurer(RabbitBuilder rabbitBuilder) {
        super(rabbitBuilder);
    }

    public ClientConfigurer httpClientFactory(HttpClientFactory httpClientFactory) {
        Objects.requireNonNull(httpClientFactory, "httpClientFactory == null");
        this.httpClientFactory = httpClientFactory;
        return this;
    }

    public ClientConfigurer webSocketClientFactory(WebSocketClientFactory webSocketClientFactory) {
        Objects.requireNonNull(webSocketClientFactory, "webSocketClientFactory == null");
        this.webSocketClientFactory = webSocketClientFactory;
        return this;
    }

    public HttpClientFactory getHttpClientFactory() {
        return httpClientFactory;
    }

    public WebSocketClientFactory getWebSocketClientFactory() {
        return webSocketClientFactory;
    }

}
