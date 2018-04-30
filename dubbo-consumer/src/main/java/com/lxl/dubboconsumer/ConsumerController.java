package com.lxl.dubboconsumer;

import com.lxl.dubboprovider.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/27
 */
@Controller
public class ConsumerController {

    @Resource
    private UserService userService;

    @RequestMapping("/test/{userName}")
    @ResponseBody
    public String testService(@PathVariable("userName") String userName){
        return userService.sayHello(userName);
    }
}
