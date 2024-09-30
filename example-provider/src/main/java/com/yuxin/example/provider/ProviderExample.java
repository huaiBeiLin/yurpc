package com.yuxin.example.provider;

import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.RpcApplication;
import com.yuxin.yurpc.registry.LocalRegistry;
import com.yuxin.yurpc.server.HttpServer;
import com.yuxin.yurpc.server.VertxHttpServer;

/**
 * packageName com.yuxin.example.provider
 * 简易服务提供者示例
 */
public class ProviderExample {
    public static void main(String[] args) {
        // RPC框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }

}
