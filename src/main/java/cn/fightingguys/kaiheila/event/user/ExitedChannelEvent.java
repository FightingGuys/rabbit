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

package cn.fightingguys.kaiheila.event.user;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.api.Channel;
import cn.fightingguys.kaiheila.api.User;
import cn.fightingguys.kaiheila.event.AbstractEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import cn.fightingguys.kaiheila.util.TimeUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public class ExitedChannelEvent extends AbstractEvent {

    public static final String _AcceptType = "exited_channel";

    private final String userId;
    private final String channelId;
    private final LocalDateTime exitedAt;

    public ExitedChannelEvent(RabbitImpl rabbit, JsonNode node) {
        super(rabbit, node);
        JsonNode body = super.getEventExtraBody(node);
        userId = body.get("user_id").asText();
        channelId = body.get("channel_id").asText();
        exitedAt = TimeUtil.convertUnixTimeMillisecondLocalDateTime(body.get("exited_at").asLong());
    }

    public User getUser() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(userId);
    }

    public Channel getChannel() {
        return getRabbitImpl().getCacheManager().getChannelCache().getElementById(channelId);
    }

    public LocalDateTime getExitedTime() {
        return exitedAt;
    }

    @Override
    public IEvent handleSystemEvent(JsonNode body) {
        // todo Wait for KHL Official, Fix Event Data
        return this;
    }
}
