package com.spring.example.monitoring;

import java.lang.annotation.*;

/**
 * Created by Igor.Shalaru on 25.01.2015.
 */
@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@Inherited
public @interface TimeStampMonitoring {
    SearchType value();
}
