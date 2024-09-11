package com.yuxin.example.common.model;

import java.io.Serializable;

/**
 * packageName com.yiLin.example.common.model
 *
 * @author yuxin
 * @description User实体类
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
