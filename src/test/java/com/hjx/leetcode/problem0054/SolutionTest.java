package com.hjx.leetcode.problem0054;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testSpiralOrder() {
        Solution solution = new Solution();
        int[][] matrix =
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> res =  solution.spiralOrder(matrix);
        System.out.println(res);
    }

    @Test
    public void testSpiralOrder2() {
        Solution solution = new Solution();
        int[][] matrix =
                {{1}, {5}, {9}};
        List<Integer> res =  solution.spiralOrder(matrix);
        System.out.println(res);
    }
}