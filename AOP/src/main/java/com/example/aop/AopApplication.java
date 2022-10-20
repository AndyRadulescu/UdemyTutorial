package com.example.aop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount();
        context.close();
    }
}
