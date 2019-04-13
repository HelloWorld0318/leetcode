package com.hjx.leetcode.problem0135;

public class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int[] candy = new int[ratings.length];
        int increment = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = increment++;
            } else {
                increment = 1;
            }
        }
        increment = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], increment++);
            } else {
                increment = 1;
            }
        }
        for (int i = 0; i < candy.length; i++) {
            result += candy[i];
        }
        return result + ratings.length;
    }
}
