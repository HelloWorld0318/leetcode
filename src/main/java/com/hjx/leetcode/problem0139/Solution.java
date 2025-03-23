package com.hjx.leetcode.problem0139;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private boolean isFound = false;
    private List<String> wordDict;
    private final LinkedList<String> track = new LinkedList<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        backTrack(s, 0);
        return isFound;
    }

    private void backTrack(String s, int i) {
        if (i == s.length()) {
            this.isFound = true;
            return;
        }
        if (this.isFound) {
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                track.addLast(word);
                backTrack(s, i + len);
                if (isFound) {
                    return;
                }
                track.removeLast();
            }
        }
    }

}
