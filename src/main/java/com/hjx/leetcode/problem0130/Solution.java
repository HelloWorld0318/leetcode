package com.hjx.leetcode.problem0130;

public class Solution {

    /**
     * 上/下/左/右
     */
    private int[] dx = {-1, +1, 0, 0};
    private int[] dy = {0, 0, -1, +1};

    public void solve(char[][] board) {
        // "模板题"
        // 扫矩阵的四条边，如果有O，则用 DFS 遍历，将所有连着的O都变成另一个字符，比如 $，
        // 这样剩下的O都是被包围的，然后将这些O变成X，把$变回O就行了
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column) {
        if (board[row][column] == 'O') {
            board[row][column] = '$';
            int x, y;
            for (int i = 0; i < 4; i++) {
                x = row + dx[i];
                y = column + dy[i];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    dfs(board, x, y);
                }
            }
        }
    }
}
