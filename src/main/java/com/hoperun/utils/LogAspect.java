package com.hoperun.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @descriptiom:通知的切面
 * @Author: 武政旭
 * @Date: 2019/7/31 14:40
 */
@Aspect
@Component
public class LogAspect {
    //创建一个日志对象
    private static Logger logger= LogManager.getLogger(LogAspect.class.getName());


    //前置通知===参数：切入点表达式--指定类的所有方法--括号里面是参数
    @Before("execution(public * com.hoperun..service.impl.UserloginServiceImpl.* (com.hoperun..pojo.User))")
    public void before(JoinPoint point){
        System.out.println("前置日志信息："+point.getSignature().getName()+"");
        logger.info("前置日志信息："+point.getSignature().getName()+"");
    }


    //后置通知
    @After("execution(public * com.hoperun..service.impl.UserloginServiceImpl.* (com.hoperun..pojo.User))")
    public void after(JoinPoint point){
        System.out.println("后置日志信息："+point.getSignature().getName()+"");
        logger.info("后置日志信息："+point.getSignature().getName()+"");
    }

    //返回通知
    @AfterReturning(value="execution(public * com.hoperun..service.impl.UserloginServiceImpl.* (com.hoperun..pojo.User))",returning="result")
    public void afterReturning(JoinPoint point,Object result){
        System.out.println("返回通知:"+point.getSignature().getName()+"("+point.getArgs()+")"+",result:"+result);
        logger.info("返回通知:"+point.getSignature().getName()+"("+point.getArgs()+")"+",result:"+result);
    }

    //异常通知
    @AfterThrowing(value="execution(public * com.hoperun..service.impl.UserloginServiceImpl.* (com.hoperun..pojo.User))",throwing="ex")
    public void afterThrowing(JoinPoint point,Exception ex){
        System.out.println("异常通知:"+point.getSignature().getName()+"("+point.getArgs()+")"+",exception:"+ex);
        logger.info("异常通知:"+point.getSignature().getName()+"("+point.getArgs()+")"+",exception:"+ex);
    }

    //环绕通知
    @Around("execution(public * com.hoperun..service.impl.UserloginServiceImpl.* (com.hoperun..pojo.User))")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        Object result=null;
        System.out.println("环绕通知之前要做的事情："+point.getSignature().getName());
        //在这个地方是有throws Throwable,以便在异常通知时，获取异常信息
        result=point.proceed();

        System.out.println("环绕通知之后要做的事情："+point.getSignature().getName());
        return result;
    }
}
