package com.hjx.leetcode.problem0049;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void groupAnagrams() {
        Solution solution = new Solution();
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = solution.groupAnagrams(array);
        System.out.println(ans);
    }
}