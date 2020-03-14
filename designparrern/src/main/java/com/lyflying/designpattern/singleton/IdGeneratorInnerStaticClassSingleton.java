package com.lyflying.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 内部静态类的方式实现
 */
public class IdGeneratorInnerStaticClassSingleton {

    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorInnerStaticClassSingleton() {
    }

    private static class SingletonHolder{
        private static final IdGeneratorInnerStaticClassSingleton instance = new IdGeneratorInnerStaticClassSingleton();
    }

    public static IdGeneratorInnerStaticClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }
}
