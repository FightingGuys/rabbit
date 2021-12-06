package cn.fightingguys.kaiheila.api;

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitBuilder;
import cn.fightingguys.kaiheila.event.FailureEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import cn.fightingguys.kaiheila.event.UnknownEvent;
import cn.fightingguys.kaiheila.event.message.TextMessageEvent;
import cn.fightingguys.kaiheila.hook.EventListener;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SelfTest {

    protected static final Logger Log = LoggerFactory.getLogger(SelfTest.class);
    public final static String apiToken = System.getenv("X_KAIHEILA_API_TOKEN");

    static Thread mainThread;

    //    @Test
    public void doAction() {
        Assert.assertNotNull("X_KAIHEILA_API_TOKEN == null", apiToken);
        mainThread = Thread.currentThread();
        Rabbit rabbit = RabbitBuilder.builder()
                .createDefault(apiToken)
                .build();
        rabbit.addEventListener(new UserEventHandler());
        if (rabbit.login()) {
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                rabbit.shutdown();
            }
        }
        else {
            Log.error("登录失败");
        }
    }

    public static class UserEventHandler extends EventListener {
        @Override
        public void onEvent(Rabbit rabbit, IEvent event) {
            Log.info("on{}", event.getClass().getSimpleName());
        }

        @Override
        public void onTextMessageEvent(Rabbit rabbit, TextMessageEvent event) {
            Log.info("Message {}", event.getEventContent());
            if (event.getEventContent().trim().equals("/shutdown")) {
                mainThread.interrupt();
            }
        }

        @Override
        public void onUnknownEvent(Rabbit rabbit, UnknownEvent event) {
            Log.warn("UnknownEvent \n{}", event.getRawEventData());
        }

        @Override
        public void onFailureEvent(Rabbit rabbit, FailureEvent event) {
            Log.warn("onFailureEvent \n{}", event.getRawEventData());
            event.getThrowable().printStackTrace();
        }
    }

}
