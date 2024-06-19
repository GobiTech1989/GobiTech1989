package com.gobi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TraceIODataAdvice {

	@Around("@annotation(com.gobi.annotation.TraceData)")
    public Object traceIOData(ProceedingJoinPoint point) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String clazzName = point.getTarget().getClass().toString();
		String methodName = point.getSignature().getName();
		Object[] objArgs = point.getArgs();
		log.info(clazzName+" :: "+methodName+"() => Args :: "+mapper.writeValueAsString(objArgs));
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        log.info(clazzName+" :: "+methodName+"() => Time taken for Execution is : " + (endtime-startTime) +"ms");
        log.info(clazzName+" :: "+methodName+"() => Response :: "+mapper.writeValueAsString(object));
        return object;
    }
}
