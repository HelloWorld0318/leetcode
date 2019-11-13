package com.hjx.leetcode.problem0101;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isSymmetric() {
        Solution solution = new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);

        node1.left = node21;
        node1.right = node22;


        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(3);

        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;

        boolean result = solution.isSymmetric(node1);
        System.out.println(result);
    }
}