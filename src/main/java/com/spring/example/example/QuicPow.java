package com.spring.example.example;

import com.spring.example.monitoring.SearchMonitoring;
import com.spring.example.monitoring.SearchType;

import java.math.BigInteger;

/**
 * Created by Igor.Shalaru on 25.01.2015.
 */
public class QuicPow {

    @SearchMonitoring(SearchType.TEST)
    public BigInteger pow(BigInteger value, int pow) {
        BigInteger result = BigInteger.ONE;
        for(int i =0; i < pow; i++){
            result = value.multiply(result);
        }
        return result;
    }

}


