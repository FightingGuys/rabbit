import cn.fightingguys.kaiheila.*;
import cn.fightingguys.kaiheila.event.message.TextMessageEvent;
import cn.fightingguys.kaiheila.hook.EventListener;

/**
 * 用户机器人应用
 */
public class BotApplication {
    public static void main(String[] args) {
        String apiToken = ""; // 用户机器人 token，详细请查看 开黑啦开放平台
        Rabbit rabbit = RabbitBuilder.builder()
                .createDefault(apiToken) // 使用默认配置构建 Rabbit 实例
                .build(); // 创建实例
        // 添加事件处理器
        rabbit.addEventListener(new UserEventHandler());
        // 登录实例
        if (rabbit.login()) {
            System.out.println("登录成功");
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                rabbit.shutdown();
            }
        } else {
            System.out.println("登录失败");
        }
    }

    /**
     * 创建用户事件处理器
     */
    public static class UserEventHandler extends EventListener {
        /**
         * 接收文本消息事件
         *
         * @param rabbit Rabbit 实例
         * @param event  文本消息事件内容
         */
        @Override
        public void onTextMessageEvent(Rabbit rabbit, TextMessageEvent event) {
            // 监听文本消息事件内容
            System.out.println(event.getEventContent());
        }
    }
}