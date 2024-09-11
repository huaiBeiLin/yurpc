package com.yuxin.example.common.service;

import com.yuxin.example.common.model.User;

/**
 * packageName com.yiLin.example.common.service
 *
 * @author yuxin
 * @description 用户服务接口
 */
public interface UserService {
    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);
}
