package com.revature.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggingAspect")
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(com.revature.controller.*)")
	public void logWithinServicePackage() {}
	
	@Pointcut("within(com.revature.*)")
	public void loginWithinRepositoryPackage() {}

	@Before("logWithinServicePackage()")
	public void logBefore(JoinPoint jp){
		logger.info("Logging using Spring AOP. The method targeted is: " + jp.getSignature().getName());
	}
	
	@After("logWithinServicePackage()")
	public void logAfter(JoinPoint jp) {
		logger.info("Logging after: " + jp.getSignature().getName());
	}
	
	@AfterReturning(value = "logWithinServicePackage()", returning = "returnedObject")
	public void logAfterReturning(JoinPoint jp, Object returnedObject) {
		logger.info("Logging after the " + jp.getSignature().getName() + " method has returned " + returnedObject);
	}
	
	@AfterThrowing(value = "logWithinServicePackage()", throwing = "thrownException")
	public void logAfterThrowing(JoinPoint jp, Exception thrownException) {
		logger.info("Logging after the " + jp.getSignature().getName() + " method has thrown a(n) " + thrownException);
	}
	
	@Around("logWithinServicePackage()")
	public Object logAround(ProceedingJoinPoint pjp) {
		Object returnedValue = null;
		logger.info("using around advice (before) for the service layer methods");
		
		try {
			returnedValue = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.info("using around advice (after) for the service layer methods");

		return returnedValue;
	}

}