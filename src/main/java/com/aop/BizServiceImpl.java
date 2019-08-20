package com.aop;

public class BizServiceImpl implements IBizService {
    @Override
    public void doBizOper() {
        System.out.println("======执行业务操作======");
    }
}
