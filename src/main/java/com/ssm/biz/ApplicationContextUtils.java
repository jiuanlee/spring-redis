package com.ssm.biz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils  implements ApplicationContextAware {
    private static ApplicationContextUtils instance = null;

    public static synchronized ApplicationContextUtils getInstance() {
        if (instance == null) {
            instance = new ApplicationContextUtils();
        }
        return instance;
    }

    private ApplicationContextUtils() {

    }

    private ApplicationContext appCtx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        getInstance().appCtx = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return getInstance().appCtx;
    }

    public static <T> T getBean(String name) {
        return (T) getInstance().appCtx.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return getInstance().appCtx.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return getInstance().appCtx.getBean(name, requiredType);
    }
}
