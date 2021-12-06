package cn.fightingguys.kaiheila.entity;

import cn.fightingguys.kaiheila.api.SelfUser;

public class SelfUserEntity implements SelfUser {
    private final UserEntity user;

    public SelfUserEntity(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }
}
