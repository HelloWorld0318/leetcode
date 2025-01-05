package com.hjx.leetcode.problem0001;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void twoSum() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    public void twoSumTarget() {
        Solution solution = new Solution();
//        [1,3],[2,2]
        List<List<Integer>> result = solution.twoSumTarget(new int[]{1, 1, 1, 2, 2, 3, 3}, 4);
        for (List<Integer> integers : result) {
            Arrays.stream(integers.toArray()).forEach(System.out::print);
            System.out.println();
        }
    }
}