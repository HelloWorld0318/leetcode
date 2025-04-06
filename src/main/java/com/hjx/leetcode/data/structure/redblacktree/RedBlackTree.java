package com.hjx.leetcode.data.structure.redblacktree;

/**
 * 定义红黑树类
 */
public class RedBlackTree {
    /**
     * 红黑树节点类
     */
    private class RedBlackTreeNode {

        public enum Color {RED, BLACK}

        public int key;
        public String value;
        public Color color;
        public RedBlackTreeNode left = null;
        public RedBlackTreeNode right = null;
        public RedBlackTreeNode parent = null;

        public RedBlackTreeNode(int key, String value) {
            this.key = key;
            this.value = value;
            // 新插入的节点默认为红色
            this.color = Color.RED;
        }
    }

    private RedBlackTreeNode root;

    // 左旋操作
    private void leftRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // 右旋操作
    private void rightRotate(RedBlackTreeNode y) {
        RedBlackTreeNode x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    // 插入修复函数
    private void insertFixup(RedBlackTreeNode z) {
        while (z != null && z != root && z.parent != null && z.parent.color == RedBlackTreeNode.Color.RED) {
            if (z.parent == z.parent.parent.left) {
                RedBlackTreeNode y = z.parent.parent.right;
                if (y != null && y.color == RedBlackTreeNode.Color.RED) {
                    // Case 1: Uncle is red
                    z.parent.color = RedBlackTreeNode.Color.BLACK;
                    y.color = RedBlackTreeNode.Color.BLACK;
                    z.parent.parent.color = RedBlackTreeNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        // Case 2: Current node is right child and uncle is black or null
                        z = z.parent;
                        leftRotate(z);
                    }
                    // Case 3: Current node is left child and uncle is black or null
                    z.parent.color = RedBlackTreeNode.Color.BLACK;
                    z.parent.parent.color = RedBlackTreeNode.Color.RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                // Mirror image of the above code for right subtree
                RedBlackTreeNode y = z.parent.parent.left;
                if (y != null && y.color == RedBlackTreeNode.Color.RED) {
                    // Case 1: Uncle is red
                    z.parent.color = RedBlackTreeNode.Color.BLACK;
                    y.color = RedBlackTreeNode.Color.BLACK;
                    z.parent.parent.color = RedBlackTreeNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        // Case 2: Current node is left child and uncle is black or null
                        z = z.parent;
                        rightRotate(z);
                    }
                    // Case 3: Current node is right child and uncle is black or null
                    z.parent.color = RedBlackTreeNode.Color.BLACK;
                    z.parent.parent.color = RedBlackTreeNode.Color.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = RedBlackTreeNode.Color.BLACK;
    }

    public void insert(int key, String value) {
        RedBlackTreeNode node = new RedBlackTreeNode(key, value);
        RedBlackTreeNode y = null;
        RedBlackTreeNode x = root;

        // 寻找插入位置
        while (x != null) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // 插入新节点
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        // 调整树结构以保持红黑树性质
        insertFixup(node);
    }

    // 中序遍历打印树结构（用于验证正确性）
    private void inOrderTraversal(RedBlackTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("Key: " + node.key + ", Color: " + node.color);
            inOrderTraversal(node.right);
        }
    }

    public void printTree() {
        inOrderTraversal(root);
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(30, "Thirty");
        tree.insert(15, "Fifteen");
        tree.insert(25, "Twenty-Five");

        // 打印树结构
        tree.printTree();
    }
}

