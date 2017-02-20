/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.validate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 服务调用验证器
 * Author: haolin
 * On: 9/12/14U
 */
@Component @Aspect
public class ServiceInvokeValidator {

    @Before("execution(* io.terminus.ecp..service.*.*(..))")
    public void validate(final JoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        InvokeValidator.instance().validateParams(point.getTarget(), method, point.getArgs());
    }
}
