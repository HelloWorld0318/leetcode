package com.hjx.leetcode.problem0139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

    /**
     * 字典
     */
    private Set<String> wordDict = new HashSet<>();

    /**
     * 备忘录，memo[i]表示 s[i...]是否可以由字典构成，-1表示未开始计算，0表示不行，1表示可以
     */
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        this.memo = new int[s.length()];
        //初始化备忘录数组
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    /**
     * s[i...]是否可以由字典构成
     *
     * @param s 字符串s
     * @param i 字符串s中的索引i
     * @return 是否可以由字典内的字符串构成
     */
    private boolean dp(String s, int i) {
        if (i == s.length()) {
            return true;
        }
        //看一下备忘录里面是否已经计算过了，如果计算过了，那么就不用再计算了。
        if (memo[i] != -1) {
            return memo[i] != 0;
        }
        // 遍历 s[i..] 的所有前缀
        for (int len = 1; i + len <= s.length(); len++) {
            String prefix = s.substring(i, i + len);
            // 看看哪些前缀存在 wordDict 中
            if (wordDict.contains(prefix)) {
                // 找到一个单词匹配 s[i..i+len)
                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                boolean subProblem = dp(s, i + len);
                if (subProblem) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        // s[i..] 无法被拼出
        memo[i] = 0;
        return false;
    }

}
