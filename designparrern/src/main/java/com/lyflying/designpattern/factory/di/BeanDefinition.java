package com.lyflying.designpattern.factory.di;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton(){
        return scope.equals(Scope.SINGLETON);
    }

    public enum Scope {
        SINGLETON, PROTOTYPE
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public static class ConstructorArg{
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg() {
        }

        public boolean isRef() {
            return isRef;
        }

        public Class getType() {
            return type;
        }

        public Object getArg() {
            return arg;
        }
    }

}
