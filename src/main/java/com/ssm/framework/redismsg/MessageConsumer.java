package com.ssm.framework.redismsg;

import com.ssm.utils.RedisUtil;
import redis.clients.jedis.Jedis;

public class MessageConsumer implements Runnable {

    public static final String MESSAGE_KEY = "message:queue";
    private volatile int count;

    public void consumerMessage() {
        try {
            String message = RedisUtil.getInstance().rpop(MESSAGE_KEY);
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
}
