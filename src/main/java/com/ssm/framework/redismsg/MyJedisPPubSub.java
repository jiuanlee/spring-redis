package com.ssm.framework.redismsg;

import redis.clients.jedis.JedisPubSub;

public class MyJedisPPubSub extends JedisPubSub {

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(Thread.currentThread().getName() + "-接收到消息:pattern=" + pattern + ",channel=" + channel + ",message=" + message);
        //接收到exit消息后退出
        if (MessagePSub.EXIT_COMMAND.equals(message)) {
            System.exit(0);
        }
    }
}
