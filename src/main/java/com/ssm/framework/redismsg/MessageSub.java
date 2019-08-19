package com.ssm.framework.redismsg;

import com.ssm.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageSub implements Runnable {

    public static final String CHANNEL_KEY = "channel:1";//频道
    public static final String EXIT_COMMAND = "exit";//结束程序的消息
    private MyJedisPubSub myJedisPubSub = new MyJedisPubSub();//处理接收消息

    public void consumerMessage() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.subscribe(myJedisPubSub, CHANNEL_KEY);//第一个参数是处理接收消息，第二个参数是订阅的消息频道
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
            executor.execute(new MessageSub());
        }
    }
}
