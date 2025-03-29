package com.hjx.leetcode.problem0079;

public class Solution {

    private boolean isExist = false;

    /**
     * 方向数组（上，下，左，右）
     */
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!isExist) {
                    dsf(board, i, j, word, 0);
                }
            }
        }
        return isExist;
    }

    public void dsf(char[][] board, int i, int j, String word, int k) {
        if (isExist || visited[i][j] || board[i][j] != word.charAt(k)) {
            return;
        }
        visited[i][j] = true;
        if (k == word.length() - 1) {
            isExist = true;
            return;
        }
        for (int m = 0; m < 4; m++) {
            int newX = i + dx[m];
            int newY = j + dy[m];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }
            dsf(board, newX, newY, word, k + 1);
        }
        visited[i][j] = false;
    }
}
