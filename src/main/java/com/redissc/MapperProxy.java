package com.redissc;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy implements InvocationHandler {

    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {

            }
        }
        return new User((int)args[0],"zhangsan", 18);
    }

    public static void  main(String[] args){
        MapperProxy proxy =new MapperProxy();
        UserMapper mapper = proxy.newInstance(UserMapper.class);
        User user = mapper.selectByPrimaryKey(30);
        System.out.print(user);
    }
}
