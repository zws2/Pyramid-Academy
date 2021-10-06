package com.whizlabs.spring.basics.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJAspect {
    @Before("execution(* printFullName())")
    private void log(){
        System.out.println("Printed by an advice");
    }
}
