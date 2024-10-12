package com.yuxin.example.provider;

import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.RpcApplication;
import com.yuxin.yurpc.config.RegistryConfig;
import com.yuxin.yurpc.config.RpcConfig;
import com.yuxin.yurpc.model.ServiceMetaInfo;
import com.yuxin.yurpc.registry.LocalRegistry;
import com.yuxin.yurpc.registry.Registry;
import com.yuxin.yurpc.registry.RegistryFactory;
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
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = new RpcApplication().getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }

}
