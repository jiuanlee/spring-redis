package com.ssm.utils;

import com.ssm.biz.ApplicationContextUtils;
import com.ssm.biz.LatinConstants;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisUtil {
    private static RedisUtil instance = new RedisUtil();

    public static RedisUtil getInstance() {
        return instance;
    }

    public String get(String key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    public void put(String key, String result) {
        getRedisTemplate().opsForValue().set(key, result);
    }

    public void put(String key, String result, long expireMinutes) {
        getRedisTemplate().opsForValue().set(key, result, expireMinutes, TimeUnit.SECONDS);
    }

    public String rpop(String key) {
        return getRedisTemplate().opsForList().rightPop(key);
    }

    public Long lpush(String key, String message) {
        return getRedisTemplate().opsForList().leftPush(key, message);
    }

    private RedisTemplate<String, String> getRedisTemplate() {
        RedisTemplate redisTemplate = ApplicationContextUtils
                .getBean(LatinConstants.REDISTEMPLATE_CONTEXT_ID, RedisTemplate.class);
        return redisTemplate;
    }
}
