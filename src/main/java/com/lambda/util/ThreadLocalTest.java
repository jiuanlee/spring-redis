/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * 
 * 项目名：	spring-redis
 * 文件名：	ThreadLocalTest.java
 * 模块说明：	
 * 修改历史：
 * 2019年8月1日 - lijiuan - 创建。
 */
package com.lambda.util;

import java.util.concurrent.TimeUnit;

/**
 * @author lijiuan
 *
 */
public class ThreadLocalTest {
  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

  public static void main(String[] args) {
    new Thread(() -> {
      try {
        for (int i = 0; i < 100; i++) {
          threadLocal.set(1);
          System.out.println(Thread.currentThread().getName()+" === "+threadLocal.get());
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      } finally {
        threadLocal.remove();
      }

    }, "threadLocal1").start();

    new Thread(() -> {
      try {
        for (int i = 0; i < 100; i++) {
          threadLocal.set(2);
          System.out.println(Thread.currentThread().getName()+" === "+threadLocal.get());
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      } finally {
        threadLocal.remove();
      }

    }, "threadLocal2").start();
  }
}
