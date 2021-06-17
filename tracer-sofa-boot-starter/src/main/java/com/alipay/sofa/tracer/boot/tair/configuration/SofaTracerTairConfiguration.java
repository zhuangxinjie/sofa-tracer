/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.tracer.boot.tair.configuration;

import com.alipay.sofa.tracer.boot.configuration.SofaTracerAutoConfiguration;
import com.aliyun.tair.springdata.TairJedisConnectionFactory;
import com.sofa.alipay.tracer.plugins.spring.tair.SofaTracerTairRCFBeanPostProcessor;
import com.sofa.alipay.tracer.plugins.spring.tair.common.TairActionWrapperHelper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SofaTracerTairConfiguration
 * @Description:
 * @Author: zhuangxinjie
 * @Date: 2021/6/11 2:03 下午
 */
@Configuration
@ConditionalOnClass({ TairJedisConnectionFactory.class, TairActionWrapperHelper.class })
@ConditionalOnProperty(name = "com.alipay.sofa.tracer.tair.enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureAfter(SofaTracerAutoConfiguration.class)
public class SofaTracerTairConfiguration {
    @Bean
    @ConditionalOnMissingBean
    TairActionWrapperHelper tairActionWrapperHelper() {
        return new TairActionWrapperHelper();
    }

    @Bean
    @ConditionalOnMissingBean
    SofaTracerTairRCFBeanPostProcessor sofaTracerTairRCFBeanPostProcessor(TairActionWrapperHelper tairActionWrapperHelper) {
        return new SofaTracerTairRCFBeanPostProcessor(tairActionWrapperHelper);
    }
}
