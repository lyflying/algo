package com.lyflying.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: LY
 * @time: 2020/3/14 3:36 下午
 * @description: 线程唯一单例
 */
public class IdGeneratorThreadUniqueSingleton {

    private AtomicLong id = new AtomicLong(0);

    private static ConcurrentHashMap<Long, IdGeneratorThreadUniqueSingleton> instances = new ConcurrentHashMap<>();

    private IdGeneratorThreadUniqueSingleton(){}

    public static IdGeneratorThreadUniqueSingleton getInstance(){
        long threadId = Thread.currentThread().getId();
        instances.putIfAbsent(threadId, new IdGeneratorThreadUniqueSingleton());
        return instances.get(threadId);
    }

    public long getId(){
        return id.incrementAndGet();
    }

}
