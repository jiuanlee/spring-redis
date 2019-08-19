package com.ssm.framework.redismsg;

import com.ssm.utils.JedisPoolUtils;
import com.ssm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MessageProducer implements Runnable {

    public static final String MESSAGE_KEY = "message:queue";
    private volatile int count;

    public void putMessage(String message) {
        try {
            Long size = JedisPoolUtils.getJedis().lpush(MESSAGE_KEY, message);
            System.out.println(Thread.currentThread().getName() + " put message,size=" + size + ",count=" + count);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            putMessage("message" + count);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            executor.execute(new MessageProducer());
    }
}
