package com.lyflying.designpattern.factory.di;

import java.io.InputStream;
import java.util.List;

public interface BeanconfigParser {
    List<BeanDefinition> pares(InputStream in);
    List<BeanDefinition> parse(String content);
}
