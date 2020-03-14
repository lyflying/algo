package com.lyflying.designpattern.factory.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeanFactory beanFactory;
    private BeanconfigParser beanconfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanFactory = new BeanFactory();
        this.beanconfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        try (InputStream in = this.getClass().getResourceAsStream("/"+configLocation)){
            if(in == null){
                throw new RuntimeException("can not find config file:" + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanconfigParser.pares(in);
            beanFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }

}
