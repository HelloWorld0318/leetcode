package com.hjx.leetcode.problem0089;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n >= 0) {
            int size = 1 << n;
            for (int i = 0; i < size; i++) {
                ans.add(binaryToGray(i));
            }
        }
        return ans;
    }

    public int binaryToGray(int n) {
        // 数学公示，整数n的Gray码是 n^(n/2)
        return n ^ (n >> 1);
    }
}