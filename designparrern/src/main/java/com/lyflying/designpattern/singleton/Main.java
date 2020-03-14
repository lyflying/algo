package com.lyflying.designpattern.singleton;

/**
 * @author: ly
 * @time: 2020/3/14 3:14 下午
 * @description: 单例的测试类
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========饿汉模式======");
        System.out.println(IdGeneratorHungrySingleton.getInstance().getId());
        System.out.println(IdGeneratorHungrySingleton.getInstance().getId());

        System.out.println("========懒汉模式======");
        System.out.println(IdGeneratorLazySingleton.getInstance().getId());
        System.out.println(IdGeneratorLazySingleton.getInstance().getId());

        System.out.println("========双重检测======");
        System.out.println(IdGeneratorDoubleCheckLazySingleton.getInstance().getId());
        System.out.println(IdGeneratorDoubleCheckLazySingleton.getInstance().getId());

        System.out.println("========内部静态类======");
        System.out.println(IdGeneratorInnerStaticClassSingleton.getInstance().getId());
        System.out.println(IdGeneratorInnerStaticClassSingleton.getInstance().getId());

        System.out.println("========枚举单例======");
        System.out.println(IdGeneratorEnumSingleton.INSTANCE.getId());
        System.out.println(IdGeneratorEnumSingleton.INSTANCE.getId());

        System.out.println("========线程唯一单例======");
        System.out.println(IdGeneratorThreadUniqueSingleton.getInstance().getId());
        System.out.println(IdGeneratorThreadUniqueSingleton.getInstance().getId());
        Thread thread = new Thread(() -> System.out.println(IdGeneratorThreadUniqueSingleton.getInstance().getId()));
        thread.start();
        thread.join();
    }
}
