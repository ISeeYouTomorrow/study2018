package com.lxl.dubboprovider.service;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/27
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String userName) {
        return "Hello, "+userName;
    }
}
