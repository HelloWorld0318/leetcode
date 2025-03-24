package com.hjx.leetcode.problem0518;

public class Solution {
    /**
     * 转换为完全背包问题
     * 1.第一步要明确两点，「状态」和「选择」。
     * 状态有两个，背包的容量和可选择的物品，选择就是 装进背包 或者 不装进背包,背包问题的套路都是这样。
     * <p>
     * 2.第二步要明确 dp 数组的定义。
     * dp[i][j]表示：若只使用前i个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
     * <p>
     * 3.第三步，根据「选择」，思考状态转移的逻辑。
     * <p>
     * bad case:dp[0][j](1<=j<=amount) = 0,表示，没有物品可供选择的时候，要填满容量为j的背包肯定不可能
     * dp[i][0] = 1,表示前i个物品可供先泽，此时背包的容量为0,那么什么都不做就是唯一的一种凑法。，（不选择也算是一个构成方式）
     * <p>
     * dp[i][j] = dp[i][j-coins[i]] (使用coins[i]，可以使用无数次) + dp[i-1][j](最终的结果中不使用coins[i])
     * <p>
     * dp[n][amount]就是最终的结果
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
