package com.hjx.leetcode.problem1109;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        return brutalSolution(bookings, n);
    }

    public int[] brutalSolution(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] item = bookings[i];
            int left = item[0] - 1;
            int right = item[1] - 1;
            int bookingCount = item[2];
            for (int j = left; j <= right; j++) {
                ans[j] += bookingCount;
            }
        }
        return ans;
    }
}
