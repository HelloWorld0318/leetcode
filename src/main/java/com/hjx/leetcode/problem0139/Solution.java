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

    //现在给你一个不包含重复单词的单词列表 wordDict 和一个字符串 s，请你判断是否可以从 wordDict 中选出若干单词的排列（可以重复挑选）构成字符串 s。s
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
