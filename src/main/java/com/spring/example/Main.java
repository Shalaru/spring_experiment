package com.spring.example;

import com.spring.example.example.QuicPow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created by Igor.Shalaru on 07.09.2014.
 */
public class Main {

    public static void main(String ... args){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        QuicPow quicPow = context.getBean(QuicPow.class);
        BigInteger result = quicPow.pow(new BigInteger("1024"),1000000);
        System.out.println(result);

    }
}
