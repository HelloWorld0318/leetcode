package com.hjx.leetcode.problem0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            Map<Character, String> char2Str = new HashMap<>((int) (9 / 0.75 + 1));
            char2Str.put('2', "abc");
            char2Str.put('3', "def");
            char2Str.put('4', "ghi");
            char2Str.put('5', "jkl");
            char2Str.put('6', "mno");
            char2Str.put('7', "pqrs");
            char2Str.put('8', "tuv");
            char2Str.put('9', "wxyz");
            dfs(digits, 0, "", result, char2Str);
        }
        return result;
    }

    private void dfs(String digits, int curIndex, String curStr, List<String> result, Map<Character, String> char2Str) {
        if (curIndex == digits.length()) {
            result.add(curStr);
            return;
        }
        if ('0' == digits.charAt(curIndex) || '1' == digits.charAt(curIndex)) {
            dfs(digits, curIndex + 1, curStr + "", result, char2Str);
            return;
        }
        for (char ch : char2Str.get(digits.charAt(curIndex)).toCharArray()) {
            dfs(digits, curIndex + 1, curStr + ch, result, char2Str);
        }
    }
}
