package com.hjx.leetcode.problem0409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }


        Map<Character, Integer> char2Count = new HashMap<>((int) (s.length() / 0.75));
        for (char ch : s.toCharArray()) {
            if (char2Count.containsKey(ch)) {
                char2Count.put(ch, char2Count.get(ch) + 1);
            } else {
                char2Count.put(ch, 1);
            }
        }

        int ans = 0;
        int sigleCount = 0;
        for (Map.Entry<Character, Integer> entry : char2Count.entrySet()) {
            if (entry.getValue() >= 2) {
                ans += 2 * (entry.getValue() / 2);
                sigleCount += entry.getValue() % 2;
            } else {
                sigleCount++;
            }
        }
        if (sigleCount > 0) {
            ans++;
        }
        return ans;
    }
}
