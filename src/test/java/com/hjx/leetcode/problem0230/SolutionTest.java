package com.hjx.leetcode.problem0230;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void kthSmallest() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(2);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;

        treeNode1.right = treeNode2;


        Solution solution = new Solution();
        int ans = solution.kthSmallest(treeNode3, 1);

        Assert.assertEquals(ans, 1);
    }
}