package com.hjx.leetcode.problem0001;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void twoSum() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(result).forEach(System.out::println);

    }
}