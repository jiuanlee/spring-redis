package com.ssm.redis.test;

import com.ssm.framework.redismsg.MessageProducer;
import org.junit.Test;

public class TestMsg/* extends BaseTest*/ {


    @Test
    public void TestProducer() {
        MessageProducer messageProducer = new MessageProducer();
        Thread t1 = new Thread(messageProducer, "thread1");
//        Thread t2 = new Thread(messageProducer, "thread2");
//        Thread t3 = new Thread(messageProducer, "thread3");
//        Thread t4 = new Thread(messageProducer, "thread4");
//        Thread t5 = new Thread(messageProducer, "thread5");
        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
    }

}
