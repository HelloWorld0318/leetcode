package com.hjx.leetcode.problem0140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    //用回溯算法就不好加备忘录了，因为回溯算法的 track 变量仅维护了从根节点到当前节点走过的路径，并没有记录子树的信息。
    //所以，这种题目想要消除重叠子问题的话一般要用分解问题的思路，利用函数返回值来更新备忘录
    private List<String>[] memo;

    private Set<String> wordDict;


    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new List[s.length()];
        return dp(s, 0);
    }

    /**
     * 定义：返回用 wordDict 构成 s[i..] 的所有可能
     *
     * @param s
     * @param i
     * @return
     */
    private List<String> dp(String s, int i) {
        List<String> result = new ArrayList<>();
        if (i == s.length()) {
            result.add("");
            return result;
        }
        //备忘录
        if (memo[i] != null) {
            return memo[i];
        }
        for (int len = 1; i + len <= s.length(); len++) {
            String prefix = s.substring(i, i + len);
            if (wordDict.contains(prefix)) {
                List<String> subProblem = dp(s, i + len);
                for (String s1 : subProblem) {
                    if (s1.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(String.join(" ", prefix, s1));
                    }
                }
            }
        }
        memo[i] = result;
        return result;
    }
}
