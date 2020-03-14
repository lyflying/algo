package com.lyflying.designpattern.factory.di;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

}
