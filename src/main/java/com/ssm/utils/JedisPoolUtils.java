package com.ssm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {

    private static JedisPool pool = null;

    static {

        //加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));//最大闲置个数
        poolConfig.setMaxWaitMillis(Integer.parseInt(pro.get("redis.maxWait").toString()));//最大闲置个数
//        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));//最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxActive").toString()));//最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.host"), Integer.parseInt(pro.get("redis.port").toString()), Integer.parseInt(pro.getProperty("redis.maxWait")), pro.getProperty("redis.pass"), Integer.valueOf(pro.getProperty("redis.dbIndex")));
    }

    //获得jedis资源的方法
    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        System.out.println(jedis);
    }

}
