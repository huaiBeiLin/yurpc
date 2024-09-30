package com.yuxin.yurpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * packageName yurpc.utils
 * 工具类
 */
public class ConfigUtils {
    /**
     * 加载配置对象
     *
     * @param tClass
     * @param prefix
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象
     *
     * @param tClass
     * @param prefix
     * @param environment
     * @param <T>
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuiler = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuiler.append("-").append(environment);
        }
        configFileBuiler.append(".properties");
        Props props = new Props(configFileBuiler.toString());
        return props.toBean(tClass, prefix);
    }
}
