package com.jcg.constructor.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext contextObj = new ClassPathXmlApplicationContext("spring-beans.xml");
        Department deptObj = (Department) contextObj.getBean("departmentBean");
        deptObj.showResult();
    }
}