package com.whizlabs.spring.basics.ioc.configuation;

public class Person {
    private Name name;

    public Person(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
