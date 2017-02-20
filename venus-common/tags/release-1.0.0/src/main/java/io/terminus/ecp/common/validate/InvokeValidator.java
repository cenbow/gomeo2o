/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.validate;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Author: haolin
 * On: 9/2/14
 */
@Slf4j
public class InvokeValidator {


    static class SingletonHolder {
        static InvokeValidator instance = new InvokeValidator();
    }

    public static InvokeValidator instance() {
        return SingletonHolder.instance;
    }


    private ExecutableValidator validator;

    private InvokeValidator(){
        this.validator = Validation
                    .buildDefaultValidatorFactory()
                    .getValidator()
                    .forExecutables();
    }

    /**
     * 参数验证
     * @param target 目标对象
     * @param method 目标方法
     * @param args 调用参数
     */
    public void validateParams(Object target, Method method, Object[] args) {
        Set<ConstraintViolation<Object>> violations = validator.validateParameters(target, method, args);
        if (violations.size() > 0){
            log.error("failed to validate service({})'s method({})'s params: {}", target, method, violations);
            throw new IllegalArgumentException(violations.iterator().next().getMessage());
        }
    }
}