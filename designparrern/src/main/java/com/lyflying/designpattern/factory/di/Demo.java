package com.lyflying.designpattern.factory.di;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Member member = (Member) applicationContext.getBean("member");
        member.test();
    }

}
