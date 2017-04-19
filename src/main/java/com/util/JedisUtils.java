package com.util;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils
{
    private static final int MAX_ACTIVE = 20;
    
    private static final int MAX_IDLE = 8;
    
    private static final int MAX_WAIT = 5 * 60 * 1000;
    
    static Map<String, JedisPool> maps = new HashMap<>();
    
    /**
     * 获取连接池.
     * 
     * @return 连接池实例
     */
    private static JedisPool getPool(String ip, int port)
    {
        String key = ip + ":" + port;
        JedisPool pool = null;
        if (!maps.containsKey(key))
        {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            // config.setTestOnBorrow(true);
            // config.setTestOnReturn(true);
            try
            {
                /**
                 * 如果你遇到 java.net.SocketTimeoutException: Read timed out exception的异常信息 请尝试在构造JedisPool的时候设置自己的超时值.
                 * JedisPool默认的超时时间是2秒(单位毫秒)
                 */
                pool = new JedisPool(config, ip, port);
                maps.put(key, pool);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            pool = maps.get(key);
        }
        return pool;
    }
    
    public static Jedis getJedis(String ip, int port)
    {
        Jedis jedis = null;
        try
        {
            JedisPool pool = getPool(ip, port);
            jedis = pool.getResource();
            return jedis;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return jedis;
    }
}
