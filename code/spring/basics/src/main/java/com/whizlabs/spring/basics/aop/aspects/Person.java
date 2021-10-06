package com.whizlabs.spring.basics.aop.aspects;

public class Person implements Printable{
    private String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public void printFullName(){
        System.out.println("Full Name: " + fullName);
    }
}
