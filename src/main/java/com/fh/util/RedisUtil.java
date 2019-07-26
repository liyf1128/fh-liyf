package com.fh.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void set(String key,String value){
        Jedis jedis = null;
        try {
            jedis = RedisPool.redisPool();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public static String get(String key){
        Jedis jedis =null;
        String getjed ="";
        try {
            jedis = RedisPool.redisPool();
            getjed = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return getjed;
    }

    public static boolean exists(String key){
        Jedis jedis =null;
        boolean existsjed = false;
        try {
            jedis = RedisPool.redisPool();
            existsjed = jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return existsjed;
    }

    public static boolean setExNx(String key,String value,int seconds){
        Jedis jedis =null;
        try {
            jedis = RedisPool.redisPool();
            String result = jedis.set(key, value, "nx", "ex", seconds);
            if (result == null){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return true;
    }

    public static void expire(String key,int time){
        Jedis jedis =null;
        try {
            jedis = RedisPool.redisPool();
            jedis.expire(key,time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = RedisPool.redisPool();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public static void setex(String key,int seconds,String value){
        Jedis jedis = null;
        try {
            jedis = RedisPool.redisPool();
            jedis.setex(key,seconds,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }
}
