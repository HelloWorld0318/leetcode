package com.hjx.leetcode.problem0290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] charArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if (charArray.length != strArray.length) {
            return false;
        }
        Map<Character, String> patternChar2Str = new HashMap<>((int) (charArray.length + 1 / 0.75));
        Map<String, Character> str2patternChar = new HashMap<>((int) (charArray.length + 1 / 0.75));

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            String string = strArray[i];
            if (patternChar2Str.containsKey(ch) || str2patternChar.containsKey(string)) {
                if (!string.equals(patternChar2Str.get(ch)) || ch != str2patternChar.get(string)) {
                    return false;
                }
            } else {
                patternChar2Str.put(ch, string);
                str2patternChar.put(string, ch);
            }
        }
        return true;
    }
}
