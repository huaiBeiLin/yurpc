package com.yuxin.yurpc;

import com.yuxin.yurpc.config.RegistryConfig;
import com.yuxin.yurpc.config.RpcConfig;
import com.yuxin.yurpc.registry.Registry;
import com.yuxin.yurpc.registry.RegistryFactory;
import com.yuxin.yurpc.utils.ConfigUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.yuxin.yurpc.constant.RpcConstant;

/**
 * packageName yurpc
 * RPC框架应用
 */
@Slf4j
@Data
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);

        // 创建并注册 Shutdown Hook, JVM退出时执行操作
        Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
    }

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcfonfig;
        try {
            newRpcfonfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            newRpcfonfig = new RpcConfig();
        }
        init(newRpcfonfig);
    }

    /**
     * 获取配置
     *
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized ((RpcApplication.class)) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
