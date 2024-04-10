package com.hjx.leetcode.juc.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", 1);
        concurrentHashMap.put("2", 2);

        concurrentHashMap.get("1");
    }
}
