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

package cn.fightingguys.kaiheila.event.dm;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.api.User;
import cn.fightingguys.kaiheila.event.AbstractEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import cn.fightingguys.kaiheila.util.TimeUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public class DeletedPrivateMessageEvent extends AbstractEvent {

    public static final String _AcceptType = "deleted_private_message";

    private final String msgId;
    private final String authorId;
    private final String targetId;
    private final String chatCode;
    private final LocalDateTime deletedAt;

    public DeletedPrivateMessageEvent(RabbitImpl rabbit, JsonNode node) {
        super(rabbit, node);
        JsonNode body = super.getEventExtraBody(node);
        msgId = body.get("msg_id").asText();
        authorId = body.get("author_id").asText();
        targetId = body.get("target_id").asText();
        chatCode = body.get("chat_code").asText();
        deletedAt = TimeUtil.convertUnixTimeMillisecondLocalDateTime(body.get("deleted_at").asLong());
    }

    public String getMsgId() {
        return msgId;
    }

    public User getAuthor() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(authorId);
    }

    public User getTarget() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(targetId);
    }

    public String getChatCode() {
        return chatCode;
    }

    public LocalDateTime getDeletedTime() {
        return deletedAt;
    }

    @Override
    public IEvent handleSystemEvent(JsonNode body) {
        return this;
    }
}
