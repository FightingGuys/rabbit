/*
 *    Copyright 2020-2021 Rabbit author and contributors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.config.event;

import cn.fightingguys.kaiheila.RabbitBuilder;

public class WebhookEventSourceConfigurer extends AbstractEventSourceInstanceConfigurer {

    private String verifyToken;
    private String encryptKey;

    public WebhookEventSourceConfigurer(RabbitBuilder rabbitBuilder) {
        super(rabbitBuilder);
    }

    public WebhookEventSourceConfigurer verifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
        return this;
    }

    public WebhookEventSourceConfigurer encryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
        return this;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

}
