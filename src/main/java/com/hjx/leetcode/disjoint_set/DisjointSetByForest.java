package com.hjx.leetcode.disjoint_set;

/**
 * @author houjinxiang
 * 并查集
 */
public class DisjointSetByForest {

    private int[] ids;

    private int[] size;

    private int count;

    public DisjointSetByForest(int n) {
        ids = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public int find(int p) {
        while (p != ids[p]) {
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = ids[p];
        int j = ids[q];
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            ids[i] = j;
            size[j] += size[i];
        } else {
            ids[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}
