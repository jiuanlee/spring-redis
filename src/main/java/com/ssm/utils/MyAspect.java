/**
 * 
 */
package com.ssm.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ssm.framework.International;
import com.ssm.pojo.User;

/**
 * 切面类
 * 
 * @author Administrator
 *
 */
@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(public * com.ssm.serviceimpl..*.*(..))")
	public void myMethod() {
	};

	@Before("myMethod()")
	public void doBefore() {
		System.out.println("@before!!!");
	}

	@SuppressWarnings("unused")
	@Around("myMethod() && @annotation(international)")
	public Object doAroundMethod(ProceedingJoinPoint pjp,
			International international) throws Throwable {
		Class<?> cl = pjp.getTarget().getClass();
		// Class<?> clazz = pjp.getSignature().getDeclaringType();
		Object o = pjp.getSignature().getClass();
		Object[] args = pjp.getArgs();
		Object o1 = pjp.getStaticPart();
		String str = pjp.getSignature().getName();
		Method[] ms = cl.getDeclaredMethods();
//		for (Method m : ms) {
//			String methodName = m.getName();
//			if (str.equals(methodName)) {
//				Annotation[] an = m.getAnnotations();
//				for (Annotation a : an) {
//					if (a instanceof International) {
//						List<User> users = null;
//						Object ret = pjp.proceed();
//						if (ret instanceof Collection<?>) {
//							users = (List<User>) ret;
//						} else {
//							User user = (User) ret;
//							users = new ArrayList<>();
//							users.add(user);
//						}
//						for (User user : users) {
//							user.setSex(user.getSex() + "_EN");
//							user.setUserName(user.getUserName() + "_EN");
//						}
//						retVal = users;
//						return retVal;
//					}
//				}
//			}
//		}
		Object retVal = pjp.proceed();
		return retVal;// 这个就是返回的对象（方法调用返回的对象）
	}

	@After("myMethod()")
	public void after() {
		System.out.println("method after");
	}

	@AfterReturning("execution(public * com.ssm.dao..*.*(..))")
	public void AfterReturning() {
		System.out.println("method AfterReturning");
	}

}
