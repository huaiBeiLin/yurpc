package com.yuxin.yurpc.model;

/**
 * packageName com.yuxin.yurpc.model
 * 服务元信息（注册信息）
 */
public class ServiceMetaInfo {
    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务版本号
     */
    private String serviceVersion = "1.0";

    /**
     * 服务域名
     */
    private String serviceHost;

    /**
     * 服务端口号
     */
    private Integer servicePort;

    /**
     * 服务分组
     */
    private String serviceGroup = "default";

    /**
     * 获取服务键名
     */
    public String getServiceKey() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(serviceName).append(":").append(serviceVersion).append(":").append(serviceGroup);
//        return stringBuilder.toString();
        return String.format("%s:%s", serviceName, serviceVersion);
    }

    /**
     * 获取服务注册节点键名
     */
    public String getServiceNodeKey() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(getServiceKey()).append("/").append(serviceHost).append(":").append(servicePort);
//        return stringBuilder.toString();
        return String.format("%s/%s:%s", getServiceKey(), serviceHost, servicePort);
    }

}
