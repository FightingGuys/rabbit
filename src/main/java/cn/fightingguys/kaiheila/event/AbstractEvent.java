/*
 *    Copyright 2021 FightingGuys Team and khl-sdk-java contributors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.event;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.api.User;
import cn.fightingguys.kaiheila.core.RabbitObject;
import cn.fightingguys.kaiheila.util.TimeUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public abstract class AbstractEvent extends RabbitObject implements IEvent {

    private final String eventChannelType;
    private final int eventType;
    private final String eventTargetId;
    private final String eventAuthorId;
    private final String eventContent;
    private final String eventId;
    private final LocalDateTime eventTime;
    private final String eventNonce;

    public AbstractEvent(RabbitImpl rabbit, JsonNode node) {
        super(rabbit);
        this.eventChannelType = node.get("channel_type").asText();
        this.eventType = node.get("type").asInt();
        this.eventTargetId = node.get("target_id").asText();
        this.eventAuthorId = node.get("author_id").asText();
        this.eventContent = node.get("content").asText();
        this.eventId = node.get("msg_id").asText();
        this.eventTime = TimeUtil.convertUnixTimeMillisecondLocalDateTime(node.get("msg_timestamp").asLong());
        this.eventNonce = node.get("nonce").asText();
    }

    public JsonNode getEventExtraBody(JsonNode node) {
        return node.get("extra").get("body");
    }

    public String getEventChannelType() {
        return eventChannelType;
    }

    public int getEventType() {
        return eventType;
    }

    public String getEventTargetId() {
        return eventTargetId;
    }

    public User getEventAuthorId() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(eventAuthorId);
    }

    public String getEventContent() {
        return eventContent;
    }

    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public String getEventNonce() {
        return eventNonce;
    }

}
