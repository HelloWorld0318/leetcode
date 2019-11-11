package com.hjx.leetcode.problem0130;

import org.junit.Test;


public class SolutionTest {

    @Test
    public void solve() {
        Solution solution = new Solution();
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}