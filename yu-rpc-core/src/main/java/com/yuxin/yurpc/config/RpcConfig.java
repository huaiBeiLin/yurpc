package com.yuxin.yurpc.config;

import lombok.Data;

/**
 * packageName yurpc.config
 * 保存配置信息
 */

@Data
public class RpcConfig {
    /**
     * 名称
     */
    private String name = "yu-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8089;

    /**
     * 模拟调用
     */
    private boolean mock = false;
}
