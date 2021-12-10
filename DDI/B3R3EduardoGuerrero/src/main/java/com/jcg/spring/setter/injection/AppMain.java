package com.jcg.spring.setter.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext contextObj = new ClassPathXmlApplicationContext("spring-beans.xml");
        Employee empObj = (Employee) contextObj.getBean("employeeBean");
        empObj.showResult();
    }
}