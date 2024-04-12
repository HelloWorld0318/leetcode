package com.hjx.leetcode.problem0146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @param <K>
 * @param <V>
 * @author houjinxiang
 */
public class LRUCacheUserLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCacheUserLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
