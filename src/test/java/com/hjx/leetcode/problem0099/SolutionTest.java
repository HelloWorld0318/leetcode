package com.hjx.leetcode.problem0099;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testRecoverTree() {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;
        node4.left = node2;

        solution.recoverTree(node3);
        System.out.println(node3.val);
    }
}