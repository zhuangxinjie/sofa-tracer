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

import com.aliyun.tair.springdata.extend.commands.TairConnection;
import com.aliyun.tair.springdata.extend.connection.TairJedisClusterConnection;
import com.sofa.alipay.tracer.plugins.spring.tair.common.TairActionWrapperHelper;
import redis.clients.jedis.JedisCluster;

import static org.junit.jupiter.api.Assertions.*;

class TracingTairJedisClusterConnectionTest {
    private JedisCluster               cluster;
    private TairActionWrapperHelper    tairActionWrapperHelper;
    private TairJedisClusterConnection tairConnection;
    private TairConnection             connection;

    public void test() {
        TracingTairJedisClusterConnection t = new TracingTairJedisClusterConnection(cluster,
            tairActionWrapperHelper, tairConnection);
        TracingTairConnection tt = new TracingTairConnection(tairActionWrapperHelper, connection);

    }

}