package com.lyflying.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器懒汉单例
 */
public class IdGeneratorLazySingleton {

    private AtomicLong id = new AtomicLong(0);

    private static IdGeneratorLazySingleton instance = null;

    /**
     * 防止在外部构造对象
     */
    private IdGeneratorLazySingleton(){}

    /**
     * 加锁防止并发，不过性能不好
     * @return
     */
    public synchronized static IdGeneratorLazySingleton getInstance(){
        if(instance == null){
            instance = new IdGeneratorLazySingleton();
        }
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

}
