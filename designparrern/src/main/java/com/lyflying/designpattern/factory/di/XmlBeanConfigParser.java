package com.lyflying.designpattern.factory.di;

import com.sun.xml.internal.txw2.Document;
import org.xml.sax.InputSource;

import javax.xml.bind.Element;
import javax.xml.stream.events.Namespace;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlBeanConfigParser implements BeanconfigParser {

    @Override
    public List<BeanDefinition> pares(InputStream in) {
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[in.available()];
            in.read(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse(new String(bytes));
    }


    @Override
    public List<BeanDefinition> parse(String content) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        BeanDefinition.ConstructorArg arg1= new BeanDefinition.ConstructorArg(false, String.class, "zhangsan");
        BeanDefinition.ConstructorArg arg2= new BeanDefinition.ConstructorArg(false, int.class, 23);
        BeanDefinition beanDefinition = new BeanDefinition("user", "com.lyflying.designpattern.factory.di.User",
                Arrays.asList(arg1, arg2), BeanDefinition.Scope.SINGLETON, true);
        // todo 解析xml
        beanDefinitions.add(beanDefinition);
        return beanDefinitions;
    }

}
