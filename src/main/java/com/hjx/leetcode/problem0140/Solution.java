package com.hjx.leetcode.problem0140;

import java.util.*;

public class Solution {


    private LinkedList<String> tarck = new LinkedList<>();

    private List<String> result = new ArrayList<>();

    private Set<String> wordDict = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        backTrack(s, 0);
        return result;
    }

    private void backTrack(String s, int i) {
        if (i == s.length()) {
            result.add(String.join(" ", tarck));
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len <= s.length() && word.equals(s.substring(i, i + len))) {
                this.tarck.addLast(word);
                backTrack(s, i + len);
                this.tarck.removeLast();
            }
        }
    }
}
