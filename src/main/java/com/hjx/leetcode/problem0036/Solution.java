package com.hjx.leetcode.problem0036;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 判断行
        for (int row = 0; row < 9; row++) {
            boolean[] isValid = new boolean[9];
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {
                    if (isValid[board[row][column] - '1']) {
                        return false;
                    } else {
                        isValid[board[row][column] - '1'] = true;
                    }
                }
            }
        }
        // 判断列
        for (int column = 0; column < 9; column++) {
            boolean[] isValid = new boolean[9];
            for (int row = 0; row < 9; row++) {
                if (board[row][column] != '.') {
                    if (isValid[board[row][column] - '1']) {
                        return false;
                    } else {
                        isValid[board[row][column] - '1'] = true;
                    }
                }
            }
        }

        // Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                boolean[] isValid = new boolean[9];
                for (int i = row; i < row + 3; i++) {
                    for (int j = column; j < column + 3; j++) {
                        if (board[i][j] != '.') {
                            if (isValid[board[i][j] - '1']) {
                                return false;
                            } else {
                                isValid[board[i][j] - '1'] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
