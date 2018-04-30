package com.lxl;

import com.lxl.annocation.SetValue;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
public class Order {

    private String id;
    private String customerId;

    @SetValue(beanClass = User.class,method = "find",paramField = "customerId",targetField = "userName")
    private String customerName;


}
