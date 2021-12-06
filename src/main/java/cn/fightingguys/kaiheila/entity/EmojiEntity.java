package cn.fightingguys.kaiheila.entity;

import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.api.Emoji;
import cn.fightingguys.kaiheila.api.User;
import cn.fightingguys.kaiheila.core.RabbitObject;

public class EmojiEntity extends RabbitObject implements Emoji {

    private String id;
    private int type;
    private String name;
    private String userId;

    public EmojiEntity(RabbitImpl rabbit) {
        super(rabbit);
    }

    /**
     * 开黑啦唯一标识符 Emoji Id
     *
     * @return Emoji Id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取表情上传用户
     *
     * @return 上传用户
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取表情上传用户
     *
     * @return 上传用户
     */
    @Override
    public User getUploader() {
        return getRabbitImpl().getCacheManager().getUserCache().getElementById(userId);
    }
}
