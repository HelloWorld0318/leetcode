package com.hjx.leetcode.problem0128;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestConsecutiveMapMethod(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }
        int result = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)) {
                continue;
            }
            int localResult = 1;
            map.put(key, true);
            for (int i = key + 1; map.containsKey(i); i++) {
                localResult++;
                map.put(i, true);
            }
            for (int i = key - 1; map.containsKey(i); i--) {
                localResult++;
                map.put(i, true);
            }
            result = Math.max(localResult, result);
        }
        return result;
    }


    public int longestConsecutive(int[] nums) {
        // 并查集的解法
        int result = 0;
        if (nums != null && nums.length > 0) {
            DisjointSet disjointSet = new DisjointSet(nums.length);
            Map<Integer, Integer> value2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                value2Index.put(nums[i], i);
            }

            for (Map.Entry<Integer, Integer> entry : value2Index.entrySet()) {
                int key = entry.getKey();
                int index = entry.getValue();
                if (value2Index.containsKey(key + 1)) {
                    disjointSet.union(index, value2Index.get(key + 1));
                }
                if (value2Index.containsKey(key - 1)) {
                    disjointSet.union(index, value2Index.get(key - 1));
                }
            }

            int[] size = disjointSet.getSize();
            for (int i : size) {
                result = Math.max(i, result);
            }
        }
        return result;
    }
}
