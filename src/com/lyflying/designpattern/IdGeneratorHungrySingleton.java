package com.lyflying.designpattern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器饿汉单例
 */
public class IdGeneratorHungrySingleton {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGeneratorHungrySingleton instance = new IdGeneratorHungrySingleton();

    private IdGeneratorHungrySingleton(){};

    public static IdGeneratorHungrySingleton getInstance(){
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

}
