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
package com.sofa.alipay.tracer.plugins.spring.tair;

import com.aliyun.tair.springdata.TairJedisConnectionFactory;
import com.aliyun.tair.springdata.extend.connection.TairJedisClusterConnection;
import com.sofa.alipay.tracer.plugins.spring.tair.common.TairActionWrapperHelper;
import com.sofa.alipay.tracer.plugins.spring.tair.connections.TracingTairJedisClusterConnection;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.redis.RedisConnectionFailureException;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.util.Pool;

/**
 * @ClassName: TracingTairJedisConnectionFactory
 * @Description:
 * @Author: zhuangxinjie
 * @Date: 2021/6/19 10:19 上午
 */
public class TracingTairJedisConnectionFactory extends TairJedisConnectionFactory {
    private final TairActionWrapperHelper    actionWrapper;
    private final TairJedisConnectionFactory bean;

    public TracingTairJedisConnectionFactory(TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(JedisPoolConfig poolConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(poolConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(sentinelConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, JedisPoolConfig poolConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(sentinelConfig, poolConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisClusterConfiguration clusterConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(clusterConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisClusterConfiguration clusterConfig, JedisPoolConfig poolConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(clusterConfig, poolConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisStandaloneConfiguration standaloneConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(standaloneConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisStandaloneConfiguration standaloneConfig, JedisClientConfiguration clientConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(standaloneConfig, clientConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, JedisClientConfiguration clientConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(sentinelConfig, clientConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }

    public TracingTairJedisConnectionFactory(RedisClusterConfiguration clusterConfig, JedisClientConfiguration clientConfig, TairActionWrapperHelper actionWrapper, TairJedisConnectionFactory bean) {
        super(clusterConfig, clientConfig);
        this.actionWrapper = actionWrapper;
        this.bean = bean;
    }
    // todo 工厂的具体实现

}
