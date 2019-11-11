package com.hjx.leetcode.problem0113;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void pathSum() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);

        node1.left = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        List<List<Integer>> result = solution.pathSum(root, 22);
        result.forEach(item -> System.out.println(item.toString()));
    }
}