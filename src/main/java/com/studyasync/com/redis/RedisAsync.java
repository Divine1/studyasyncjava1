package com.studyasync.com.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.concurrent.CompletableFuture;

public class RedisAsync {
    public static void run() throws InterruptedException {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisAsyncCommands<String, String> asyncCommands = connection.async();

        asyncCommands.set("key", "Hello, Redis async!");
        RedisFuture<String> valueFuture = asyncCommands.get("user1");

        valueFuture.whenComplete((result,ex)->{
            System.out.println("result "+result);
        });
        Thread.sleep(10000);
        connection.close();
        redisClient.shutdown();
    }
}
