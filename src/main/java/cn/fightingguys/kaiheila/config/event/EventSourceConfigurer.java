/*
 *    Copyright 2020-2021 Rabbit author and contributors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.config.event;

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitBuilder;
import cn.fightingguys.kaiheila.config.AbstractConfigurer;
import cn.fightingguys.kaiheila.hook.EventSource;

public class EventSourceConfigurer extends AbstractConfigurer<RabbitBuilder, Rabbit> {

    private EventSourceType eventSourceType = EventSourceType.WEBSOCKET;
    private AbstractEventSourceInstanceConfigurer instanceConfigurer;
    private EventSource eventSource;

    public EventSourceConfigurer(RabbitBuilder rabbitBuilder) {
        super(rabbitBuilder);
    }

    public WebhookEventSourceConfigurer webhook() {
        this.eventSourceType = EventSourceType.WEBHOOK;
        this.instanceConfigurer = new WebhookEventSourceConfigurer(super.rootContext);
        return (WebhookEventSourceConfigurer) this.instanceConfigurer;
    }

    public WebSocketEventSourceConfigurer websocket() {
        this.eventSourceType = EventSourceType.WEBSOCKET;
        this.instanceConfigurer = new WebSocketEventSourceConfigurer(super.rootContext);
        return (WebSocketEventSourceConfigurer) this.instanceConfigurer;
    }

    public EventSourceConfigurer custom(EventSource eventSource, AbstractEventSourceInstanceConfigurer instanceConfigurer) {
        this.eventSourceType = EventSourceType.CUSTOM;
        this.eventSource = eventSource;
        this.instanceConfigurer = instanceConfigurer;
        return this;
    }

    public EventSourceType getEventSourceType() {
        return eventSourceType;
    }

    public AbstractEventSourceInstanceConfigurer getInstanceConfigurer() {
        return instanceConfigurer;
    }

    public EventSource getEventSource() {
        return eventSource;
    }

    @Override
    public Rabbit build() {
        return super.build();
    }

    public enum EventSourceType {
        WEBSOCKET,
        WEBHOOK,
        CUSTOM,
    }
}
