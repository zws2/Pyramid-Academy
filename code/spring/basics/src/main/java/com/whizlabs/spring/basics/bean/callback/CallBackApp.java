package com.whizlabs.spring.basics.bean.callback;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CallBackApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(CallBackConfig.class);
        context.registerShutdownHook();
    }
}
