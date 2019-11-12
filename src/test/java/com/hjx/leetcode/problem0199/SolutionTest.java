package com.hjx.leetcode.problem0199;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rightSideView() {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        List<Integer> integerList = solution.rightSideView(node1);
        System.out.println(integerList);
    }
}