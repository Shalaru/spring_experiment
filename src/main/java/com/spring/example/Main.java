package com.spring.example;

import com.spring.example.example.QuickPow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Igor.Shalaru on 07.09.2014.
 */
public class Main {

    public static void main(String ... args){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        QuickPow quickPow = context.getBean(QuickPow.class);
        BigInteger result = quickPow.pow(new BigInteger("1024"),10000);
        System.out.println(result);
        BigDecimal a = new BigDecimal(result.toString());
        BigDecimal b = new BigDecimal("12345678909876543234567898765432456787654323456");
        System.out.println(quickPow.multiply(a,b));

    }
}
