package com.sofa.alipay.tracer.plugins.spring.tair.connections;

import com.aliyun.tair.springdata.extend.commands.TairConnection;
import com.aliyun.tair.springdata.extend.connection.TairJedisClusterConnection;
import com.sofa.alipay.tracer.plugins.spring.tair.common.TairActionWrapperHelper;
import redis.clients.jedis.JedisCluster;

import static org.junit.jupiter.api.Assertions.*;

class TracingTairJedisClusterConnectionTest {
    private JedisCluster cluster;
    private TairActionWrapperHelper tairActionWrapperHelper;
    private TairJedisClusterConnection tairConnection;
    private  TairConnection connection;
    public void test(){
        TracingTairJedisClusterConnection t = new TracingTairJedisClusterConnection(cluster,tairActionWrapperHelper,tairConnection);
        TracingTairConnection tt = new TracingTairConnection(tairActionWrapperHelper,connection);

    }


}