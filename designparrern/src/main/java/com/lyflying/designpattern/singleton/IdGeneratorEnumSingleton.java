package com.lyflying.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum  IdGeneratorEnumSingleton {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return id.incrementAndGet();
    }
}
