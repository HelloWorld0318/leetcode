package com.hjx.leetcode.problem1109;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void corpFlightBookings() {
        Solution solution = new Solution();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] ans = solution.corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(ans));
    }
}