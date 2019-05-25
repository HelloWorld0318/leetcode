package com.hjx.leetcode.problem0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    private static final Set<Character> OPERATORS = new HashSet<>(5);
    private static final Map<String, List<Integer>> MEMO = new HashMap<>();

    static {
        OPERATORS.add('+');
        OPERATORS.add('-');
        OPERATORS.add('*');
    }

    public List<Integer> diffWaysToCompute(String input) {
        if (MEMO.containsKey(input)) {
            return MEMO.get(input);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (OPERATORS.contains(input.charAt(i))) {
                for (int leftValue : diffWaysToCompute(input.substring(0, i))) {
                    for (int rightValue : diffWaysToCompute(input.substring(i + 1))) {
                        ans.add(compute(input.charAt(i), leftValue, rightValue));
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(input));
        }
        MEMO.put(input, ans);
        return ans;
    }

    public int compute(char operator, int number1, int number2) {
        if (operator == '+') {
            return number1 + number2;
        } else if (operator == '-') {
            return number1 - number2;
        } else {
            return number1 * number2;
        }
    }
}

