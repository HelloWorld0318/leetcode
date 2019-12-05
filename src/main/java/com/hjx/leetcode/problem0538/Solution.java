package com.hjx.leetcode.problem0538;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        inOrder(cur);
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        int temp = sum + root.val;
        root.val += sum;
        sum = temp;
        inOrder(root.left);
    }
}
