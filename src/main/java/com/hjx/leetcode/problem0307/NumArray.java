package com.hjx.leetcode.problem0307;

/**
 * @author houjinxiang
 * 用点线段树
 */
public class NumArray {

    /**
     * 线段树数组
     */
    private int[] value;

    /**
     * 原始数组
     */
    private int[] nums;

    /**
     * 原始数组的最右索引
     */
    private int rightEnd;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        this.nums = nums;
        // 一般线段树数组大小是原始数组大小长度的4倍
        value = new int[nums.length * 4];
        buildSegmentTree(0, 0, nums.length - 1);
        rightEnd = nums.length - 1;
    }

    public void update(int i, int val) {
        updateSegmentTree(0, 0, rightEnd, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeSegmentTree(0, 0, rightEnd, i, j);
    }

    /**
     * 构建线段树
     *
     * @param pos   当前线段(节点)在线段树数组(value)中的下标pos
     * @param left  当前线段的左端点left
     * @param right 当前线段的右端点right
     */
    public void buildSegmentTree(int pos, int left, int right) {
        if (left == right) {
            value[pos] = nums[left];
            return;
        }
        int mid = (left + right) >> 1;
        buildSegmentTree(pos * 2 + 1, left, mid);
        buildSegmentTree(pos * 2 + 2, mid + 1, right);
        value[pos] = value[pos * 2 + 1] + value[pos * 2 + 2];
    }

    public void printSegmentTree(int pos, int left, int right, int layer) {
        for (int i = 0; i < layer; i++) {
            System.out.print("---");
        }
        System.out.println("[" + left + " " + right + "]" + "[" + pos + "]" + " " + value[pos]);
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        printSegmentTree(pos * 2 + 1, left, mid, layer + 1);
        printSegmentTree(pos * 2 + 2, mid + 1, right, layer + 1);
    }

    /**
     * 求取区间和
     *
     * @param pos    当前线段(节点)在线段树数组(value)中的下标pos
     * @param left   当前线段的左端点left，
     * @param right  当前线段的右端点right
     * @param qleft  待求和区间的左端点qleft
     * @param qright 待求和区间的右端点qright
     * @return 待求和区间段的值
     */
    public int sumRangeSegmentTree(int pos, int left, int right, int qleft, int qright) {
        if (qleft > right || qright < left) {
            return 0;
        }
        if (qleft <= left && right <= qright) {
            return value[pos];
        }
        int mid = (left + right) / 2;
        return sumRangeSegmentTree(pos * 2 + 1, left, mid, qleft, qright) +
                sumRangeSegmentTree(pos * 2 + 2, mid + 1, right, qleft, qright);
    }

    /**
     * 线段树的更新
     *
     * @param pos      当前线段(节点)在线段树数组(value)中的下标pos
     * @param left     当前线段树的左端点
     * @param right    当前线段树的右端点
     * @param index    待更新的数组位置下标Index
     * @param newValue 更新值value
     */
    public void updateSegmentTree(int pos, int left, int right, int index, int newValue) {
        if (left == right && left == index) {
            value[pos] = newValue;
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) {
            updateSegmentTree(pos * 2 + 1, left, mid, index, newValue);
        } else {
            updateSegmentTree(pos * 2 + 2, mid + 1, right, index, newValue);
        }
        value[pos] = value[pos * 2 + 1] + value[pos * 2 + 2];
    }
}
