package com.hjx.leetcode.problem0108;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void sortedArrayToBST() {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = solution.sortedArrayToBST(nums);
        inOrder(treeNode);
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }
}