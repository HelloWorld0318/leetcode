package com.hjx.leetcode.problem0547;

public class Solution {

    public int findCircleNum(int[][] M) {
        int count = 0;
        if (M != null && M.length != 0) {
            int[] visited = new int[M.length];
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visit, int number) {
        visit[number] = 1;
        for (int i = 0; i < M[number].length; i++) {
            if (M[number][i] == 1 && visit[i] == 0) {
                dfs(M, visit, i);
            }
        }
    }
}
