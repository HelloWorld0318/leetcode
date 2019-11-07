package com.hjx.leetcode.problem0085;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 这道题的二维矩阵每一层向上都可以看做一个直方图，
        // 输入矩阵有多少行，就可以形成多少个直方图，对每个直方图都调用 Largest Rectangle in Histogram 中的方法，
        // 就可以得到最大的矩形面积。
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] grid = new int[rows][columns];
        buildHistogram(matrix, grid);
        int max = 0;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, largestRectangleArea(grid[i]));
        }
        return max;
    }

    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int i = 0; i < matrix[0].length; i++) {
            grid[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i - 1][j] + 1;
                }
            }
        }
    }

    private int largestRectangleArea(int[] heights) {
        int length = heights.length, h = 0, w = 0, maxArea = 0, curIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (curIndex < length) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[curIndex]) {
                h = heights[stack.pop()];
                w = stack.isEmpty() ? curIndex : curIndex - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(curIndex++);
        }
        while (!stack.isEmpty()) {
            h = heights[stack.pop()];
            w = stack.isEmpty() ? length : length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
