package com.hjx.leetcode.problem0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n != 0) {
            dfs(n, 0, 0, "", ans);
        }
        return ans;
    }

    private void dfs(int n, int left, int right, String item, List<String> ans) {
        if (left == n && right == n) {
            ans.add(item);
            return;
        }
        if (left <= n) {
            dfs(n, left + 1, right, item + '(', ans);
        }
        if (right < left) {
            dfs(n, left, right + 1, item + ')', ans);
        }
    }
}
