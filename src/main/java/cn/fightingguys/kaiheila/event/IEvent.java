package cn.fightingguys.kaiheila.event;

import com.fasterxml.jackson.databind.JsonNode;

public interface IEvent {

    IEvent handleSystemEvent(JsonNode body);

}
