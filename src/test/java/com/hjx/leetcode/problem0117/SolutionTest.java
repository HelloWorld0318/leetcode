package com.hjx.leetcode.problem0117;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void connect() {
        Solution solution = new Solution();
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node7 = new Node(7, null, null, null);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        Node root = solution.connect(node1);
        System.out.println(root);
    }
}