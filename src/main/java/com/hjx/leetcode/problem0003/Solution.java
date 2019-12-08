package com.hjx.leetcode.problem0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s != null && s.length() > 0) {
            Map<Character, Integer> char2Index = new HashMap<>((int) (s.length() / 0.75));
            int begin = -1;
            for (int i = 0; i < s.length(); i++) {
                if (char2Index.containsKey(s.charAt(i))) {
                    if (char2Index.get(s.charAt(i)) > begin) {
                        begin = char2Index.get(s.charAt(i));
                    }
                }
                char2Index.put(s.charAt(i), i);
                ans = Math.max(ans, i - begin);
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        if (s != null && s.length() > 0) {
            int statIndex = 0;
            ans = 1;
            int[] hash = new int[256];
            for (int i = 0; i < hash.length; i++) {
                hash[i] = -1;
            }
            hash[s.charAt(0)] = 0;
            for (int i = 1; i < s.length(); i++) {
                if (hash[s.charAt(i)] >= statIndex) {
                    statIndex = hash[s.charAt(i)] + 1;
                }
                hash[s.charAt(i)] = i;
                ans = Math.max(ans, i + 1 - statIndex);
            }
        }
        return ans;
    }
}
