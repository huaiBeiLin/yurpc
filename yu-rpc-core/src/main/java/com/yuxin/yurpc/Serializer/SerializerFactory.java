package com.yuxin.yurpc.Serializer;

import com.yuxin.yurpc.RpcApplication;
import com.yuxin.yurpc.spi.SpiLoader;


/**
 * packageName com.yuxin.yurpc.Serializer
 * 序列化器工厂（用于获取序列化对象）
 */
public class SerializerFactory {
//    static {
//        SpiLoader.load(Serializer.class);
//    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 判断是否已经背实例化
     */
    private static boolean init_flag = false;

    /**
     * 懒加载创建序列化器实例
     */
    public static void init() {
        if (init_flag == false) {
            synchronized ((RpcApplication.class)) {
                if (init_flag == false) {
                    SpiLoader.load(Serializer.class);
                    init_flag = true;
                }
            }
        }
    }

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }
}
