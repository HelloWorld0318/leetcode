package com.hjx.leetcode.problem0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s != null && s.length() != 0 && words != null && words.length != 0) {
            Map<String, Integer> word2Count = new HashMap<>();
            for (String word : words) {
                word2Count.put(word, word2Count.getOrDefault(word, 0) + 1);
            }
            int length = words[0].length();
            int wordCount = words.length;
            for (int i = 0; i <= s.length() - length * wordCount; i++) {
                Map<String, Integer> copy = new HashMap<>(word2Count);
                for (int j = i; j < i + length * wordCount; j = j + length) {
                    String str = s.substring(j, j + length);
                    if (copy.containsKey(str)) {
                        int count = copy.get(str);
                        if (count > 1) {
                            copy.put(str, count - 1);
                        } else {
                            copy.remove(str);
                        }
                    } else {
                        break;
                    }
                }
                if (copy.isEmpty()) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}
