package com.aop;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class AopTest {

    public static void main(String[] args) {
        //1.静态代理
        BizServiceProxy1 proxy1 = new BizServiceProxy1(new BizServiceImpl());
        proxy1.doBizOper();

        //2.InvocationHandler动态代理
        IBizService target1 = new BizServiceImpl();
        IBizService bizService = (IBizService) Proxy.newProxyInstance(target1.getClass().getClassLoader(), target1.getClass().getInterfaces(), new BizServiceProxy2(target1));
        bizService.doBizOper();
        //3. cgLib实现动态代理
        IBizService target2 = new BizServiceImpl();
        IBizService iBizService = (IBizService) Enhancer.create(target2.getClass(), new BizServiceProxy3());
        iBizService.doBizOper();

    }
}
