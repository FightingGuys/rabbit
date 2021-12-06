package cn.fightingguys.kaiheila.hook;

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitImpl;
import cn.fightingguys.kaiheila.event.FailureEvent;
import cn.fightingguys.kaiheila.event.IEvent;
import cn.fightingguys.kaiheila.event.UnknownEvent;
import cn.fightingguys.kaiheila.event.channel.*;
import cn.fightingguys.kaiheila.event.guild.AddedBlockListEvent;
import cn.fightingguys.kaiheila.event.guild.DeletedBlockListEvent;
import cn.fightingguys.kaiheila.event.guild.DeletedGuildEvent;
import cn.fightingguys.kaiheila.event.guild.UpdatedGuildEvent;
import cn.fightingguys.kaiheila.event.member.*;
import cn.fightingguys.kaiheila.event.message.*;
import cn.fightingguys.kaiheila.event.dm.DeletedPrivateMessageEvent;
import cn.fightingguys.kaiheila.event.dm.PrivateAddedReactionEvent;
import cn.fightingguys.kaiheila.event.dm.PrivateDeletedReactionEvent;
import cn.fightingguys.kaiheila.event.dm.UpdatedPrivateMessageEvent;
import cn.fightingguys.kaiheila.event.role.AddedRoleEvent;
import cn.fightingguys.kaiheila.event.role.DeletedRoleEvent;
import cn.fightingguys.kaiheila.event.role.UpdatedRoleEvent;
import cn.fightingguys.kaiheila.event.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public abstract class EventListener {

    private static final Logger Log = LoggerFactory.getLogger(EventListener.class);

    // @formatter:off
    public void onEvent(Rabbit rabbit, IEvent event) {}
    public void onUnknownEvent(Rabbit rabbit, UnknownEvent event) {}
    public void onFailureEvent(Rabbit rabbit, FailureEvent event) {}

    public void onCardMessageEvent(Rabbit rabbit, CardMessageEvent event) {}
    public void onFileMessageEvent(Rabbit rabbit, FileMessageEvent event) {}
    public void onImageMessageEvent(Rabbit rabbit, ImageMessageEvent event) {}
    public void onMarkDownMessageEvent(Rabbit rabbit, MarkDownMessageEvent event) {}
    public void onTextMessageEvent(Rabbit rabbit, TextMessageEvent event) {}
    public void onVideoMessageEvent(Rabbit rabbit, VideoMessageEvent event) {}

    public void onAddedChannelEvent(Rabbit rabbit, AddedChannelEvent event) {}
    public void onAddedReactionEvent(Rabbit rabbit, AddedReactionEvent event) {}
    public void onDeletedChannelEvent(Rabbit rabbit, DeletedChannelEvent event) {}
    public void onDeletedMessageEvent(Rabbit rabbit, DeletedMessageEvent event) {}
    public void onDeletedReactionEvent(Rabbit rabbit, DeletedReactionEvent event) {}
    public void onPinnedMessageEvent(Rabbit rabbit, PinnedMessageEvent event) {}
    public void onUnPinnedMessageEvent(Rabbit rabbit, UnPinnedMessageEvent event) {}
    public void onUpdatedChannelEvent(Rabbit rabbit, UpdatedChannelEvent event) {}
    public void onUpdateMessageEvent(Rabbit rabbit, UpdateMessageEvent event) {}

    public void onAddedBlockListEvent(Rabbit rabbit, AddedBlockListEvent event) {}
    public void onDeletedBlockListEvent(Rabbit rabbit, DeletedBlockListEvent event) {}
    public void onDeletedGuildEvent(Rabbit rabbit, DeletedGuildEvent event) {}
    public void onUpdatedGuildEvent(Rabbit rabbit, UpdatedGuildEvent event) {}

    public void onExitedGuildEvent(Rabbit rabbit, ExitedGuildEvent event) {}
    public void onGuildMemberOfflineEvent(Rabbit rabbit, GuildMemberOfflineEvent event) {}
    public void onGuildMemberOnlineEvent(Rabbit rabbit, GuildMemberOnlineEvent event) {}
    public void onJoinedGuildEvent(Rabbit rabbit, JoinedGuildEvent event) {}
    public void onUpdatedGuildMemberEvent(Rabbit rabbit, UpdatedGuildMemberEvent event) {}

    public void onDeletedPrivateMessageEvent(Rabbit rabbit, DeletedPrivateMessageEvent event) {}
    public void onPrivateAddedReactionEvent(Rabbit rabbit, PrivateAddedReactionEvent event) {}
    public void onPrivateDeletedReactionEvent(Rabbit rabbit, PrivateDeletedReactionEvent event) {}
    public void onUpdatedPrivateMessageEvent(Rabbit rabbit, UpdatedPrivateMessageEvent event) {}

    public void onAddedRoleEvent(Rabbit rabbit, AddedRoleEvent event) {}
    public void onDeletedRoleEvent(Rabbit rabbit, DeletedRoleEvent event) {}
    public void onUpdatedRoleEvent(Rabbit rabbit, UpdatedRoleEvent event) {}

    public void onExitedChannelEvent(Rabbit rabbit, ExitedChannelEvent event) {}
    public void onJoinedChannelEvent(Rabbit rabbit, JoinedChannelEvent event) {}
    public void onMessageBtnClickEvent(Rabbit rabbit, MessageBtnClickEvent event) {}
    public void onSelfExitedGuildEvent(Rabbit rabbit, SelfExitedGuildEvent event) {}
    public void onSelfJoinedGuildEvent(Rabbit rabbit, SelfJoinedGuildEvent event) {}
    public void onUserUpdatedEvent(Rabbit rabbit, UserUpdatedEvent event) {}
    // @formatter:on

    public final void handle(RabbitImpl rabbit, IEvent event) {
        this.onEvent(rabbit, event);
        String methodName = "on" + event.getClass().getSimpleName();
        try {
            Method method = this.getClass().getMethod(methodName, Rabbit.class, event.getClass());
            method.invoke(this, rabbit, event);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Log.error(e.getMessage());
        }
    }

}
