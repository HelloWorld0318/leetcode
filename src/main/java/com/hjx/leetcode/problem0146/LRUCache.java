package com.hjx.leetcode.problem0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private int capacity;

    private LinkedHashMap<K, V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>((int) (capacity / 0.75 + 1));
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            V value = map.get(key);
            put(key, value);
            return value;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if (map.size() < capacity) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                Map.Entry<K, V> head = getHead();
                map.remove(head.getKey());
            }
        }
        map.put(key, value);
    }

    public Map.Entry<K, V> getHead() {
        return map.entrySet().iterator().next();
    }
}
