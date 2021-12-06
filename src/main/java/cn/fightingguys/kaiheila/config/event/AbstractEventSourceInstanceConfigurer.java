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

import cn.fightingguys.kaiheila.Rabbit;
import cn.fightingguys.kaiheila.RabbitBuilder;
import cn.fightingguys.kaiheila.config.AbstractConfigurer;

public abstract class AbstractEventSourceInstanceConfigurer extends AbstractConfigurer<RabbitBuilder, Rabbit> {

    public AbstractEventSourceInstanceConfigurer(RabbitBuilder rabbitBuilder) {
        super(rabbitBuilder);
    }

}
