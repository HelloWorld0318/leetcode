package com.hjx.leetcode.problem1094;

/**
 * @author houjinxiang
 */
public class Difference {

    private int[] diff;

    public Difference(int[] nums) {
        assert nums != null && nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - diff[i - 1];
        }
    }

    /**
     * 给闭区间 [i, j] 增加 val（可以是负数）
     *
     * @param i   左端点
     * @param j   右端点
     * @param val 所加的值
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            //当j+1>=diff.length 时，说明是对 nums[i] 及以后的整个数组都进行修改，那么就不需要再给 diff 数组减 val 了。
            diff[j + 1] -= val;
        }
    }

    /**
     * 返回结果数组
     *
     * @return 结果数组
     */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            //diff[i] = res[i] - res[i-1];
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
