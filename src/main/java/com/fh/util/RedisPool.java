package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private RedisPool(){

    }

    private static JedisPool jedisPool;
    private static void redisPools(){
        //配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //总的连接数
        jedisPoolConfig.setMaxTotal(1000);
        //空闲时的最小链接
        jedisPoolConfig.setMinIdle(100);
        //空闲时的最大链接
        jedisPoolConfig.setMaxIdle(100);
        //验证链接可用性
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.124.63", 6379);
    }

    static {
        redisPools();
    }

    public static Jedis redisPool(){
        return jedisPool.getResource();
    }


}
