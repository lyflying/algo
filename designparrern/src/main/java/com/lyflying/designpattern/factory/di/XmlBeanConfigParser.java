package com.lyflying.designpattern.factory.di;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlBeanConfigParser implements BeanconfigParser {

    @Override
    public List<BeanDefinition> pares(InputStream in) {
        String content = null;
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String content) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // todo
        return beanDefinitions;
    }

}
