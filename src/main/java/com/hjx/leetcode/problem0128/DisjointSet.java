package com.hjx.leetcode.problem0128;

public class DisjointSet {

    private int count;

    private int[] size;

    private int[] ids;

    public DisjointSet(int n) {
        count = n;
        size = new int[n];
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    public int findSet(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public void union(int k, int j) {
        int value1 = findSet(k);
        int value2 = findSet(j);
        if (value1 != value2) {
            if (size[value1] > size[value2]) {
                ids[value2] = ids[value1];
                size[value1] += size[value2];
            } else {
                ids[value1] = ids[value2];
                size[value2] += size[value1];
            }
        }
        count--;
    }

    public int[] getSize() {
        return size;
    }
}
