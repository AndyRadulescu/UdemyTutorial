package com.example.udemytutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.udemytutorial.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.example.udemytutorial.services.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.example.udemytutorial.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint point) {
        String method = point.getSignature().toLongString();
        logger.info("======>> in @Before: calling method: " + method);

        Object[] args = point.getArgs();
        Arrays.stream(args).forEach(arg -> logger.info("======>> argument: " + arg));
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint point, Object result) {
        String method = point.getSignature().toLongString();
        logger.info("======>> in @AfterReturning: from method: " + method);

        logger.info("======>> result: " + result);
    }
}
