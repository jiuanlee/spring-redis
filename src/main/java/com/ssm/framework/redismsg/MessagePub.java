package com.ssm.framework.redismsg;

import com.ssm.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagePub implements Runnable {

    public static final String CHANNEL_KEY = "channel:1";
    private volatile int count;

    public void putMessage(String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        Long publish = jedis.publish(CHANNEL_KEY, message);//返回订阅者数量
        System.out.println(Thread.currentThread().getName() + " put message,count=" + count + ",subscriberNum=" + publish);
        count++;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            putMessage("message" + count);
        }
    }

    public static void main(String[] args) {
        ExecutorService excutor = Executors.newCachedThreadPool();
        MessagePub messagePub = new MessagePub();
        for (int i = 0; i < 5; i++) {
            excutor.execute(new MessagePub()); //启动5个线程
        }

    }
}
