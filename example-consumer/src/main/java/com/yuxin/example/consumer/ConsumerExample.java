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
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }

        long number = userService.getNumber();
        System.out.println(number);
    }
}
