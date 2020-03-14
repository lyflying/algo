package com.lyflying.designpattern.factory.di;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        for(BeanDefinition beanDefinition : beanDefinitions){
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }

        for(BeanDefinition beanDefinition : beanDefinitions){
            if(!beanDefinition.isLazyInit() && beanDefinition.isSingleton()){
                createBean(beanDefinition);
            }
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if(beanDefinition == null){
            throw new RuntimeException("no such bean defined");
        }
        return createBean(beanDefinition);
    }

    protected Object createBean(BeanDefinition beanDefinition) {
        if(beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())){
            return singletonObjects.get(beanDefinition.getId());
        }

        Object bean = null;
        try {
            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();
            if(args.isEmpty()){
                bean = beanClass.newInstance();
            }else {
                Class[] argClasses = new Class[args.size()];
                Object[] argObjects = new Object[args.size()];
                for(int i = 0; i <args.size(); ++i){
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if(!arg.isRef()){
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    }else{
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if(refBeanDefinition == null){
                            throw new RuntimeException("can not find defined");
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bean != null && beanDefinition.isSingleton()){
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }
}
