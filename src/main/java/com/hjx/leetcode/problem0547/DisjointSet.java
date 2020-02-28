package com.hjx.leetcode.problem0547;

class  DisjointSet {

    private int[] ids;

    private int[] size;

    private Integer count;

    public DisjointSet(int n) {
        count = n;
        ids = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    public int findSet(int p) {
        while (p != ids[p]) {
            // 路径压缩
            // p的父节点id[p]更新为id[p]的父节点ids[ids[p]]
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = findSet(p);
        int j = findSet(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            // 规模小的向规模大的合并
            size[j] += size[i];
            ids[i] = ids[j];
        } else {
            size[i] += size[j];
            ids[j] = ids[i];
        }
        count--;
    }

    public Integer getCount() {
        return count;
    }

}
