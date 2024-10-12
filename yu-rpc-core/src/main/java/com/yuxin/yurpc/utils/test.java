package com.yuxin.yurpc.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * packageName com.yuxin.yurpc.utils
 *
 */
public class test {
    public static void main(String[] args) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "面试鸭");

        CompletableFuture<String> future = future2
                .thenCombine(future1, (result1, result2) -> result1 + result2)
                .exceptionally(ex -> "报错啦")
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Default Value";
                    }
                    return result;
                })
                ;
        CompletableFuture.runAsync(()->{});

        try {
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result); // 输出结果
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}
