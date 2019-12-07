package com.hjx.leetcode.problem0315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private int smallCount = 0;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>(nums.length * 3);
        if (nums != null && nums.length > 0) {
            TreeNode root = new TreeNode(nums[nums.length - 1]);
            ans.add(0);
            for (int i = nums.length - 2; i > -1; i--) {
                smallCount = 0;
                bstInsert(root, new TreeNode(nums[i]));
                ans.add(smallCount);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public void bstInsert(TreeNode root, TreeNode node) {
        if (root.val >= node.val) {
            root.count++;
            if (root.left == null) {
                root.left = node;
            } else {
                bstInsert(root.left, node);
            }
        } else {
            smallCount += root.count + 1;
            if (root.right == null) {
                root.right = node;
            } else {
                bstInsert(root.right, node);
            }
        }
    }
}

class TreeNode {
    public int val;
    /**
     * 二叉树左子树中节点的个数
     */
    public int count;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.count = 0;
        left = null;
        right = null;
    }
}
