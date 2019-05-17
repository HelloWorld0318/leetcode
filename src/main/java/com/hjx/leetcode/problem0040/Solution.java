package com.hjx.leetcode.problem0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length != 0) {
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs(int[] candidates, int index, int remaining, List<Integer> temp, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                return;
            }
            // how to remove duplicate 1. set 2.disallow same number in same depth
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates, i + 1, remaining - candidates[i], temp, result);
            temp.remove(temp.size() - 1);

        }
    }
}
