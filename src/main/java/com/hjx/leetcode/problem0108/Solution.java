package com.hjx.leetcode.problem0108;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(0, nums.length - 1, nums);
    }

    public TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        // 自顶向下的方法构造二叉树
        if (start == end) {
            TreeNode treeNode = new TreeNode(nums[start]);
            return treeNode;
        } else if (start > end) {
            return null;
        } else {
            int medium = (start + end) >> 1;
            TreeNode treeNode = new TreeNode(nums[medium]);
            treeNode.left = sortedArrayToBST(start, medium - 1, nums);
            treeNode.right = sortedArrayToBST(medium + 1, end, nums);
            return treeNode;
        }
    }
}