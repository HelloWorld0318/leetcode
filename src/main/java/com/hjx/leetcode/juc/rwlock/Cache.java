package com.hjx.leetcode.juc.rwlock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {

    final Map<K, V> m = new HashMap<>();

    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 读锁
     */
    final Lock r = rwl.readLock();

    /**
     * 写锁
     */
    final Lock w = rwl.writeLock();

    public V getV(K key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    V put(K key, V val) {
        w.lock();
        try {
            return m.put(key, val);
        } finally {
            w.unlock();
        }
    }
}
