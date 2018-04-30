package com.lxl.annocation;

public @interface SetValue {

    Class<?> beanClass();

    String method();

    String paramField();

    String targetField() default "";
}
