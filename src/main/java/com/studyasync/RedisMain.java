package com.studyasync;

import com.studyasync.com.redis.RedisAsync;
import com.studyasync.com.redis.RedisSync;

public class RedisMain {
    public static void main(String[] args) throws InterruptedException {
        //RedisSync.run();
        RedisAsync.run();
    }
}
