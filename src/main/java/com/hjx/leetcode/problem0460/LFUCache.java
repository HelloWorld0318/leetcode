package com.hjx.leetcode.problem0460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    /**
     * 当前的容量
     */
    private int capacity;

    /**
     * 当前的最低频率
     */
    private int minFrq;

    /**
     * key,v
     */
    private HashMap<Integer, Integer> key2Val;

    /**
     * key,freq
     */
    private HashMap<Integer, Integer> key2Freq;

    /**
     * freq,linkedHashSet(频率相同的key列表)
     */
    private Map<Integer, LinkedHashSet<Integer>> freq2KeyList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrq = 0;
        this.key2Val = new HashMap<>();
        this.key2Freq = new HashMap<>();
        this.freq2KeyList = new HashMap<>();
    }

    public int get(int key) {
        if (!key2Val.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return key2Val.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }
        if (key2Val.containsKey(key)) {
            key2Val.put(key, value);
            increaseFreq(key);
            return;
        }
        if (this.capacity <= key2Val.size()) {
            //淘汰缓存
            removeByFreq();
        }
        key2Val.put(key, value);
        key2Freq.put(key, 1);
        freq2KeyList.putIfAbsent(1, new LinkedHashSet<>());
        freq2KeyList.get(1).add(key);
        this.minFrq = 1;
    }

    private void removeByFreq() {
        //freq最小的key列表
        LinkedHashSet<Integer> keyList = this.freq2KeyList.get(this.minFrq);
        //其中最先被插入的那个key就是该被淘汰的key
        Integer curDelKey = keyList.iterator().next();
        keyList.remove(curDelKey);
        if (keyList.size() == 0) {
            this.freq2KeyList.remove(this.minFrq);
        }
        key2Val.remove(curDelKey);
        key2Freq.remove(curDelKey);
    }

    public void increaseFreq(Integer key) {
        int oldFreq = this.key2Freq.get(key);
        int newFreq = oldFreq + 1;
        key2Freq.put(key, newFreq);
        freq2KeyList.get(oldFreq).remove(key);
        freq2KeyList.putIfAbsent(newFreq, new LinkedHashSet<>());
        freq2KeyList.get(newFreq).add(key);

        if (freq2KeyList.get(oldFreq).size() == 0) {
            freq2KeyList.remove(oldFreq);
            if (oldFreq == this.minFrq) {
                this.minFrq++;
            }
        }
    }
}
