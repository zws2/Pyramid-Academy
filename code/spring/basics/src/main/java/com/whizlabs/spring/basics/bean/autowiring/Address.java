package com.whizlabs.spring.basics.bean.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Address {
    private int number;
    private String street;

    public Address(int number, String street) {
        this.number = number;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", street='" + street + '\'' +
                '}';
    }
}
