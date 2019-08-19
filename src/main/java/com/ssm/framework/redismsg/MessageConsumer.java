package com.ssm.framework.redismsg;

import com.ssm.utils.JedisPoolUtils;
import com.ssm.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageConsumer implements Runnable {

    public static final String MESSAGE_KEY = "message:queue";
    private volatile int count;

    public void consumerMessage() {
        try {
//            String message = JedisPoolUtils.getJedis().rpop(MESSAGE_KEY);
            List<String> message = JedisPoolUtils.getJedis().brpop(0, MESSAGE_KEY);
            System.out.println(Thread.currentThread().getName() + " consumer message,message=" + message + ",count=" + count);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            consumerMessage();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executor.execute(new MessageConsumer());
        }
    }
}
