package com.hjx.leetcode.data.structure.disjoint_set;

import java.util.Arrays;

/**
 * @author houjinxiang
 * 数组实现并查集
 */
public class DisjointSetByArray {

    /**
     * 数组的下标表示他是第几个元素，数组里面的元素表示下标i(元素i)属于哪一个集合
     */
    private int ids[];

    public DisjointSetByArray(int n) {
        // 设置表示集合数组id[i]，初始时每个元素构成一个单元素的集合，
        // 编号为i的元素属于集合i
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    int find(int p) {
        // 查询元素p属于哪个集合时直接返回id[i]
        return ids[p];
    }

    void union(int p, int q) {
        // 时间复杂度为O(n)
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            // 合并时，若两个集合属于同一个集合，则直接返回
            return;
        }
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                // 将所有属于pid集合的全部改为qid对应的集合
                ids[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        int elementCount = 8;
        DisjointSetByArray disjointSet = new DisjointSetByArray(elementCount);

        // [0, 1, 2, 3, 4, 0, 6, 7]
        disjointSet.union(5, 0);
        System.out.println(Arrays.toString(disjointSet.ids));
        System.out.println("------------------------------");
        // [2, 1, 2, 3, 4, 2, 6, 7]
        disjointSet.union(5, 2);
        System.out.println(Arrays.toString(disjointSet.ids));
        System.out.println("------------------------------");
        // [2, 1, 2, 3, 4, 2, 6, 7]
        disjointSet.union(2, 5);
        System.out.println(Arrays.toString(disjointSet.ids));
        System.out.println("------------------------------");
        // [3, 1, 3, 3, 4, 3, 6, 7]
        disjointSet.union(2, 3);
        System.out.println(Arrays.toString(disjointSet.ids));
    }
}