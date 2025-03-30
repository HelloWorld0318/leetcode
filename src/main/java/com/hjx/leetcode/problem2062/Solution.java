package com.hjx.leetcode.problem2062;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countVowelSubstrings(String word) {
        if (word == null || word.length() < 5) {
            return 0;
        }
        //滑动窗口统计：对每个元音段使用滑动窗口技术。维护一个字典count记录当前窗口内各元音的出现次数，变量unique记录当前窗口内的不同元音数量。
        //当unique等于5时，调整左指针直到窗口不再包含所有元音，统计有效子串数量。
        int cnt = 0;
        int left = 0, right = 0;
        int unique = 0;
        int newLeft = 0;
        Map<Character, Integer> vowelCountMap = new HashMap<>((int) (5 / 0.75) + 1);
        vowelCountMap.put('a', 0);
        vowelCountMap.put('o', 0);
        vowelCountMap.put('e', 0);
        vowelCountMap.put('u', 0);
        vowelCountMap.put('i', 0);

        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (vowelCountMap.containsKey(cur)) {
                //变量unique记录当前窗口内的不同元音数量。
                vowelCountMap.put(cur, vowelCountMap.get(cur) + 1);
                if (vowelCountMap.get(cur) == 1) {
                    unique++;
                }
                //当unique等于5时，调整左指针直到窗口不再包含所有元音，统计有效子串数量。
                while (unique == 5) {
                    char leftCh = word.charAt(newLeft);
                    vowelCountMap.put(leftCh, vowelCountMap.get(leftCh) - 1);
                    if (vowelCountMap.get(leftCh) == 0) {
                        unique--;
                    }
                    newLeft++;
                }
                cnt += (newLeft - left);
            } else {
                //重新寻找元音段
                left = i + 1;
                newLeft = left;
                unique = 0;
                vowelCountMap.forEach((k, v) -> vowelCountMap.put(k, 0));
            }
        }
        return cnt;
    }
}
