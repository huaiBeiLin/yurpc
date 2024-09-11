package com.yuxin.example.consumer;


import com.yuxin.example.common.model.User;
import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.proxy.ServiceProxyFactory;

/**
 * packageName com.yiLin.example.consumer
 *
 * @author yuxin
 * @description 简易服务消费者示例
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // todo 需要获取UserService的实现类对象
        // 静态代理
        // UserService userService = new UserServiceProxy();

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yuxin");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
