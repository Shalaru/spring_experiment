package com.spring.example.monitoring.aspect;

import com.spring.example.monitoring.TimeStampMonitoring;
import com.spring.example.monitoring.SearchType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Igor.Shalaru on 25.01.2015.
 */
@Aspect
@Order(0)
public class MonitoringAspect {
    private static Logger logger = LoggerFactory.getLogger(MonitoringAspect.class);

    @Around("execution(* com.spring.example.example.*.*(..)) && @annotation(com.spring.example.monitoring.TimeStampMonitoring)")
    public Object foundAnswer(ProceedingJoinPoint pjp) throws Throwable {
        return search(pjp);
    }

    private Object search(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        SearchType searchType = null;
        try {
            Method interfaceMethod = ((MethodSignature)pjp.getSignature()).getMethod();
            Method implementationMethod = ReflectionUtils.findMethod(pjp.getTarget().getClass(), interfaceMethod.getName(), interfaceMethod.getParameterTypes());
            Annotation[] annotations = implementationMethod.getAnnotations();
            for(Annotation a: annotations) {
                if(a instanceof TimeStampMonitoring) {
                    searchType = ((TimeStampMonitoring) a).value();
                    break;
                }
            }
        } catch(Throwable err1) {
            logger.error(err1.getMessage(), err1);
        }
        Long start = System.nanoTime();
        result = pjp.proceed();
        Long end = System.nanoTime();
        try {
            if(searchType != null) {
                System.out.println("TimeStampType: " + searchType + ", Duration : " + (end - start) + " ns");
            }
        }
        catch(Throwable err2) {
            logger.error(err2.getMessage(), err2);
        }
        return result;
    }

}
