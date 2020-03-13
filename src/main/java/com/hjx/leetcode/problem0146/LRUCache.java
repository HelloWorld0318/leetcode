package com.hjx.leetcode.problem0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>((int) (capacity / 0.75 + 1));
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                Map.Entry<Integer, Integer> head = getHead();
                map.remove(head.getKey());
            }
        }
        map.put(key, value);
    }

    public Map.Entry<Integer, Integer> getHead() {
        return map.entrySet().iterator().next();
    }
}
