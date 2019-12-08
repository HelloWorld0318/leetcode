package com.hjx.leetcode.problem0187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> str2Count = new HashMap<>();
        if (s != null && s.length() >= 10) {
            for (int i = 0; i <= s.length() - 10; i++) {
                String key = s.substring(i, i + 10);
                if (str2Count.containsKey(key)) {
                    str2Count.put(key, str2Count.get(key) + 1);
                } else {
                    str2Count.put(key, 1);
                }
            }
            str2Count.forEach((k, v) -> {
                if (v > 1) {
                    ans.add(k);
                }
            });
        }
        return ans;
    }
}
