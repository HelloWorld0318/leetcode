package com.hjx.leetcode.problem0200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 上，下，左，右
     */
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        int numOfLands = 0;
        if (grid != null && grid.length > 0 && grid[0].length > 0) {
            int[][] mark = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && mark[i][j] == 0) {
                        dfs(grid, mark, i, j);
                        numOfLands++;
                    }
                }
            }
        }
        return numOfLands;
    }

    public void dfs(char[][] grid, int[][] mark, int x, int y) {
        // 深度优先搜索
        mark[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < mark.length && newY >= 0 && newY < mark[newX].length) {
                if (mark[newX][newY] == 0 && grid[newX][newY] == '1') {
                    dfs(grid, mark, newX, newY);
                }
            }
        }
    }

    public void bfs(char[][] grid, int[][] mark, int x, int y) {
        // 宽度优先搜索队列
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        mark[x][y] = 1;
        while (!queue.isEmpty()) {
            x = queue.peek().x;
            y = queue.peek().y;
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < mark.length && newY >= 0 && newY < mark[newX].length) {
                    if (mark[newX][newY] == 0 && grid[newX][newY] == '1') {
                        queue.offer(new Pair(newX, newY));
                        mark[newX][newY] = 1;
                    }
                }
            }
        }
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
