package com.hjx.leetcode.problem0473;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean makesquareBitOperation(int[] nums) {
        // 数量小于4的时候返回假
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;

        List<Integer> okSubSet = new ArrayList<>();
        List<Integer> okHarf = new ArrayList<>();

        int all = 1 << nums.length;

        for (int i = 0; i < all; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j];
                }
            }
            if (sum == target) {
                okSubSet.add(i);
            }
        }

        for (int i = 0; i < okSubSet.size(); i++) {
            for (int j = i + 1; j < okSubSet.size(); j++) {
                if ((okSubSet.get(i) & okSubSet.get(j)) == 0) {
                    okHarf.add(okSubSet.get(i) | okSubSet.get(j));
                }
            }
        }

        for (int i = 0; i < okHarf.size(); i++) {
            for (int j = i + 1; j < okHarf.size(); j++) {
                if ((okHarf.get(i) & okHarf.get(j)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        // 想象正方形的4条边即为4个桶，将每个火柴杆回溯的放置在每个桶中，在放完n个火柴杆后，
        // 检查4个桶中的火柴杆长度和是否相同，相同返回真，否则返回假;在回溯过程中，如果当前
        // 所有可能向后的回溯，都无法满足条件，即递归函数最终返回假。

        // 数量小于4的时候返回假
        if (nums == null || nums.length < 4) {
            return false;
        }
        int[] buckets = new int[4];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // n个火柴杆的总和对4取余需要为0，否则为假
        if (sum % 4 != 0) {
            return false;
        }
        // 从小到打
        Arrays.sort(nums);
        // 按从大到小的顺序尝试
        return generate(nums.length - 1, nums, buckets, sum / 4);
    }

    private boolean generate(int index, int[] nums, int[] buckets, int target) {
        if (index < 0) {
            return buckets[0] == target && buckets[1] == target && buckets[2] == target && buckets[3] == target;
        }
        // 在4个桶中分别尝试
        for (int i = 0; i < 4; i++) {
            if (buckets[i] + nums[index] > target) {
                continue;
            }
            // 第index个火柴放在桶i中
            buckets[i] += nums[index];
            if (generate(index - 1, nums, buckets, target)) {
                return true;
            }
            // 第index个火柴从桶中取出来
            buckets[i] -= nums[index];
        }
        return false;
    }
}
