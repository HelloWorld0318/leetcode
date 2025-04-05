package com.hjx.leetcode.data.structure.dp;

/**
 * 解决0-1背包问题
 *
 * @author houjinxiang
 */
public class Knapsack {
    /**
     * N = 3, W = 4
     * wt = [2, 1, 3]
     * val = [4, 2, 3]
     * dp[i][w] 的定义如下：对于前i个物品，当前背包的容量为w，这种情况下可以装的最大价值是 dp[i][w]。
     * 比如说，如果 dp[3][5] = 6，其含义为：对于给定的一系列物品中，若只对前 3 个物品进行选择，当背包容量为 5 时，最多可以装下的价值为 6。
     * 根据这个定义，我们想求的最终答案就是 dp[N][W]。base case 就是 dp[0][..] = dp[..][0] = 0，因为没有物品或者背包没有空间的时候，能装的最大价值就是 0。
     * int[][] dp[N+1][W+1]
     * dp[0][..] = 0
     * dp[..][0] = 0
     *
     * for i in [1..N]:
     *     for w in [1..W]:
     *         dp[i][w] = max(
     *             dp[i-1][w],//把物品 i 装进背包,
     *             dp[i-1][w - wt[i-1]] + val[i-1]//不把物品 i 装进背包
     *         ) + val[i-1]
     * return dp[N][W]
     */

    /**
     * 0-1背包问题：给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]。
     * 现在让你用这个背包装物品，每个物品只能用一次，在不超过背包容量的前提下，最多能装的价值是多少？
     *
     * @param W   背包的重量
     * @param N   物品的个数
     * @param wt  每个物品的重量
     * @param val 每个物品的价值量
     * @return 在不超过背包容量的前提下，最多能装的价值
     */
    int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

}
