package com.aop;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 不管有没有接口都可以使用CGLIB动态代理, 而不是只有在无接口的情况下才能使用.
 */
public class BizServiceProxy3 implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        doVerify();
        //return method.invoke(target,args);
        return methodProxy.invokeSuper(target, args);
    }


    private void doVerify() {
        System.out.println("MethodInterceptor === 验证====");
    }

}
