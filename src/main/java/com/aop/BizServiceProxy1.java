package com.aop;

/**
 * 静态代理，特点：为每一个业务增强都提供一个代理类, 由代理类来创建代理对象
 */

public class BizServiceProxy1 implements IBizService {
    private IBizService target;

    public BizServiceProxy1(IBizService target) {
        this.target = target;
    }

    @Override
    public void doBizOper() {
        doVerify();
        target.doBizOper();
    }

    private void doVerify() {
        System.out.println("静态代理======执行验证操作======");
    }
}
