package com.luckk.lizzie.datasource;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSourceSelector {

    String value();
}
