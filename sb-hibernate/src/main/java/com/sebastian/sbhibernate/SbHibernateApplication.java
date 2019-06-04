package com.sebastian.sbhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sebastian.sbhibernate")
public class SbHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbHibernateApplication.class, args);
    }

}
