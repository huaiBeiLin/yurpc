package com.yuxin.example.provider;

import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.registry.LocalRegistry;
import com.yuxin.yurpc.server.HttpServer;
import com.yuxin.yurpc.server.VertxHttpServer;

/**
 * packageName com.yiLin.example.provider
 *
 * @author yuxin
 * @description 服务提供者启动类
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8081);
    }
}
