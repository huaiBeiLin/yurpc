package com.yuxin.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yuxin.example.common.model.User;
import com.yuxin.example.common.service.UserService;
import com.yuxin.yurpc.Serializer.JdkSerializer;
import com.yuxin.yurpc.Serializer.Serializer;
import com.yuxin.yurpc.model.RpcRequest;
import com.yuxin.yurpc.model.RpcResponse;

import java.io.IOException;

/**
 * packageName com.yuxin.example.consumer
 *
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8081")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
