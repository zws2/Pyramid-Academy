package com.whizlabs.spring.basics.bean.callback;

import org.springframework.context.annotation.Bean;

public class CallBackConfig {
    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    public DemoBean demoBean(){
        return new DemoBean();
    }
}
