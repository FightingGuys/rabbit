# Rabbit 开黑啦机器人运行库

### 简介

Rabbit 并非单例机器人应用框架，所以你可以在同个进程可以开启多个机器人实例应用  
**目前只能接收事件，暂无法使用 [开黑啦官方](https://github.com/kaiheila/) 所提供的API接口**

[进入开黑啦讨论 - https://kaihei.co/O9A5AY](https://kaihei.co/O9A5AY)

### 使用说明

Rabbit 当前为测试阶段，尚未进入 Release (项目未发布到Maven中央依赖库)

本项目暂时使用 [Github Package](https://github.com/FightingGuys/rabbit/packages)

- 引入到 Maven

```xml
<!-- https://github.com/fightingguys/rabbit/packages -->
<dependency>
    <groupId>cn.fightingguys.kaiheila</groupId>
    <artifactId>rabbit</artifactId>
    <version>0.0.1</version>
</dependency>
```

- 引入到 Gradle

```groovy
implementation 'cn.fightingguys.kaiheila:rabbit:0.0.1'
```

- 开始编码

```java
String apiToken = ""; // 用户机器人 token，详细请查看 开黑啦开放平台
Rabbit rabbit = RabbitBuilder.builder()
    .createDefault(apiToken) // 使用默认配置构建 Rabbit 实例
    .build();   // 创建实例
rabbit.addEventListener(new UserEventHandler()); // 添加事件处理器
rabbit.login(); // 登录实例
```

[查看示例完整代码](sample/SimpleApplication/BotApplication.java)

### 提出问题

想了解当前项目更多介绍，可以查看本项目的 [Wiki](https://github.com/FightingGuys/rabbit/wiki)
、[Gitee Wiki](https://gitee.com/FightingGuys/rabbit/wikis)  
若遇到框架使用疑惑，可以先查看 [Wiki](https://github.com/FightingGuys/rabbit/wiki)
、[Gitee Wiki](https://gitee.com/FightingGuys/rabbit/wikis)   
若遇到出现致命问题，可以向项目 [提交 Issue](https://github.com/FightingGuys/rabbit/issues)  
若你想项目变得更好，可以协助项目开发，[查看项目计划](https://github.com/FightingGuys/rabbit/projects)

### 为贡献项目

**目前规则尚未完善，有意者请关注开黑啦群组内消息**  
[进入开黑啦讨论 - https://kaihei.co/O9A5AY](https://kaihei.co/O9A5AY)

### 关于镜像问题

Gitee 暂时仅做访问加速功能  
若有其他疑问请提交到 Github

#### 相关链接

- [Github 主仓库](https://github.com/FightingGuys/rabbit)
- [Gitee 镜像仓库](https://gitee.com/FightingGuys/rabbit)
- [Github Wiki](https://github.com/FightingGuys/rabbit/wiki)
- [Gitee 镜像Wiki](https://gitee.com/FightingGuys/rabbit/wikis)
- [开黑啦讨论群组](https://kaihei.co/O9A5AY)