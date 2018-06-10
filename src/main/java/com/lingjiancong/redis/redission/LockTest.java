package com.lingjiancong.redis.redission;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * @author lingjiancong
 */
public class LockTest {

    private static final String LOCK_NAME = "lock";

    @Test
    public void testLock() {
        RedissonClient redisson = Redisson.create();

        RLock rLock = redisson.getLock(LOCK_NAME);

        rLock.lock();

    }
}
