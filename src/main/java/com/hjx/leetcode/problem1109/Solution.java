package com.hjx.leetcode.problem1109;

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            ans[bookings[i][0] - 1] += bookings[i][2];

            if (bookings[i][1] < n) {
                ans[bookings[i][1]] -= bookings[i][2];
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }


    public int[] brutalSolution(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] item = bookings[i];
            int left = item[0] - 1;
            int right = item[1] - 1;
            int seat = item[2];
            for (int j = left; j <= right; j++) {
                ans[j] += seat;
            }
        }
        return ans;
    }

}
