package com.hjx.leetcode.problem0547;

public class Solution {

    public int findCircleNum(int[][] M) {
        DisjointSet disjointSet = new DisjointSet(M.length);
        // 使用并查集的方法实现
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.getCount();
    }

    private void dfs(int[][] M, int[] visit, int index) {
        visit[index] = 1;
        for (int i = 0; i < M[index].length; i++) {
            if (M[index][i] == 1 && visit[i] == 0) {
                dfs(M, visit, i);
            }
        }
    }

    public int findCircleNumDfsMethod(int[][] M) {
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
}
