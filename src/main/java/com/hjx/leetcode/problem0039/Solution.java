package com.hjx.leetcode.problem0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length != 0) {
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs(int[] candidates, int remaining, int index, List<Integer> temp, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 提前结束剪枝
            if (remaining < candidates[i]) {
                return;
            }
            temp.add(candidates[i]);
            dfs(candidates, remaining - candidates[i], i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
