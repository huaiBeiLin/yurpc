package com.yuxin.example.consumer;

import com.yuxin.example.common.model.User;
import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.config.RpcConfig;
import com.yuxin.yurpc.proxy.ServiceProxyFactory;
import com.yuxin.yurpc.utils.ConfigUtils;

/**
 * packageName com.yuxin.example.consumer
 *  简易服务消费者示例
 */
public class ConsumerExample {
    public static  void main(String[] args) {
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.println(rpc);
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yuxin");
        // 调用
        System.out.println("第一次");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }

        long number = userService.getNumber();

        System.out.println(number);

        // 获取代理
        UserService userService1 = ServiceProxyFactory.getProxy(UserService.class);
        User user1 = new User();
        user1.setName("yuxin");
        // 调用
        System.out.println("第二次");
        User newUser1 = userService1.getUser(user1);
        if (newUser1 != null) {
            System.out.println(newUser1.getName());
        } else {
            System.out.println("user == null");
        }

        long number1 = userService1.getNumber();

        System.out.println(number1);

        // 获取代理
        UserService userService2 = ServiceProxyFactory.getProxy(UserService.class);
        User user2 = new User();
        user2.setName("yuxin");
        // 调用
        System.out.println("第三次");
        User newUser2 = userService2.getUser(user2);
        if (newUser2 != null) {
            System.out.println(newUser2.getName());
        } else {
            System.out.println("user == null");
        }

        long number2 = userService.getNumber();

        System.out.println(number2);
    }
}
