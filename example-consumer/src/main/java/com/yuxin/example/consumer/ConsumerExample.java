package com.yuxin.example.consumer;

import com.yuxin.yurpc.config.RpcConfig;
import com.yuxin.yurpc.utils.ConfigUtils;

/**
 * packageName com.yuxin.example.consumer
 *  简易服务消费者示例
 */
public class ConsumerExample {
    public static  void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
