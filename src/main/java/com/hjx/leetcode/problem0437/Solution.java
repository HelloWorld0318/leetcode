package com.hjx.leetcode.problem0437;

import com.hjx.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Long, Integer> preSum2Count = new HashMap<>();
    private int res = 0;
    private long targetSum = 0;
    private long pathSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        preSum2Count.put(0L, 1);
        travel(root);
        return res;
    }

    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        pathSum += root.val;
        res += preSum2Count.getOrDefault(pathSum - targetSum, 0);
        preSum2Count.put(pathSum, preSum2Count.getOrDefault(pathSum, 0) + 1);

        travel(root.left);
        travel(root.right);

        preSum2Count.put(pathSum, preSum2Count.get(pathSum) - 1);
        pathSum -= root.val;
    }
}