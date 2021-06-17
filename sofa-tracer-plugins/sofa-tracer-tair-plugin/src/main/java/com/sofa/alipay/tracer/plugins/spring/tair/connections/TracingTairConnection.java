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
package com.sofa.alipay.tracer.plugins.spring.tair.connections;

import com.sofa.alipay.tracer.plugins.spring.redis.common.RedisActionWrapperHelper;
import com.sofa.alipay.tracer.plugins.spring.redis.common.RedisCommand;
import com.sofa.alipay.tracer.plugins.spring.redis.connections.TracingRedisConnection;
import com.sofa.alipay.tracer.plugins.spring.tair.common.TairActionWrapperHelper;
import org.springframework.data.redis.connection.RedisConnection;

/**
 * @ClassName: TracingTairConnection
 * @Description:
 * @Author: zhuangxinjie
 * @Date: 2021/6/11 2:41 下午
 */
public class TracingTairConnection extends TracingRedisConnection implements TairRedisConnection {
    private final TairActionWrapperHelper tairActionWrapperHelper;
    private final TairRedisConnection     tairRedisConnection;

    public TracingTairConnection(RedisConnection connection,
                                 RedisActionWrapperHelper actionWrapper,
                                 TairActionWrapperHelper tairActionWrapperHelper,
                                 TairRedisConnection tairRedisConnection) {
        super(connection, actionWrapper);
        this.tairActionWrapperHelper = tairActionWrapperHelper;
        this.tairRedisConnection = tairRedisConnection;
    }

    @Override
    public Long cas(Object o, Object o2, Object v1) {
        return tairActionWrapperHelper.doInScope(RedisCommand.CAS, o, o2 ,v1,tairRedisConnection::cas);
    }

    @Override
    public Long cas(Object o, Object o2, Object v1, com.aliyun.tair.tairstring.params.CasParams casParams) {
        return tairActionWrapperHelper.doInScope(RedisCommand.CAS, o, o2 , v1, casParams, tairRedisConnection::cas);
    }

    @Override
    public Long cad(Object o, Object o2) {
        //        return tairActionWrapperHelper.doInScope(RedisCommand.CAD, o, o2 , tairRedisConnection::cad);
        return null;
    }

    @Override
    public String exset(Object o, Object o2) {
        return null;
    }

    @Override
    public String exset(Object o, Object o2,
                        com.aliyun.tair.tairstring.params.ExsetParams exsetParams) {
        return null;
    }

    @Override
    public com.aliyun.tair.tairstring.results.ExgetResult<V> exget(Object o) {
        return null;
    }

    @Override
    public Long exsetver(Object o, long l) {
        return null;
    }

    @Override
    public Long exincrBy(Object o, long l) {
        return null;
    }

    @Override
    public Long exincrBy(Object o, long l,
                         com.aliyun.tair.tairstring.params.ExincrbyParams exincrbyParams) {
        return null;
    }

    @Override
    public Double exincrByFloat(Object o, Double aDouble) {
        return null;
    }

    @Override
    public Double exincrByFloat(Object o,
                                Double aDouble,
                                com.aliyun.tair.tairstring.params.ExincrbyFloatParams exincrbyFloatParams) {
        return null;
    }

    @Override
    public com.aliyun.tair.tairstring.results.ExcasResult<V> excas(Object o, Object o2, long l) {
        return null;
    }

    @Override
    public Long excad(Object o, long l) {
        return null;
    }
}
