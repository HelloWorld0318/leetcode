package com.hjx.leetcode.problem1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while (label >= 1) {
            res.add(label);
            label /= 2;
            int[] range = getCurLevelRange(log(label));
            // 由于之字形分布，根据上层的节点取值范围，修正父节点
            label = range[1] - (label - range[0]);
        }
        Collections.reverse(res);
        return res;
    }

    public int[] getCurLevelRange(int level) {
        int p = (int) Math.pow(2, level);
        return new int[]{p, 2 * p - 1};
    }

    public int log(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
