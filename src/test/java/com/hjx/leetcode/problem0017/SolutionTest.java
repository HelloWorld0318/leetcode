package com.hjx.leetcode.problem0017;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void letterCombinations() {
        Solution solution = new Solution();
        String digits = "03";
        List<String> result = solution.letterCombinations(digits);
        result.forEach(System.out::println);
    }
}