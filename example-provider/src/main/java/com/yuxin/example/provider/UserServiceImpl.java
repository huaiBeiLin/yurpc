package com.yuxin.example.provider;

import com.yuxin.example.common.model.User;
import com.yuxin.example.common.service.UserService;

/**
 * packageName com.yiLin.example.provider
 *
 * @author yuxin
 * @description 用户服务接口实现
 */
public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
