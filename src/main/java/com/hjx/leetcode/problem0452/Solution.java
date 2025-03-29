package com.hjx.leetcode.problem0452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * 最大不重叠区间的个数，重叠的区间，只需要射箭一次就可以了。
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int curEnd = points[0][1];
        int res = 1;
        for (int[] point : points) {
            if (point[0] > curEnd) {
                res++;
                curEnd = point[1];
            }
        }
        return res;
    }
}
