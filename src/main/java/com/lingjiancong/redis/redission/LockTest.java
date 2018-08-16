package com.lingjiancong.redis.redission;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBatch;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * @author lingjiancong
 */
public class LockTest {

    private static final String LOCK_NAME = "lock";

    @Test
    public void testLock() {
        Config config = new Config();
        SingleServerConfig singleConfig = config.useSingleServer();
        singleConfig.setPassword("default-password");
        singleConfig.setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);

        RBatch rBatch = redisson.createBatch();


        RLock rLock = redisson.getLock(LOCK_NAME);

        rLock.lock();

    }
}
