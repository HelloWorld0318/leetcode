package com.hjx.leetcode.problem0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s != null && s.length() > 0) {
            int startIndex = 0;
            ans = 1;
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>((int) (chars.length / 0.75 + 1));
            map.put(chars[0], 0);
            for (int i = 1; i < chars.length; i++) {
                if (map.containsKey(chars[i]) && map.get(chars[i]) >= startIndex) {
                    startIndex = map.get(chars[i]) + 1;
                }
                map.put(chars[i], i);
                ans = Math.max(ans, i + 1 - startIndex);
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
