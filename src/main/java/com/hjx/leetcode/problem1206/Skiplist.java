package com.hjx.leetcode.problem1206;

import java.util.Random;

public class Skiplist {
    static final int MAX_LEVEL = 10;
    private SkipListNode dummy;
    private Random random;

    public Skiplist() {
        this.dummy = new SkipListNode(-1, MAX_LEVEL);
        this.random = new Random();
    }

    public void find(int target, SkipListNode[] ns) {
        SkipListNode cur = dummy;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
            ns[i] = cur;
        }
    }

    public boolean search(int target) {
        SkipListNode[] ns = new SkipListNode[MAX_LEVEL];
        find(target, ns);
        return ns[0].next[0] != null && ns[0].next[0].val == target;
    }

    public void add(int num) {
        SkipListNode[] ns = new SkipListNode[MAX_LEVEL];
        find(num, ns);
        SkipListNode node = new SkipListNode(num, MAX_LEVEL);
        for (int i = 0; i < MAX_LEVEL; i++) {
            node.next[i] = ns[i].next[i];
            ns[i].next[i] = node;
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int num) {
        SkipListNode[] ns = new SkipListNode[MAX_LEVEL];
        find(num, ns);
        SkipListNode node = ns[0].next[0];
        if (node == null || node.val != num) {
            return false;
        }
        for (int i = 0; i < MAX_LEVEL && ns[i].next[i] == node; i++) {
            ns[i].next[i] = ns[i].next[i].next[i];
        }
        return true;
    }

    public void print() {
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            SkipListNode cur = dummy;
            while (cur != null) {
                System.out.print(cur.val + "->");
                cur = cur.next[i];
            }
            System.out.println();
        }
    }

    private class SkipListNode {
        int val;
        SkipListNode[] next;

        public SkipListNode(int val, int maxLevel) {
            this.val = val;
            this.next = new SkipListNode[maxLevel];
        }
    }
}