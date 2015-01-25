package com.spring.example.example;

import com.spring.example.monitoring.TimeStampMonitoring;
import com.spring.example.monitoring.SearchType;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Igor.Shalaru on 25.01.2015.
 */
public class QuickPow {

    @TimeStampMonitoring(SearchType.POW)
    public BigInteger pow(BigInteger value, int pow) {
        BigInteger result = BigInteger.ONE;
        for(int i =0; i < pow; i++){
            result = value.multiply(result);
        }
        return result;
    }
    
    @TimeStampMonitoring(SearchType.MULTIPLY)
    public BigDecimal multiply(BigDecimal a, BigDecimal b){
        return a.multiply(b);    
    }

}


