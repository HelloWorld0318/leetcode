package com.hjx.leetcode.problem0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int upI = 0, upJ = 0;
        int downJ = n - 1, downI = m - 1;
        while (res.size() < m * n) {
            //上面的从左往右
            if (upI <= downI) {
                for (int j = upJ; j <= downJ; j++) {
                    res.add(matrix[upI][j]);
                }
                upI++;
            }

            //右边从上往下
            if (upJ <= downJ) {
                for (int i = upI; i <= downI; i++) {
                    res.add(matrix[i][downJ]);
                }
                downJ--;
            }

            //下面从右往左
            if (upI <= downI) {
                for (int j = downJ; j >= upJ; j--) {
                    res.add(matrix[downI][j]);
                }
                downI--;
            }

            //左边从下往上
            if (upJ <= downJ) {
                for (int i = downI; i >= upI; i--) {
                    res.add(matrix[i][upJ]);
                }
                upJ++;
            }
        }
        return res;
    }
}
