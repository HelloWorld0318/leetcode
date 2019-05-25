package com.hjx.leetcode.problem0052;

public class Solution {
    private static final int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    private static final int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static final int DIRECTION_COUNT = 8;

    private int result = 0;

    public int totalNQueens(int n) {
        if (n != 0) {
            int[][] mark = new int[n][n];
            char[][] chessboard = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mark[i][j] = 0;
                    chessboard[i][j] = '.';
                }
            }
            generate(0, n, mark, chessboard);
        }
        return result;
    }

    public void generate(int k, int n, int[][] mark, char[][] chessboard) {
        if (k == n) {
            result++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (mark[k][j] == 0) {
                chessboard[k][j] = 'Q';
                int[][] mark_temp = cloneMarkArray(mark);
                putDownTheQueen(k, j, mark, chessboard);
                generate(k + 1, n, mark, chessboard);
                // 回溯
                mark = mark_temp;
                chessboard[k][j] = '.';
            }
        }

    }

    public void putDownTheQueen(int x, int y, int[][] mark, char[][] chessboard) {
        mark[x][y] = 1;
        // 从8个方向向外延伸1到N-1
        for (int i = 0; i < DIRECTION_COUNT; i++) {
            for (int j = 1; j < mark.length; j++) {
                int newX = x + j * dx[i];
                int newY = y + j * dy[i];
                // 检查新的位置是否在棋盘内
                if (newX >= 0 && newX < mark.length && newY >= 0 && newY < mark.length) {
                    mark[newX][newY] = 1;
                } else {
                    break;
                }
            }
        }
    }

    public int[][] cloneMarkArray(int[][] array) {
        int[][] markArray = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                markArray[i][j] = array[i][j];
            }
        }
        return markArray;
    }
}
