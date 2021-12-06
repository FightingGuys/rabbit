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
import cn.fightingguys.kaiheila.api.Emoji;
import cn.fightingguys.kaiheila.api.User;
import cn.fightingguys.kaiheila.event.AbstractEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import com.fasterxml.jackson.databind.JsonNode;

public class PrivateAddedReactionEvent extends AbstractEvent {

    public static final String _AcceptType = "private_added_reaction";

    private final String msgId;
    private final String userId;
    private final String chatCode;
    private final String emojiId;

    public PrivateAddedReactionEvent(RabbitImpl rabbit, JsonNode node) {
        super(rabbit, node);
        JsonNode body = super.getEventExtraBody(node);
        msgId = body.get("msg_id").asText();
        userId = body.get("user_id").asText();
        chatCode = body.get("chat_code").asText();
        emojiId = body.get("emoji").get("id").asText();
    }

    public String getMsgId() {
        return msgId;
    }

    public User getUser() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(userId);
    }

    public String getChatCode() {
        return chatCode;
    }

    public Emoji getEmoji() {
        return getRabbitImpl().getCacheManager().getGuildEmojisCache().getElementById(emojiId);
    }

    @Override
    public IEvent handleSystemEvent(JsonNode body) {
        return this;
    }
}
