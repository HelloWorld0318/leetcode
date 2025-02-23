package com.hjx.leetcode.problem0388;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Deque<String> deque = new LinkedList<>();
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level < deque.size()) {
                deque.removeLast();
            }
            deque.addLast(s.substring(level));
            //如果是一个文件的话，就开始计算最大值
            if (s.contains(".")) {
                int sum = deque.stream().mapToInt(String::length).sum();
                sum += (deque.size() - 1);
                maxLength = Math.max(maxLength, sum);
            }
        }
        return maxLength;
    }

}
