package com.hjx.leetcode.problem0887;

import java.util.Arrays;

public class Solution {


    //动态规划的特性，穷举加备忘录/DP table 优化，真的没啥新意。
    private int[][] memo;

    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(k, n);
    }

    /**
     * k个鸡蛋，n层楼的结果
     * <p>
     * dp(k,n) = min{max{dp(k-1,i-1),dp(k,n-i)}+1},0<=i<=n
     *
     * @param k k个鸡蛋
     * @param n n层楼
     * @return 要确定f确切的值的最小操作次数
     */
    private int dp(int k, int n) {
        if (k == 1) {
            //只剩下一个鸡蛋的时候，那么需要遍历所有的楼层
            return n;
        }
        if (n == 0) {
            //楼层等于0的时候，不需要扔鸡蛋，对应的操作次数就是0
            return 0;
        }
        if (memo[k][n] != -1) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
//        超时的代码
//        for (int i = 1; i <= n; i++) {
//            res = Math.min(res,
//                    //在碎了和没碎中选取最坏的情况，最两个里面的最大值，+1是因为这里面在第i层操作了一次
//                    1 + Math.max(dp(k - 1, i - 1), //碎了
//                            dp(k, n - i)//没有碎
//                    ));
//        }
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //在mid位置分为了鸡蛋碎了和没有碎共两种case
            int broken = dp(k - 1, mid - 1);
            int notBroken = dp(k, n - mid);
            if (broken > notBroken) {
                high = mid - 1;
                res = Math.min(broken + 1, res);
            } else {
                low = mid + 1;
                res = Math.min(notBroken + 1, res);
            }
        }
        memo[k][n] = res;
        return res;
    }
}
