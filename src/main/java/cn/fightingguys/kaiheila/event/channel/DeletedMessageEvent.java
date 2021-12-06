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

package cn.fightingguys.kaiheila.event.channel;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.api.Channel;
import cn.fightingguys.kaiheila.event.AbstractEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import com.fasterxml.jackson.databind.JsonNode;

public class DeletedMessageEvent extends AbstractEvent {

    public static final String _AcceptType = "deleted_message";

    private final String msgId;
    private final String channelId;

    public DeletedMessageEvent(RabbitImpl rabbit, JsonNode node) {
        super(rabbit, node);
        JsonNode body = super.getEventExtraBody(node);
        channelId = body.get("channel_id").asText();
        msgId = body.get("msg_id").asText();
    }

    public String getMsgId() {
        return msgId;
    }

    public Channel getChannel() {
        return getRabbitImpl().getCacheManager().getChannelCache().getElementById(channelId);
    }

    @Override
    public IEvent handleSystemEvent(JsonNode body) {
        return this;
    }
}
