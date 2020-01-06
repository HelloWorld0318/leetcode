package com.hjx.leetcode.problem0200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 上，下，左，右
     */
    private static final int[] dx = {-1, +1, 0, 0};
    private static final int[] dy = {0, 0, -1, +1};

    public int numIslands(char[][] grid) {
        int numOfLands = 0;
        if (grid != null && grid.length > 0) {
            int[][] mark = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 是陆地且没有访问过
                    if (grid[i][j] == '1' && mark[i][j] == 0) {
                        bfs(grid, mark, i, j);
                        numOfLands++;
                    }
                }
            }
        }
        return numOfLands;
    }

    public void dfs(char[][] grid, int[][] mark, int x, int y) {
        mark[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                // 是陆地且没有访问过
                if (mark[newX][newY] == 0 && grid[newX][newY] == '1') {
                    dfs(grid, mark, newX, newY);
                }
            }
        }
    }

    public void bfs(char[][] grid, int[][] mark, int x, int y) {
        mark[x][y] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.x;
            int column = pair.y;
            for (int i = 0; i < 4; i++) {
                int newX = row + dx[i];
                int newY = column + dy[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    // 是陆地且没有访问过
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

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
