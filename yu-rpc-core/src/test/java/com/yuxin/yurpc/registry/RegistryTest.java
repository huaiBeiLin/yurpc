package com.yuxin.yurpc.registry;

import com.yuxin.yurpc.config.RegistryConfig;
import com.yuxin.yurpc.model.ServiceMetaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName com.yuxin.yurpc.registry
 * 注册中心测试
 */
class RegistryTest {
        final Registry registry = new EtcdRegistry();

        @BeforeEach
        public void init() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("http://localhost:2379");
            registry.init(registryConfig);
        }

        @Test
        public void register() throws Exception {
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName("myService");
            serviceMetaInfo.setServiceVersion("1.0");
            serviceMetaInfo.setServiceHost("localhost");
            serviceMetaInfo.setServicePort(1234);
            registry.register(serviceMetaInfo);
            serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName("myService");
            serviceMetaInfo.setServiceVersion("1.0");
            serviceMetaInfo.setServiceHost("localhost");
            serviceMetaInfo.setServicePort(1235);
            registry.register(serviceMetaInfo);
            serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName("myService");
            serviceMetaInfo.setServiceVersion("2.0");
            serviceMetaInfo.setServiceHost("localhost");
            serviceMetaInfo.setServicePort(1234);
            registry.register(serviceMetaInfo);
        }

        @Test
        public void unRegister() {
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName("myService");
            serviceMetaInfo.setServiceVersion("1.0");
            serviceMetaInfo.setServiceHost("localhost");
            serviceMetaInfo.setServicePort(1234);
            registry.unRegister(serviceMetaInfo);
        }

        @Test
        public void serviceDiscovery() {
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName("myService");
            serviceMetaInfo.setServiceName("1.0");
            String serviceKey = serviceMetaInfo.getServiceKey();
            List<ServiceMetaInfo> serviceMetaInfoList = registry.serviceDiscovery(serviceKey);
            Assert.assertNotNull(serviceMetaInfoList);
        }

        @Test
        public void heartBeat() throws Exception {
            // init 方法中已经执行心跳检测了
            register();
            // 阻塞 1 分钟
            Thread.sleep(60 * 1000L);
        }

}