package cn.fightingguys.kaiheila.core;

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitImpl;

public abstract class RabbitObject {

    private final RabbitImpl rabbit;

    public RabbitObject(RabbitImpl rabbit) {
        this.rabbit = rabbit;
    }

    protected RabbitImpl getRabbitImpl() {
        return rabbit;
    }

    public Rabbit getRabbit() {
        return rabbit;
    }

}
