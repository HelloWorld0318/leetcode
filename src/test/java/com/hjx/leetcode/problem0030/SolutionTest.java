package com.hjx.leetcode.problem0030;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void findSubstring() {
        Solution solution = new Solution();
        String str = "wordgoodgoodgoodbestword";
        String[] word = {"word", "good", "best", "good"};
        List<Integer> ans = solution.findSubstring(str, word);
        System.out.println(ans);
    }
}