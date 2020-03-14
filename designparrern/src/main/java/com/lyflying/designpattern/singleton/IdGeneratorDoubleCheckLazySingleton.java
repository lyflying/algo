package com.lyflying.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器双重锁检测懒汉单例
 */
public class IdGeneratorDoubleCheckLazySingleton {

    private AtomicLong id = new AtomicLong(0);

    private static IdGeneratorDoubleCheckLazySingleton instance = null;

    /**
     * 防止在外部构造对象
     */
    private IdGeneratorDoubleCheckLazySingleton(){}

    /**
     * 双重检测，并发度低
     * @return
     */
    public static IdGeneratorDoubleCheckLazySingleton getInstance(){
        if(instance == null){
            synchronized (IdGeneratorDoubleCheckLazySingleton.class){
                if(instance == null){
                    instance = new IdGeneratorDoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

}
