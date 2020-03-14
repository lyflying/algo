package com.lyflying.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器饿汉单例
 */
public class IdGeneratorHungrySingleton {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGeneratorHungrySingleton instance = new IdGeneratorHungrySingleton();

    /**
     * 防止在外部构造对象
     */
    private IdGeneratorHungrySingleton(){};

    public static IdGeneratorHungrySingleton getInstance(){
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

}
