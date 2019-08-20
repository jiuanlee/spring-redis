package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler实现动态代理
 */
public class BizServiceProxy2 implements InvocationHandler {
    private IBizService target;

    public BizServiceProxy2(IBizService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doVerify();
        return method.invoke(target,args);
    }

    private void doVerify() {
        System.out.println(" 实现InvocationHandler=====执行验证操作======");
    }

}
