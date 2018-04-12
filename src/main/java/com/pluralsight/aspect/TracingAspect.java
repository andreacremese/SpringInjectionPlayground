package com.pluralsight.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

@Component
@Aspect
public class TracingAspect {
    final static Logger logger = Logger.getLogger(TracingAspect.class);


//    @Before("within(@com.pluralsight.service.CustomerServiceImp *)")



//    @Around("execution(* findAll(..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object output = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        logger.info(">>>>>>>>>>>>>>>>>> this was called " );
//        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return output;
//    }




//    @Pointcut("execution(* com.pluralsight.service.CustomerServiceImp.findAll.(..))")
    @Pointcut("within(com.pluralsight.service.CustomerServiceImp)")
    public void service() { }
//
//
    @Around("service()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info(">>>>>>>>>>>>>>>>>> this was called " + pjp.getSignature().toString());
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }


}
