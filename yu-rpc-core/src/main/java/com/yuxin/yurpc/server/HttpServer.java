package com.yuxin.yurpc.server;

/**
 * packageName com.yiLin.yurpc.server
 *
 * @author yuxin
 * @description web服务器接口
 */
public interface HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
}
